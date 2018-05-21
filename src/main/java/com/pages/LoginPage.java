package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@placeholder='Login']")
    private WebElement loginField;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement loginBtn;

    private void clearAndTypeLoginField(String loginValue) {
        LOG.info("Clear and Type Login value: " + loginValue);
        waitForElementDisplayed(loginField);
        loginField.clear();
        loginField.sendKeys(loginValue);
    }

    private void clearAndTypePasswordField(String passwordValue) {
        LOG.info("Clear and Type Password value: " + passwordValue);
        waitForElementDisplayed(passwordField);
        passwordField.clear();
        passwordField.sendKeys(passwordValue);
    }

    public void loginToApplication(String login, String password) {
        clearAndTypeLoginField(login);
        clearAndTypePasswordField(password);
    }

    public GridPage clickLoginButton() {
        waitForElementDisplayed(loginBtn);
        baseClick(loginBtn);
        return new GridPage(driver);
    }
}
