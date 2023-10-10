package pages.studymate;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestUtilities;
import utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String loginUrl = "https://codewiser.studymate.us/login";
    public String invalidUsername = "invalidusername@gmail.com";
    public String invalidPassword = "invalidpassword123";
    public String validUsername = "admin@codewise.com";
    public String validPassword = "codewise123";

    public String shortPassword = "code";

    public String getExpectedErrorMessageShortPassword = "Password must be at least 6 characters!";
    public String expectedErrorMessageInvalidUsername = "User with email " + invalidUsername + " not found";

    public String expectedMessageInvalidPassword = "Invalid password";
    public String expectedErrorMessageEmptyEmail = "Email is required!";

    public String expectedErrorMessageEmptyPassword = "Password is required!";

    @FindBy(xpath = "//p/span[contains(text(),'Password must be at least 6 characters!')]")
    public WebElement shortPasswordMessage;
    @FindBy(css = "p.hbyUzQ")
    public WebElement invalidUsernameMessage;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;
    @FindBy(xpath = "//div/p[contains(text(),'Invalid password')]")
    public WebElement invalidPasswordMessage;

    @FindBy(xpath = "//div/p/span[contains(text(),'Email is required!')]")
    public WebElement emptyEmailErrorMessage;

    @FindBy(xpath = "//div//p/span[contains(text(),'Password is required!')]")
    public WebElement emptyPasswordErrorMessage;
    @FindBy(css = "button.css-slyssw")
    public WebElement showPassword;

    @FindBy(css = "#mui-component-select-language")
    public WebElement languageDropdown;

    @FindBy (xpath = "//ul/li[contains(text(),'Русский')]")
    public WebElement russianLanguage;

    @FindBy(css="a.active")
    public WebElement analyticsInRussian;
    public void enterUsername(String username) {
        emailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void assertActualAndExpectedMessages(String expected, WebElement actual) {
        Assert.assertEquals(expected, actual.getText());
    }

    public void clearEmailField(WebDriver driver) {
        TestUtilities.clearInputField(driver, By.xpath("//input[@name='email']"));// clearing email field
    }

    public void clearPasswordField(WebDriver driver) {
        TestUtilities.clearInputField(driver, By.xpath("//input[@name='password']"));//clearing password field
    }
    public void clickShowPasswordButton(){
        showPassword.click();
    }

    public void clickLanguageDropDown(){
        languageDropdown.click();
    }
    public void pickRussianLanguage(){
        russianLanguage.click();
    }



}

