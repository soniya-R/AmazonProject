package org.amazon.utils;
import org.testng.annotations.DataProvider;

public class SearchDataProvider {

    /**
     *  Providing search data and landing page title
     */
    @DataProvider(name="searchDataWithTitle")
    public static Object[][] searchKeywords()
    {
        return new Object[][]{
                {"qa testing for beginners","Amazon.com : qa testing for beginners"}
        };
    }

    /**
     *  Data to be searched
     */
    @DataProvider(name="searchData")
    public static Object[][] searchWord()
    {
        return new Object[][]{
                {"qa testing for beginners"}
        };
    }

    @DataProvider(name="partialSearchData")
    public static Object[][] searchWithPartialKey()
    {
        return new Object[][]{
                {"qa tes","qa testing for beginners"}
        };
    }
}

