package tests.studymate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import utilities.Driver;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogOutFunctionalityTest {
    WebDriver driver;
    CommonPageAnalytics commonPage;
    LogOutPage logOutPage;
    LoginPage loginPage;
    WebDriverWait wait;
    AnnouncementsPage announcementsPage;
    SchedulePage schedulePage;


    @Before
    public void setUp() {
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        logOutPage = new LogOutPage();
        commonPage = new CommonPageAnalytics();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        announcementsPage = new AnnouncementsPage();
        schedulePage = new SchedulePage();
    }


    //*Test Case 6: Verification of confirmation message before logout happens*
    //- **Preconditions:** User is logged in and currently on a web application page.
    //- **Test Steps:**
    //  1. Click on the "Logout" button or option in the user profile or navigation menu.
    //- **Expected Result:**
    // - The user see confirmation message "Do you really want to log out?"
    @Test
    public void test1_verificationOfConfirmationMessage() throws InterruptedException {
        Thread.sleep(4000);
        logOutPage.clickAdministratorButton();
        logOutPage.clickLogOutButton();
        wait.until(ExpectedConditions.visibilityOf(logOutPage.confirmationMessage));
        logOutPage.assertActualAndExpectedMessages(logOutPage.expectedConfirmationMessage, logOutPage.confirmationMessage);
    }

    //*Test Case 7: Verification of  logout cancel button*
    //- **Preconditions:** User is logged in and currently on a web application page.
    //- **Test Steps:**
    //  1. Click on the "Logout" button or option in the user profile or navigation menu.
    //- **Expected Result:**
    // - The user see confirmation message "Do you really want to log out?" and have an option to press cancel button
    // - The user press cancel button and stays at the current web application page.

    @Test
    public void test2_verificationOfCancelLogOutButton() {
        logOutPage.clickCancelButton();
        wait.until(ExpectedConditions.urlMatches(schedulePage.scheduleURL));
        Assert.assertEquals(driver.getCurrentUrl(), schedulePage.scheduleURL);

    }
    //*Test Case 8: Normal Logout*
    //- **Preconditions:** User is logged in and currently on a web application page.
    //- **Test Steps:**
    //  1. Click on the "Logout" button or option in the user profile or navigation menu.
    //- **Expected Result:**
    //  - The user is logged out.
    //  - The system redirects the user to the login page.
    //  - The user can no longer access their account without logging in again.

    @Test
    public void test3_normalLogOut() {
        logOutPage.clickLogOutButton();
        logOutPage.clickConfirmLogoutButton();
        wait.until(ExpectedConditions.urlMatches(loginPage.loginUrl));
        Assert.assertEquals(loginPage.loginUrl, driver.getCurrentUrl());
    }

}
