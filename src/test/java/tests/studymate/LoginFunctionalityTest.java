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
public class LoginFunctionalityTest {
    WebDriver driver;
    LoginPage loginPage;
    CommonPageAnalytics commonPage;
    WebDriverWait wait;
    LogOutFunctionalityTest logOutFunctionalityTest;
    LogOutPage logOutPage;


    @Before
    public void setUp() {
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        commonPage = new CommonPageAnalytics();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logOutFunctionalityTest = new LogOutFunctionalityTest();
        logOutPage = new LogOutPage();


    }

    //**Test Case 1: Short password Login**
    //- **Test Scenario:** Verify that a user receive a message that password must be at least 6 characters long.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Enter a valid username and 5 characters password.
    //- **Expected Result:** The user should see a message "Password must be at least 6 characters!".
    @Test
    public void test1_shortPasswordMessageTest() {
        driver.get(loginPage.loginUrl);
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.enterPassword(loginPage.shortPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.shortPasswordMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.getExpectedErrorMessageShortPassword, loginPage.shortPasswordMessage);
        loginPage.clearPasswordField(driver);
        loginPage.clearEmailField(driver);
    }

    //**Test Case 2: Invalid Username**
    //- **Test Scenario:** Verify that the system displays an error message when an invalid username is entered.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Enter an invalid username (e.g., a username that does not exist) and a valid password.
    //  3. Click the "Login" button.
    //- **Expected Result:** The system should display an error message indicating that the login failed due to
    // an invalid username.
    @Test
    public void test2_loginWithInvalidUsername() {
        loginPage.enterUsername(loginPage.invalidUsername);
        loginPage.enterPassword(loginPage.validPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidUsernameMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageInvalidUsername, loginPage.invalidUsernameMessage);
        loginPage.clearEmailField(driver);
        loginPage.clearPasswordField(driver);
    }

    //**Test Case 3: Invalid Password**
    //- **Test Scenario:** Verify that the system displays an error message when an invalid password is entered.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Enter a valid username and an invalid password (e.g., an incorrect password).
    //  3. Click the "Login" button.
    //- **Expected Result:** The system should display an error message indicating that the login failed due to an
    // invalid password.
    @Test
    public void test3_loginWithInvalidPassword() {
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.enterPassword(loginPage.invalidPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidPasswordMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedMessageInvalidPassword, loginPage.invalidPasswordMessage);
        loginPage.clearEmailField(driver);
        loginPage.clearPasswordField(driver);
    }

    //**Test Case 4: Empty Username**
    //- **Test Scenario:** Verify that the system handles the case when the username field is left empty.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Leave the username field empty and enter a valid password.
    //  3. Click the "Login" button.
    //- **Expected Result:** The system should display an error message indicating that the login failed due
    // to the empty username field.
    @Test
    public void test4_loginWithEmptyEmail() {
        loginPage.enterPassword(loginPage.validPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.emptyEmailErrorMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageEmptyEmail, loginPage.emptyEmailErrorMessage);
        loginPage.clearPasswordField(driver);
    }

    //**Test Case 5: Empty Password**
    //- **Test Scenario:** Verify that the system handles the case when the password field is left empty.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Enter a valid username and leave the password field empty.
    //  3. Click the "Login" button.
    //- **Expected Result:** The system should display an error message indicating that the login failed due to the
    // empty password field.

    @Test
    public void test5_loginWithEmptyPassword() {
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.emptyPasswordErrorMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageEmptyPassword, loginPage.emptyPasswordErrorMessage);
        loginPage.clearEmailField(driver);
    }

    @Test
    public void test6_verifyShowPasswordButton() throws InterruptedException {
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.enterPassword(loginPage.validPassword);
        String passwordType = loginPage.passwordField.getAttribute("type");
        loginPage.clickShowPasswordButton();
        Thread.sleep(2000);
        Assert.assertNotEquals(passwordType, loginPage.passwordField.getAttribute("type"));
    }


    @Test
    public void test7_successfulLoginWithRussianLanguage() {
        loginPage.clickLanguageDropDown();
        loginPage.pickRussianLanguage();
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.analyticsInRussian.getText(), "Аналитика");
        logOutPage.clickAdministratorButtonInRussian();
        logOutPage.clickLogOutButton();
        logOutPage.clickConfirmLogoutButtonInRussian();
    }

    //**Test Case 6: Successful Login**
    //- **Test Scenario:** Verify that a user can successfully log in with valid credentials.
    //- **Test Steps:**
    //  1. Navigate to the login page.
    //  2. Enter a valid username and password.
    //  3. Click the "Login" button.
    //- **Expected Result:** The user should be granted access to their account without any error messages.

    @Test
    public void test8_successfulLogin() {
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.enterPassword(loginPage.validPassword);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlMatches(commonPage.analyticsUrl));
        Assert.assertEquals(driver.getCurrentUrl(), commonPage.analyticsUrl);

    }




}
