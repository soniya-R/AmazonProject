package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.Homepage;
import org.amazon.pages.SignInPage;
import org.amazon.utils.SearchDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Test class for testing homepage functionality
 */

public class HomepageTest extends Base {

    Homepage homepage;
    SignInPage signInPage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        homepage = new Homepage(driver);
        signInPage = new SignInPage(driver);
    }

    /**
     *  Test to find if user name is diplayed on homepage after login
     */
    @Test
    @Parameters({"userEmail", "password"})
    public void testUserLoggedIn(String email, String pwd) {
        signInPage = homepage.getSignIn();
        signInPage.setUserEmail(email);
        signInPage.getContinueButton();
        signInPage.setUserPassword(pwd);
        homepage = signInPage.getSignInButton();
        Boolean isVisible = homepage.getUserNameOnHomepage();
        Assert.assertTrue(isVisible);
    }

    /**
     *   Selecting from auto suggestion when typing partial word
     */
    @Test(dataProvider ="partialSearchData",dataProviderClass = SearchDataProvider.class)
    public void test(String partialWord,String keyword) {
       homepage.searchFunction(partialWord, keyword);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
