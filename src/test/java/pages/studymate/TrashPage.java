package pages.studymate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrashPage {

    public TrashPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a/li[text()='Trash']")
    public WebElement trashTab;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> listOfNames;

    @FindBy(xpath = "(//div[@class='sc-hiDMwi dTxgqR'])[1]/*[2]")
    public WebElement trashIcon;
    public void clickOnTrashTab(){
        trashTab.click();
    }

    public void clickOnTrashIcon(){
        trashIcon.click();
    }





}
