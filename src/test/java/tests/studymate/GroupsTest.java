package tests.studymate;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import utilities.Driver;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupsTest {
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    GroupsPage groupsPage;


    @Before
    public void setUp() {
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        groupsPage = new GroupsPage();
    }

    @Test
    public void test1_createGroup() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groups));
        groupsPage.clickGroupTab();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.createGroupButton));
        groupsPage.clickOnCreateGroupButton();
        Faker faker = new Faker();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupName));
        groupsPage.clickGroupNameInputField();
        groupsPage.groupName.sendKeys(faker.job().field());
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupCreationDate));
        groupsPage.groupCreationDate.click();
        groupsPage.passGroupCreationDate();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupDescription));
        groupsPage.clickDescriptionInputField();
        groupsPage.groupDescription.sendKeys(faker.chuckNorris().fact());
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.createGroupButton));
        groupsPage.clickCreateButton();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(groupsPage.actualGroupConfirmationMessage));
        Assert.assertEquals(groupsPage.expectedGroupConfirmationMessage,groupsPage.actualGroupConfirmationMessage.getText());
    }
    @Test
    public void test2_deleteGroup() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.threeDots));
        groupsPage.clickOnThreeDots();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.deleteGroup));
        groupsPage.clickDeleteGroup();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.confirmDeleteButton));
        groupsPage.clickConfirmDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(groupsPage.actualGroupDeletedConfirmationMessage));
        Assert.assertEquals(groupsPage.expectedConfirmationDeleteGroupMessage,groupsPage.actualGroupDeletedConfirmationMessage.getText());
    }



}
