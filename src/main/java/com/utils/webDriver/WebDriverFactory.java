package com.utils.webDriver;

import com.config.WebDriverProperties;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class WebDriverFactory {
    private static WebDriverProperties webDriverProperties = ConfigFactory.create(WebDriverProperties.class);
    private static String browserType = System.getProperty("browser", webDriverProperties.browserType());

    private static final long IMPLICIT_WAIT = webDriverProperties.waitImplicit();
    private static final long PAGE_WAIT = webDriverProperties.waitPage();
    private static final long SCRIPT_WAIT = webDriverProperties.waitScript();

    public static WebDriver setWebDriver() {
        WebDriver driver = null;
        switch (browserType) {
            case GOOGLECHROME:
            case CHROME:
            case "Chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
            case "Firefox":
            case "Mozilla":
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
            case "Edge":
            case "edge":
                EdgeDriverManager.getInstance().setup();
                driver = new EdgeDriver();
                break;
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(SCRIPT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }
}
