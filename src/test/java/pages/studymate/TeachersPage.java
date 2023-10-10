package pages.studymate;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class TeachersPage {
    public TeachersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String urlTeachers = "https://codewiser.studymate.us/admin/teachers?size=6&page=1";
    @FindBy(xpath = "//button[text()='Add teacher']")
    public WebElement addTeacherButton;
    @FindBy(css = "input[name=name]")
    public WebElement firstName;
    @FindBy(css="input[name=lastName]")
    public WebElement lastName;

    @FindBy(css="input[name=phoneNumber]")
    public WebElement phoneNumber;
    @FindBy(css="input[name=email]")
    public WebElement email;
    @FindBy(css="input[name=specialization]")
    public WebElement specialization;
    @FindBy (xpath = "//button[text()='Add']")
    public  WebElement add;
    WebElement chooseCourses;
    @FindBy (css = "tr.css-14qv2z4")
    public List<WebElement> listOfAddedTeachers;
    public String addedTeachersFirstName;

    @FindBy(xpath = "//button[@aria-label='Go to next page']")
    public WebElement arrowForward;

    public void addTeacher() throws InterruptedException {
        addTeacherButton.click();
        Faker faker = new Faker();
        String firstNameString = faker.name().firstName();
        firstName.sendKeys(firstNameString);
        String lastNameString = faker.name().lastName();
        lastName.sendKeys(lastNameString);
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber().replace("-",""));
        email.sendKeys(faker.internet().emailAddress());
        specialization.sendKeys(faker.job().field());
        add.click();
        Thread.sleep(4000);
        //verification that exact teacher has been added


        for (WebElement e: listOfAddedTeachers) {
            if (e.getText().contains(firstNameString) && e.getText().contains(lastNameString)){
                Assert.assertTrue(e.getText().contains(firstNameString)&& e.getText().contains(lastNameString));
                 addedTeachersFirstName = firstNameString;
            }
        }

    }


}
