package pages.studymate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtilities;

public class SchedulePage {
    public SchedulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String expectedMessageEventSuccessfullySaved = "Event successfully saved";
    public String expectedMessageEventSuccessfullyDeleted = "Event successfully deleted";

    public String scheduleURL = "https://codewiser.studymate.us/admin/schedule";

    @FindBy(xpath = "//li[text()='Schedule']")
    public WebElement scheduleTab;

    @FindBy(css = "button.css-79mk38")
    public WebElement createEventButton;

    @FindBy(xpath = "//div/input[@placeholder='MM/DD/YYYY']")
    public WebElement dateInputField;

    @FindBy(css = "input.css-1o6z5ng")
    public WebElement eventNameInputField;

    @FindBy(css = "div#mui-component-select-groupIds")
    public WebElement chooseGroupDropdown;

    @FindBy(css = "li.css-1f030r1")
    public WebElement theGroupCheckBox;

    @FindBy(xpath = "//button[text()='Publish']")
    public WebElement publishButton;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;
    @FindBy(css = "input#startTime")
    public WebElement startTimeField;

    @FindBy(css = "input#endTime")
    public WebElement endTimeField;

    @FindBy(xpath = "//div[@class='sc-ZqFbI dTKnLz']/div[6]")
    public WebElement purpleColour;

    @FindBy(xpath = "//div/p[text()='Event successfully saved']")
    public WebElement actualMessageEventCreated;

    @FindBy(css ="a.fc-event-future")
    public WebElement createdEventDisplay;

    @FindBy(xpath = "//*[name()='svg']//*[local-name()='path' and @fill='CurrentColor']")
    public WebElement deleteEventIcon;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div/p[text()='Event successfully deleted']")
    public WebElement actualMessageEventDeleted;


    public void clickOnScheduleTab() {
        scheduleTab.click();
    }

    public void clickCreateEventButton() {
        createEventButton.click();
    }

    public void clickOnDateInputField() {
        dateInputField.click();
    }

    public void clickOnEventNameInputField() {
        eventNameInputField.click();
    }

    public void clickChooseGroupDropDown() {
        chooseGroupDropdown.click();
    }

    public void chooseTheGroupCheckBox() {
        theGroupCheckBox.click();

    }

    public void clickPublishButton() {
        publishButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickOnStartTimeField() {
        startTimeField.click();
    }

    public void clickOnEndTimeField() {
        endTimeField.click();

    }

    public void clickOnPurpleColour() {
        purpleColour.click();
    }

    public void clickOnCreatedEventDisplay(){
        createdEventDisplay.click();
    }

    public void clickDeleteIcon(){
        deleteEventIcon.click();
    }

    public void clickConfirmDeleteButton(){
        confirmDeleteButton.click();
    }


}
