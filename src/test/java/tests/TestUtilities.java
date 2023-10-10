package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.SeleniumUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestUtilities {
    public static void clearInputField(WebDriver driver, By locator) {
        WebElement inputField = driver.findElement(locator); // Find the input field element
        inputField.click(); // Click on the input field
        Actions actions = new Actions(driver); // Create an Actions object
        actions.keyDown(Keys.COMMAND) // Press the COMMAND key (for Mac)
                .sendKeys("a") // Send "a" to select all text
                .keyUp(Keys.COMMAND) // Release the COMMAND key
                .build() // Build the action sequence
                .perform(); // Perform the action
        inputField.sendKeys(Keys.DELETE); // Delete the selected text
    }

    public static void passCurrentDate(WebElement webElement){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = sdf.format(new Date());
        webElement.sendKeys(currentDate);

    } public static void passCurrentTime(WebElement webElement){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String currentTime = sdf.format(new Date());
        webElement.sendKeys(currentTime);
    }

    public static void passFutureTime(WebElement webElement) {
        // Calculate the future time (e.g., 1 hour from the current time)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1);
        Date futureTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String futureTimeString = sdf.format(futureTime);
        webElement.sendKeys(futureTimeString);
    }
}
