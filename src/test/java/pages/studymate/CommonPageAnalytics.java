package pages.studymate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPageAnalytics {
    public CommonPageAnalytics(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public String analyticsUrl = "https://codewiser.studymate.us/admin/analytics";
    @FindBy(xpath = "//li[contains(text(),'Analytics')]")
   public WebElement analytics;
    @FindBy(xpath = "//li[contains(text(),'Groups')]")
   public WebElement groups;
    @FindBy(xpath = "//li[contains(text(),'Courses')]")
   public WebElement courses;
    @FindBy(xpath = "//li[contains(text(),'Teachers')]")
   public WebElement teachers;
    @FindBy(xpath = "//li[contains(text(),'Students')]")
   public WebElement students;
    @FindBy(xpath = "//li[contains(text(),'Announcements')]")
   public WebElement announcements;



}
