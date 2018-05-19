package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WrestlerPage extends BasePage {
    public WrestlerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//div[text()='Photo']")
    private WebElement photoPanel;

    @FindBy(xpath = ".//div[text()='Documents']")
    private WebElement documentsPanel;

    //New Wrestler | Input Fields
    @FindBy(xpath = ".//*[@placeholder='First name']")
    private WebElement fName;

    @FindBy(xpath = ".//*[@placeholder='Last name']")
    private WebElement lName;

    @FindBy(xpath = ".//*[@placeholder='Middle name']")
    private WebElement mName;

    @FindBy(xpath = ".//*[@placeholder='Date of Birth']")
    private WebElement dOfBirth;

    @FindBy(xpath = ".//*[@label='Trainer' and @value='wr.trainer1']//input")
    private WebElement trainerFirstField;

    @FindBy(xpath = ".//*[@label='Trainer' and @value='wr.trainer2']//input")
    private WebElement trainerSecondField;

    //New Wrestler | Dropdown's
    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region1']//select/option")
    private List<WebElement> regionFirstDropdown;

    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region2']//select/option")
    private List<WebElement> regionSecondDropdown;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst1']//select/option")
    private List<WebElement> fstFirst;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst2']//select/option")
    private List<WebElement> fstSecond;

    @FindBy(xpath = ".//*[@label='Style']//select/option")
    private List<WebElement> style;

    @FindBy(xpath = ".//*[@label='Age']//select/option")
    private List<WebElement> ageField;

    @FindBy(xpath = ".//*[@label='Status']//select/option")
    private List<WebElement> statusField;

    @FindBy(xpath = ".//*[@label='Year']//select")
    private WebElement yearField;

    @FindBy(xpath = ".//div[@class='buttons']//div[1]/button")
    private WebElement acceptBtn;

    public void addFirstName(String fName) {
        clearAndType(this.fName, fName);
    }

    public void addMiddleName(String mName) {
        clearAndType(this.mName, mName);
    }

    public void addLastName(String lName) {
        clearAndType(this.lName, lName);
    }

    public void addDateOfBirth(String dOfBirth) {
        clearAndType(this.dOfBirth, dOfBirth);
    }

    public void addFirstTrainer(String firstTrainer) {
        clearAndType(trainerFirstField, firstTrainer);
    }

    public void addSecondTrainer(String secondTrainer) {
        clearAndType(trainerSecondField, secondTrainer);
    }

    public void selectFromFirstRegion(String firstRegion) {
        selectFromDropDownByIndex(regionFirstDropdown, firstRegion);
    }

    public void selectFromSecondRegion(String secondRegion) {
        selectFromDropDownByIndex(regionSecondDropdown, secondRegion);
    }

    public void selectFromFristFST(String firstFST) {
        selectFromDropDownByIndex(fstFirst, firstFST);
    }

    public void selectFromSecondFST(String secondFST) {
        selectFromDropDownByIndex(fstSecond, secondFST);
    }

    public void selectFromStyle(String style) {
        selectFromDropDownByIndex(this.style, style);
    }

    public void selectFromStatus(String status) {
        selectFromDropDownByIndex(statusField, status);
    }

    public void selectFromAge(String age) {
        selectFromDropDownByIndex(ageField, age);
    }

    public void selectFromYear(String year) {
        selectFromDropDownByVisibleText(yearField, year);
    }

    private void selectFromDropDownByIndex(List<WebElement> webElements, String selectElementByIndex) {
        LOG.info("Select from DropDown Element: "
                + webElements.get(Integer.parseInt(selectElementByIndex)).getTagName()
                + ", by index: " + selectElementByIndex);
        waitForElementDisplayed(webElements.get(Integer.parseInt(selectElementByIndex)));
        webElements.get(Integer.parseInt(selectElementByIndex)).click();
    }

    private void selectFromDropDownByVisibleText(WebElement webElement, String selectByText) {
        LOG.info("Select from DropDown Element: " + webElement.getTagName() + ", by text: " + selectByText);
        Select select = new Select(webElement);
        waitForElementDisplayed(webElement);
        select.selectByVisibleText(selectByText);
    }

    public void clickAcceptNewWrestler() {
        clickBtn(acceptBtn);
    }

    public WebElement getPhotoPanel() {
        waitForElementDisplayed(photoPanel);
        return photoPanel;
    }

    public WebElement getDocumentsPanel() {
        waitForElementDisplayed(documentsPanel);
        return documentsPanel;
    }
}