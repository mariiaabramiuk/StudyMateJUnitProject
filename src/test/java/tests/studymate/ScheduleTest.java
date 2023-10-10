package tests.studymate;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import tests.TestUtilities;
import utilities.Driver;

import java.time.Duration;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ScheduleTest {
    WebDriver driver;
    WebDriverWait wait;
    SchedulePage schedulePage;


    @Before
    public void setUp() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        schedulePage = new SchedulePage();
    }

    @Test
    public void test1_addAnEvent() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.scheduleTab));
        schedulePage.clickOnScheduleTab();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.createEventButton));
        schedulePage.clickCreateEventButton();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.dateInputField));
        schedulePage.clickOnDateInputField();
        TestUtilities.passCurrentDate(schedulePage.dateInputField);
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.startTimeField));
        schedulePage.clickOnStartTimeField();
        TestUtilities.passCurrentTime(schedulePage.startTimeField);
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.endTimeField));
        schedulePage.clickOnEndTimeField();
        TestUtilities.passFutureTime(schedulePage.endTimeField);
        schedulePage.clickOnEventNameInputField();
        Faker faker = new Faker();
        schedulePage.eventNameInputField.sendKeys(faker.harryPotter().house());
        schedulePage.clickChooseGroupDropDown();
        schedulePage.chooseTheGroupCheckBox();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.publishButton));
        schedulePage.clickPublishButton();
        wait.until(ExpectedConditions.visibilityOf(schedulePage.actualMessageEventCreated));
        Assert.assertEquals(schedulePage.expectedMessageEventSuccessfullySaved,schedulePage.actualMessageEventCreated.getText());

    }
    @Test

    public void test2_deleteEvent (){
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.createdEventDisplay));
        schedulePage.clickOnCreatedEventDisplay();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.deleteEventIcon));
        schedulePage.clickDeleteIcon();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.confirmDeleteButton));
        schedulePage.clickConfirmDeleteButton();
        wait.until(ExpectedConditions.visibilityOf(schedulePage.actualMessageEventDeleted));
        Assert.assertEquals(schedulePage.expectedMessageEventSuccessfullyDeleted,schedulePage.actualMessageEventDeleted.getText());

    }


}
