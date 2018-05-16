package com.core;

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
        LOG.info("Navigate to " + appProperties.url());
        driver.get(applicationURL);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearAndType(WebElement webElement, CharSequence value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    protected void submitBtn(WebElement webElement){
//        LOG.info("Submit Element: " + webElement.getTagName() + ", with text: " + webElement.getText());
        webElement.submit();
    }

    protected void clickBtn(WebElement webElement){
//        LOG.info("Submit Element: " + webElement.getTagName() + ", with text: " + webElement.getText());
        webElement.click();
    }

    public void waitForElementDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> webElement.isDisplayed());
    }
}
