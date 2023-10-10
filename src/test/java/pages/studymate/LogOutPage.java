package pages.studymate;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.studymate.LogOutFunctionalityTest;
import utilities.Driver;

public class LogOutPage {
    public LogOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//header//p[contains(text(),'Administrator')]")
    public WebElement administratorButton;
    @FindBy(xpath = "//header//p[contains(text(),'Администратор')]")
    public WebElement administratorButtonInRussian;
    @FindBy(css = "li.css-1km1ehz")
    public WebElement logOutButton;



    @FindBy(xpath = "//div/p[contains(text(),'Do you really want to log out?')]")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//div/button[contains(text(),'Cancel')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//div/button[contains(text(),'Log out')]")
    public WebElement confirmLogOutButton;

    @FindBy(xpath ="//div/button[contains(text(),'Выйти')]")
    public WebElement confirmLogOutButtonInRussian;

    public String expectedConfirmationMessage = "Do you really want to log out?";

    public void clickAdministratorButton() {
        administratorButton.click();
    }
    public void clickAdministratorButtonInRussian() {
        administratorButtonInRussian.click();
    }


    public void clickLogOutButton() {
        logOutButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickConfirmLogoutButton() {
        confirmLogOutButton.click();
    }
    public void clickConfirmLogoutButtonInRussian() {
        confirmLogOutButtonInRussian.click();
    }


    public void assertActualAndExpectedMessages(String expected, WebElement actual) {
        Assert.assertEquals(expected, actual.getText());
    }




}
