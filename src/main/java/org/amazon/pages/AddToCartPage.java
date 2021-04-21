package org.amazon.pages;

import org.amazon.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends Base {
    public WebDriver driver;

    @FindBy(css = "#hlb-ptc-btn-native")
    private WebElement checkoutButton;

    @FindBy(css = "#hlb-subcart .a-color-price.hlb-price.a-inline-block.a-text-bold")
    private WebElement priceOnAddToCartPage;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicking on checkout button on AddToCartPage
     */
    public CheckoutPage checkout() {
        wait.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

    /**
     * retrieving the price of the object that is displayed on Add to cart page
     */
    public String getPriceOnAddToCartPage() {
        String amount = priceOnAddToCartPage.getText();
        return amount;
    }
}
