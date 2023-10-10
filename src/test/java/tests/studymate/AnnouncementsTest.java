package tests.studymate;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import utilities.Driver;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AnnouncementsTest {
    WebDriver driver;
    WebDriverWait wait;
    AnnouncementsPage announcementsPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        announcementsPage = new AnnouncementsPage();


    }
    //TestCase1 - add an announcement
    // Click on the "Announcements" link in the navigation bar
    // Click the "Add an announcement" button
    // Find the text input field for the announcement
    // Click the checkbox to target all groups
    // Select the "For All" option from the dropdown
    // Click the "Add" button to create and publish the announcement
    // Wait for success message and assert it

    @Test
    public void test1_createAndRemoveAnnouncements() {
        announcementsPage.clickAnnouncementsBar();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addAnnouncementButton));
        announcementsPage.clickAddAnnouncementButton();
        announcementsPage.enterAnnouncementText(announcementsPage.testAnnouncementMessage);
        announcementsPage.clickOnDropdownToTargetAllGroups();
        announcementsPage.selectForAllOptionFromDropdown();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addButton));
        announcementsPage.clickAddButton();
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.successMessage));
        announcementsPage.assertSuccessMessage();
    }

    //TestCase2 - edit an announcement
    // Click the three dots button to open options
    // Select the "Edit" option from the menu
    // Find the text input field for the announcement
    // Clear the existing text and add modified text
    // Click the "Save" button to save the changes
    // Wait for the modified text to appear and assert it
    @Test
    public void test2_editAnnouncementPage() {
        announcementsPage.clickThreeDotsButton();
        announcementsPage.selectEditOptionFromMenu();
        announcementsPage.clearAnnouncementText();
        announcementsPage.enterAnnouncementText(announcementsPage.modifiedText);
        announcementsPage.clickSaveButton();
        announcementsPage.assertModifiedText();
    }

    //TestCase3 - testCancelButton
    // Find and click the "Three Dots" button
    // Find and click the "Delete" button
    // Find and click the "Cancel" button
    @Test
    public void test3_cancelAnnouncementDeletion() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.threeDots));
        announcementsPage.clickThreeDotsButton();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.deleteButton));
        announcementsPage.clickDeleteButton();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.cancelButton));
        announcementsPage.clickCancelButton();

    }

    //TestCase4 - deleteAnnouncement
    // Find and click the "Three Dots" button
    // Find and click the "Delete" button
    // Find and click the "Delete" button
    @Test
    public void test4_deleteAnnouncement() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.threeDots));
        announcementsPage.clickThreeDotsButton();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.deleteButton));
        announcementsPage.clickDeleteButton();
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.confirmDeleteButton));
        announcementsPage.clickConfirmDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.confirmationDeleteText));
        announcementsPage.assertDeleteConfirmation();

    }

}
