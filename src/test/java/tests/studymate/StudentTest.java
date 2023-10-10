package tests.studymate;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.StudentPage;
import utilities.Driver;

import java.time.Duration;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTest {

    // Static WebDriver and StudentPage variables for use across all test methods
    private static WebDriver driver;
    private static StudentPage studentPage;
    WebDriverWait wait;

    // This method runs once before any test method in this class is executed
    @Before
    public void setUp() {
        // Initialize the WebDriver and wait
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        studentPage = new StudentPage();
    }

    // Test method to add a student
    @Test
    public void b_AddStudent() throws InterruptedException {
        // Navigate to the Students tab
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.studentTab));
        studentPage.navigateToStudentsTab();

        // Click the "Add Student" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.addStudentButton));
        studentPage.clickAddStudentButton();

        // Fill in student information, select group and study format, and click "Add" button
        studentPage.fillStudentInformation();
        studentPage.selectGroup();
        studentPage.selectStudyFormat();
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.addButton));
        studentPage.clickAddButton();

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Verify that the number of students is now "from 2"
        studentPage.waitForNumberOfStudents("from 2");
        Assert.assertEquals("from 2", studentPage.getNumberOfStudentsText());
    }

    // Test method to delete a student
    @Test
    public void c_DeleteStudent() throws InterruptedException {
        // Click the "Delete" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.deleteButton));
        studentPage.clickDeleteButton();

        // Click the "Delete" option
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.deleteOption));
        studentPage.clickDeleteOption();

        // Click the "Final Delete" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.finalDeleteButton));
        studentPage.clickFinalDeleteButton();

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Verify that the number of students is now "from 1"
        studentPage.waitForNumberOfStudentsAfterDeletion("from 1");
        Assert.assertEquals("from 1", studentPage.getNumberOfStudentsText());
    }
}