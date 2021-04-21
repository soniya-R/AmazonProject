package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.AddToCartPage;
import org.amazon.pages.Homepage;
import org.amazon.pages.SearchResultPage;
import org.amazon.pages.SelectedItemPage;
import org.amazon.utils.SearchDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Test class for testing add 2 cart functionality
 */
public class AddToCartPageTest extends Base {

    Homepage homepage;
    SelectedItemPage selectedItemPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        homepage = new Homepage(driver);
        selectedItemPage = new SelectedItemPage(driver);
        searchResultPage = new SearchResultPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }

    /**
     * Before clicking on proceed checkout comparing price in addtocart page to
     *  price in the search result page
      */

    @Test(dataProvider = "partialSearchData", dataProviderClass = SearchDataProvider.class)
    public void TestProceedCheckoutAssertPrice(String partialWord,String keyword) {
        searchResultPage = homepage.searchFunction(partialWord,keyword);
        String priceOnSearchPage = searchResultPage.getFirstElementPrice();
        searchResultPage.getFirstImage();
        addToCartPage.checkout();
        String priceOnAddToCartPage = addToCartPage.getPriceOnAddToCartPage();
        Assert.assertEquals(priceOnAddToCartPage, priceOnSearchPage, "Price does not match");
        addToCartPage.checkout();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
