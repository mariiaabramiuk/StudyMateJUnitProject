package tests.studymate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import utilities.Driver;

public class TrashTest {
    WebDriver driver;
    LoginPage loginPage;
    CommonPageAnalytics commonPage;
    TeachersPage teachersPage;
    CoursesPage coursesPage;
    LoginFunctionalityTest loginFunctionalityTest;
    TrashPage trashPage;

    WebDriverWait wait;



    @Before
    public void setUp(){
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        commonPage= new CommonPageAnalytics();
        teachersPage = new TeachersPage();
        coursesPage = new CoursesPage();
        trashPage = new TrashPage();
        loginFunctionalityTest = new LoginFunctionalityTest();
    }
    @Test
    public void deleteElement(){
        driver.get(loginPage.loginUrl);
        loginPage.enterUsername(loginPage.validUsername);
        loginPage.enterPassword(loginPage.validPassword);
        loginPage.clickLoginButton();
        trashPage.clickOnTrashTab();
        trashPage.clickOnTrashIcon();
    }
}
