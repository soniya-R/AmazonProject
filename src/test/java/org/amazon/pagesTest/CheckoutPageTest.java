package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
/**
 * Test class for testing checkout page functionality
 */

public class CheckoutPageTest extends Base {

    SearchResultPage searchResultPage;
    Homepage homepage;
    SignInPage signInPage;
    SelectedItemPage selectedItemPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;


    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        homepage = new Homepage(driver);
        signInPage = new SignInPage(driver);
        searchResultPage = new SearchResultPage(driver);
        selectedItemPage = new SelectedItemPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    /**
     * User login to checkout functionality and asserting value displayed in checkout page
     *   is equal to value displayed in search result page
     */

    @Test
    @Parameters({"userEmail", "password"})
    public void TestComparePriceAtCheckout(String email, String pwd) {
        signInPage = homepage.getSignIn();
        signInPage.setUserEmail(email);
        signInPage.getContinueButton();
        signInPage.setUserPassword(pwd);
        homepage = signInPage.getSignInButton();
        searchResultPage = homepage.searchFunction("qa tes","qa testing for beginners");
        String amount = searchResultPage.getFirstElementPrice();
        selectedItemPage = searchResultPage.getFirstImage();
        addToCartPage = selectedItemPage.getAddToCart();
        checkoutPage = addToCartPage.checkout();
        checkoutPage.getDeliverAddressButton();
        String finalPayableAmount = checkoutPage.getFinalAmountBeforeFinalPayment();
        System.out.println(finalPayableAmount);
        System.out.println(amount);
        Assert.assertEquals(amount,finalPayableAmount, "Amount don't match");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}