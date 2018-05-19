package com.pages;

import com.config.AppProperties;
import com.config.WebDriverProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected Logger LOG = Logger.getLogger(BasePage.class);
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    private static WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
    private static final String applicationURL = appProperties.protocol() + appProperties.url();
    private static final long EXPLICIT_WAIT = webDriverProperties.waitExplicit();
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        LOG.info("Verify web page title");
        return driver.getTitle();
    }

    public void openBaseURL() {
        LOG.info("Navigate to " + applicationURL);
        driver.get(applicationURL);
    }

    public void clearAndType(WebElement webElement, String value) {
        LOG.info("Type value: " + value + ", into field: " + webElement.getTagName());
        waitForElementDisplayed(webElement);
        webElement.clear();
        webElement.sendKeys(value);
    }

    protected void submitBtn(WebElement webElement){
        LOG.info("Submit Element: " + webElement.getTagName() + ", with text: " + webElement.getText());
        waitForElementDisplayed(webElement);
        webElement.submit();
    }

    protected void clickBtn(WebElement webElement){
        LOG.info("Click on Element: " + webElement.getTagName() + ", with text: " + webElement.getText());
        waitForElementDisplayed(webElement);
        webElement.click();
    }

    public void waitForElementDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> webElement.isDisplayed());
    }
}
