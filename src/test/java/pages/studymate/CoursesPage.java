package pages.studymate;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.SeleniumUtilities;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoursesPage {
    public CoursesPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    TeachersPage teachersPage = new TeachersPage();
    public String urlCourse = "https://codewiser.studymate.us/admin/courses";
    @FindBy(xpath = "//button[text()='Create course']")
    public WebElement createCourseButton;

    @FindBy(css = "input[name=courseName]")
    public WebElement courseName;

    @FindBy(css = "textarea[name=description]")
    public WebElement description;

    @FindBy(css = "input[placeholder='MM/DD/YYYY']")
    public WebElement date;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "//button[text()='Create']")
    public WebElement create;

    @FindBy(css = "div.css-s18byi")
    public List<WebElement> listOfCourses;

    @FindBy(xpath = "//div[@class='css-yys58j'][1]")
    public WebElement threeDots;

    @FindBy(xpath = "//div/ul/li[text()='Assign teacher'][1]")
    public WebElement assignTeacher;

    @FindBy(css = "div.css-qiwgdb")
    public WebElement assignTeacherDropdown;

    @FindBy(xpath = " //div[@role='presentation' and @id='menu-']/div/ul/li")
    public List<WebElement>listOfTeachers;

    @FindBy(xpath = "//button[text()='Save']")
    public  WebElement saveAddedTeacherButton;

    @FindBy(xpath = "//div[@class='MuiFormControl-root css-ccwj9y']//div/following::input[1]")
    public WebElement window;

    @FindBy(css="p.sc-dkrFOg")
    public WebElement instructorAddedSuccessfullyMessage;
    public WebElement uploadPhoto;

    public void createCourse() throws InterruptedException {
        createCourseButton.click();
        Faker faker = new Faker();
        String generatedCourseName = faker.educator().course();
        courseName.sendKeys(generatedCourseName);
        String generatedCourseDescription = faker.harryPotter().location();
        description.sendKeys(generatedCourseDescription);
        String currentDate = SeleniumUtilities.getCurrentDate("MM/dd/yyyy");
        date.click();
        date.sendKeys(currentDate);
        create.click();

        Thread.sleep(4000);
        for (WebElement e : listOfCourses) {
            if (e.getText().contains(generatedCourseName) && e.getText().contains(generatedCourseDescription)) {
                Assert.assertTrue(e.getText().contains(generatedCourseName) && e.getText().contains(generatedCourseDescription));
            }
        }

    }





}
