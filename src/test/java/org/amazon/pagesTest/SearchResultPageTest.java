package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.amazon.pages.Homepage;
import org.amazon.pages.SearchResultPage;
import org.amazon.utils.SearchDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Test class for testing search result page functionality
 */


public class SearchResultPageTest extends Base {

    SearchResultPage searchResultPage;
    Homepage homepage;

    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        homepage = new Homepage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    /**
     *  Entering data in search box and asserting title of landing page
      */
    @Test(dataProvider = "partialSearchData", dataProviderClass = SearchDataProvider.class)
    public void getFirstItem(String partialWord,String keyword) {

        searchResultPage = homepage.searchFunction(partialWord,keyword);
        String landedPage = searchResultPage.getPageTitle();
        Assert.assertEquals(landedPage, "Amazon.com : qa testing for beginners");
        searchResultPage.getFirstImage();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
