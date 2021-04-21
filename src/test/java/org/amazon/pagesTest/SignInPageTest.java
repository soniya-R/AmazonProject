package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.Homepage;
import org.amazon.pages.SignInPage;
import org.testng.annotations.*;

import java.io.IOException;

public class SignInPageTest extends Base {

    Homepage homepage;
    SignInPage signInPage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        homepage = new Homepage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    @Parameters({"userEmail", "password"})

    public void enterLogin(String email, String pwd) {

        signInPage = homepage.getSignIn();
        signInPage.setUserEmail(email);
        signInPage.getContinueButton();
        signInPage.setUserPassword(pwd);
        homepage = signInPage.getSignInButton();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
