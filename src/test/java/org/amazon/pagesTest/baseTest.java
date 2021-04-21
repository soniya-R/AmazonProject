package org.amazon.pagesTest;

import org.amazon.base.Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class baseTest extends Base {

    @Test
    //initial test to check basic functionlity working properly
    public void baseTest() throws IOException {
       driver = initializeDriver();
       driver.get("https://www.amazon.com/");
       String url = driver.getCurrentUrl();
        System.out.println(url);
       driver.quit();
    }
}
