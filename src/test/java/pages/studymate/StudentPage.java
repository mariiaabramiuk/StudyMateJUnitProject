package pages.studymate;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class StudentPage {
    // Constructor to initialize PageFactory
    public StudentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // URL for the Student Page
    public String url = "https://codewiser.studymate.us/admin/students";

    // Web elements annotated with @FindBy for PageFactory
    @FindBy(xpath = "//li[text()='Students']")
    public WebElement studentTab;

    @FindBy(xpath = "(//*[@class='css-7zvtr8'])[3]")
    public WebElement numberOfStudentsElement;

    @FindBy(css = "button.css-79mk38")
    public WebElement addStudentButton;

    @FindBy(xpath = "//a[@href=/admin/students]")
    public WebElement studentsTab;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
            "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[1]")
    public WebElement groupDropdown;

    @FindBy(xpath = "//li[@data-value='5']")
    public WebElement groupOption;

    @FindBy(xpath = "(//div[@class = 'MuiSelect-select MuiSelect-outlined " +
            "MuiInputBase-input MuiOutlinedInput-input css-qiwgdb'])[2]")
    public WebElement studyFormatDropdown;

    @FindBy(xpath = "//li[@data-value='ONLINE']")
    public WebElement onlineOption;

    @FindBy(xpath = "(//button[contains(text(),'Add')])[2]")
    public WebElement addButton;

    @FindBy(xpath = "(//button[@class = 'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[4]")
    public WebElement deleteButton;

    @FindBy(xpath = "(//li[@class = 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-l5jx0u'])[6]")
    public WebElement deleteOption;

    @FindBy(xpath = "(//*[contains(text(),'Delete')])[4]")
    public WebElement finalDeleteButton;

        // Methods for interacting with the page elements

    // Method to navigate to the Students tab
    public void navigateToStudentsTab() {
        studentTab.click();
    }

    // Method to get the text of the number of students
    public String getNumberOfStudentsText() {
        return numberOfStudentsElement.getText();
    }

    // Method to click the "Add Student" button
    public void clickAddStudentButton() {
        addStudentButton.click();
    }

    // Method to fill in student information
    public void fillStudentInformation() {
        Faker faker = new Faker();
        nameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        phoneNumberField.sendKeys("2248759680");
        emailField.sendKeys(faker.internet().emailAddress());
    }

    // Method to select a group from the dropdown
    public void selectGroup() {
        groupDropdown.click();
        groupOption.click();
    }

    // Method to select a study format from the dropdown
    public void selectStudyFormat() {
        studyFormatDropdown.click();
        onlineOption.click();
    }

    // Method to click the "Add" button
    public void clickAddButton() {
        addButton.click();
    }

    // Method to wait for the number of students to be as expected
    public void waitForNumberOfStudents(String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement numberOfStudents = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='css-7zvtr8'])[3]")));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, expectedText));
    }

    // Method to click the "Delete" button
    public void clickDeleteButton() {
        deleteButton.click();
    }

    // Method to click the "Delete" option
    public void clickDeleteOption() {
        deleteOption.click();
    }

    // Method to click the "Final Delete" button
    public void clickFinalDeleteButton() {
        finalDeleteButton.click();
    }

    // Method to wait for the number of students after deletion to be as expected
    public void waitForNumberOfStudentsAfterDeletion(String expectedText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement numberOfStudents = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='css-7zvtr8'])[3]")));
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfStudents, expectedText));
    }
}

