package com.pages;

import com.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewWrestlerTabPage extends BasePage {
//    Select selector;

    public NewWrestlerTabPage(WebDriver driver) {
        super(driver);
    }

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
    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region1']//select")
    private WebElement regionFirstDropdown;

    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region2']//select")
    private WebElement regionSecondDropdown;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst1']//select")
    private WebElement fstFirst;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst2']//select")
    private WebElement fstSecond;

    @FindBy(xpath = ".//*[@label='Style']//select")
    private WebElement style;

    @FindBy(xpath = ".//*[@label='Age']//select")
    private WebElement ageField;

    @FindBy(xpath = ".//*[@label='Year']//select")
    private WebElement yearField;

    @FindBy(xpath = ".//*[@label='Status']//select")
    private WebElement statusField;

    @FindBy(xpath = ".//button[@class='btn btn-lg btn-success']")
    private WebElement acceptBtn;

    public void fillNewUserForm(
            CharSequence firstName, CharSequence lastName, CharSequence middleName,
            CharSequence dateOfBirth, CharSequence firstRegion, CharSequence secondRegion,
            CharSequence fst1, CharSequence fst2,
            CharSequence firstTrainer, CharSequence secondTrainer,
            CharSequence playerStyle, CharSequence age,
            CharSequence year, CharSequence status) {
        waitForElementDisplayed(fName);
        clearAndType(fName, firstName);
        clearAndType(lName, lastName);
        clearAndType(mName, middleName);
        clearAndType(dOfBirth, dateOfBirth);
        selectFromDropDownByVisibleText(regionFirstDropdown, (String) firstRegion);
        selectFromDropDownByVisibleText(regionSecondDropdown, (String) secondRegion);
        selectFromDropDownByVisibleText(regionSecondDropdown, (String) secondRegion);
        selectFromDropDownByVisibleText(fstFirst, (String) fst1);
        selectFromDropDownByVisibleText(fstSecond, (String) fst2);
        clearAndType(trainerFirstField, firstTrainer);
        clearAndType(trainerSecondField, secondTrainer);
        selectFromDropDownByVisibleText(style, (String) playerStyle);
        selectFromDropDownByVisibleText(yearField, (String) year);
        selectFromDropDownByVisibleText(statusField, (String) status);
        selectFromDropDownByVisibleText(ageField, (String) age);
    }

    public void acceptForm(){
        clickBtn(acceptBtn);
    }

    private void selectFromDropDownByVisibleText(WebElement webElement, String selectByText) {
        Select select = new Select(webElement);
        select.selectByVisibleText(selectByText);
    }


}
