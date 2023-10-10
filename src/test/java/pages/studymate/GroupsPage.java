package pages.studymate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestUtilities;
import utilities.Driver;

public class GroupsPage {

    CommonPageAnalytics commonPageAnalytics;

    public GroupsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        commonPageAnalytics = new CommonPageAnalytics();

    }

    public String expectedGroupConfirmationMessage = "Group successfully saved";
    public String expectedConfirmationDeleteGroupMessage = "Group successfully deleted";

    @FindBy(xpath = "//li[contains(text(),'Groups')]")
    public WebElement groups;

    @FindBy(css = "button.css-79mk38")
    public WebElement createGroupButton;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement groupName;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    public WebElement groupCreationDate;


    @FindBy(css = "textarea.css-x7mp9n")
    public WebElement groupDescription;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;

    @FindBy(css = "img.fPNjcC")
    public WebElement groupPicture;

    @FindBy(xpath = "//div/p[text()='Group successfully saved']")
    public WebElement actualGroupConfirmationMessage;

    @FindBy(xpath = "//div[@class='css-yys58j']/button[1]")
    public WebElement threeDots;

    @FindBy(xpath = "//li[text()='Delete group'][1]")
    public WebElement deleteGroup;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//p[text()='Group successfully deleted']")
    public WebElement actualGroupDeletedConfirmationMessage;


    public void clickGroupTab() {
        groups.click();
    }

    public void clickOnCreateGroupButton() {
        createGroupButton.click();
    }

    public void clickGroupNameInputField() {
        groupName.click();
    }

    public void passGroupCreationDate() {
        TestUtilities.passCurrentDate(groupCreationDate);
    }

    public void clickDescriptionInputField() {
        groupDescription.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickOnPictureUpload() {
        groupPicture.click();
    }

    public void clickOnThreeDots() {
        threeDots.click();
    }

    public void clickDeleteGroup() {
        deleteGroup.click();
    }

    public void clickConfirmDeleteButton() {
        confirmDeleteButton.click();
    }


}
