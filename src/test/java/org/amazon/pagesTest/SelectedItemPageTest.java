package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.Homepage;
import org.amazon.pages.SearchResultPage;
import org.amazon.pages.SelectedItemPage;
import org.amazon.utils.SearchDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Test class for testing selected item  page functionality
 */

public class SelectedItemPageTest extends Base {
    Homepage homepage;
    SearchResultPage searchResultPage;
    SelectedItemPage selectedItemPage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        homepage = new Homepage(driver);
        selectedItemPage = new SelectedItemPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    /**
     * Comparing price from the search result page to the SelectedItem page
     * before clicking add to cart
     */
    @Test(dataProvider = "partialSearchData", dataProviderClass = SearchDataProvider.class)
    public void TestComparePrice(String partialWord, String keyword) {

        searchResultPage = homepage.searchFunction(partialWord, keyword);
        String priceOnSearchPage = searchResultPage.getFirstElementPrice();
        searchResultPage.getFirstImage();
        String priceOnItemPage = selectedItemPage.getPriceOfItem();
        Assert.assertEquals(priceOnItemPage, priceOnSearchPage, "Price does not match");
        selectedItemPage.getAddToCart();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
