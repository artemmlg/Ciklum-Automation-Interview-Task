package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridPage extends BasePage {

    public GridPage(WebDriver driver) {
        super(driver);
    }

    //Wrestler | Main Grid
    @FindBy(xpath = ".//*[@ng-click='newWrestler()']")
    private WebElement addNewBtn;

    @FindBy(xpath = ".//input[@ng-model='searchFor']")
    private WebElement searchField;

    @FindBy(xpath = ".//button[@ng-click='searchWrestler(searchFor)']")
    private WebElement searchButton;

    public By findWrestlerById(String wrestlerId) {
        return By.xpath(".//td[@class='ng-binding' and text()='" + wrestlerId + "']");
    }

    public WrestlerPage clickNew() {
        baseClick(addNewBtn);
        return new WrestlerPage(driver);
    }

    public void searchByValue(String whatToSearch) {
        clearAndType(searchField, whatToSearch);
    }

    public void clickSearchButton() {
        baseClick(searchButton);
    }

    public WrestlerPage clickWrestlerByIdFromSearchPage(String wrestlerId) {
        WebElement element = driver.findElement(findWrestlerById(wrestlerId));
        waitForElementDisplayed(element);
        baseClick(element);
        return new WrestlerPage(driver);
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
