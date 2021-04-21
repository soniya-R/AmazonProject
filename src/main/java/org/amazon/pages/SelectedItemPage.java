package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedItemPage {

    public WebDriver driver;


    @FindBy(css = "#add-to-cart-button")
    private WebElement addToCart;

    @FindBy(css = "#newBuyBoxPrice")
    private WebElement priceOfItem;

    public SelectedItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *  Adding the item to the cart by clicking on addtoCart button
     */
    public AddToCartPage getAddToCart() {
        addToCart.click();
        return new AddToCartPage(driver);
    }

    /**
     *  Retriving the price displayed on the selectedItemPage
     */
    public String getPriceOfItem() {
        String amount = priceOfItem.getText();
        return amount;
    }

}
