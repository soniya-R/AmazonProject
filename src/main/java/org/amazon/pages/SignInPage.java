package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(css = "#ap_email")
    private WebElement userEmail;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    @FindBy(css = "#ap_password")
    private WebElement userPassword;

    @FindBy(css = "#signInSubmit")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *  Entering email
     */
    public void setUserEmail(String email) {
        userEmail.sendKeys(email);
    }

    /**
     *  Clicking on continue button
     */
    public void getContinueButton() {
        continueButton.click();
    }

    /**
     *  Entering password
     */
    public void setUserPassword(String password) {
        userPassword.sendKeys(password);
    }

    /**
     * Clicking on signin button
     */
    public Homepage getSignInButton() {
        signInButton.click();
        return new Homepage(driver);
    }
}
