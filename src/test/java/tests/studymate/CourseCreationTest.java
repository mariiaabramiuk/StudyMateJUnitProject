package tests.studymate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.studymate.*;
import utilities.Driver;

import java.time.Duration;

public class CourseCreationTest {

    //User story: As an admin, I want to be able to create a teacher and assign this teacher to the new course.
    //Test case:
    //1. go to url
    //2. login
    //3. click on "Teachers"
    //4. click on "Add teacher"
    //5. fill out the form and click on Add
    //6. click on "Courses"
    //7. click on "Add course"
    //8. fill out the form and click on Add
    // - verify the course is added (check if all details match)
    //9. open the course which was created
    //10. verify teacher and course details
    WebDriver driver;
    LoginPage loginPage;
    CommonPageAnalytics commonPage;
    TeachersPage teachersPage;
    CoursesPage coursesPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        loginPage = new LoginPage();
        commonPage= new CommonPageAnalytics();
        teachersPage = new TeachersPage();
        coursesPage = new CoursesPage();
    }

    @Test
    public void testCourseCreation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage.teachers.click();
        wait.until(ExpectedConditions.urlContains("teachers"));
        wait.until(ExpectedConditions.elementToBeClickable(commonPage.teachers));
        teachersPage.addTeacher();
        wait.until(ExpectedConditions.elementToBeClickable(commonPage.courses));
        commonPage.courses.click();
        coursesPage.createCourse();
        coursesPage.threeDots.click();
        coursesPage.assignTeacher.click();
        coursesPage.assignTeacherDropdown.click();
        for (WebElement e : coursesPage.listOfTeachers
        ) {
            if (e.getText().contains(teachersPage.addedTeachersFirstName)) {
                e.click();
            }

        }
        Actions actions = new Actions(driver);
        actions.click(coursesPage.window).build().perform();
        coursesPage.saveAddedTeacherButton.click();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(coursesPage.instructorAddedSuccessfullyMessage)).getText(),"Instructors successfully added to the course");


    }

}
