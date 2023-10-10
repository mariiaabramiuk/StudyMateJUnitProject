package pages.studymate;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnnouncementsPage {

    public AnnouncementsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //-----------------------------Elements to add announcement---------------------------------------

    @FindBy(xpath = "//nav/a[@href='/admin/announcements']")
    public WebElement announcementsBar;

    @FindBy(xpath = "//header/button[contains(text(),'Add an announcement')]")
    public WebElement addAnnouncementButton;

    @FindBy(xpath = "//div[@id='modal']//textarea")
    public WebElement announcementTextInput;

    @FindBy(xpath = "//div[@id='modal']/div/form/div/div[2]/div/div")
    public WebElement targetAllGroupsCheckbox;

    @FindBy(xpath = "//div/ul/li[contains(text(),'Для всех')]")
    public WebElement forAll;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//div/p[contains(text(),'Announcement successfully saved')]")
    public WebElement successMessage;
    public String saveAnnouncementExpectedMessage = "Announcement successfully saved";

    public String testAnnouncementMessage = "This is a test announcement text.";

    public String announcementPageURL = "https://codewiser.studymate.us/admin/announcements";

    //----------------------------Elements to edit announcement-------------------------------------
    @FindBy(xpath = "//div/div/div/div[3]/div/button")
    public WebElement threeDots;

    @FindBy(xpath = "//div/ul/li[1]")
    public WebElement editButton;
    public String modifiedText = "This is modified text";
    @FindBy(xpath = "//div/button[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div/p[contains(text(),'This is modified text')]")
    public WebElement expectedModifiedText;
//-------------------------------------Elements to test Cancel and  Delete Button--------------

    @FindBy(xpath = "//div/ul/li[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div/p[contains(text(),'ANNOUNCEMENT successfully deleted')]")
    public WebElement confirmationDeleteText;

    public String expectedDeleteConfirmationText = "ANNOUNCEMENT successfully deleted";


    //-----------------------------Methods to add announcement---------------------------------------

    public void clickAnnouncementsBar() {
        announcementsBar.click();
    }

    public void clickAddAnnouncementButton() {
        addAnnouncementButton.click();
    }

    //This method finds the text input field for the announcement and add message.
    public void enterAnnouncementText(String message) {
        announcementTextInput.sendKeys(message);
    }

    public void clickOnDropdownToTargetAllGroups() {
        targetAllGroupsCheckbox.click();
    }

    public void selectForAllOptionFromDropdown() {
        forAll.click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void assertSuccessMessage() {
        Assert.assertEquals(saveAnnouncementExpectedMessage, successMessage.getText());
    }

    //-----------------------------Methods to edit announcement---------------------------------------


    //This method clicks the three dots button to open the options menu for the announcement you want to edit.

    public void clickThreeDotsButton() {
        threeDots.click();
    }
    //This method selects the "Edit" option from the menu that appears after clicking the three dots button.

    public void selectEditOptionFromMenu() {
        editButton.click();
    }

    //This method clears the existing text in the text input field.
    public void clearAnnouncementText() {
        announcementTextInput.sendKeys(Keys.COMMAND + "a");
        announcementTextInput.sendKeys(Keys.DELETE);
    }

    //This method clicks the "Save" button to save the changes made to the announcement.
    public void clickSaveButton() {
        saveButton.click();
    }

    //This method performs an assertion to check if the modified text matches the expected text.
    public void assertModifiedText() {
        Assert.assertEquals(modifiedText, expectedModifiedText.getText());
    }

    //--------------------------------Method to test "Cancel delete" and "Delete" button-----------------------
    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickConfirmDeleteButton() {
        confirmDeleteButton.click();
    }

    public void assertDeleteConfirmation() {
        Assert.assertEquals(confirmationDeleteText.getText(),expectedDeleteConfirmationText );
    }

}