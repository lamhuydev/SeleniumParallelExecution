package Bai34_AllureReport.pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private WebDriverWait wait;


    private String titleExpected = "Dashboard";
    private By buttonDashboardOption = By.xpath("//div[normalize-space()='Dashboard Options']");


    public void verifyDashboardPage(){
        String titleActual = DriverManager.getDriver().getTitle();
        Assert.assertEquals(titleActual, titleExpected, "Title page incorrect");
        Assert.assertTrue(DriverManager.getDriver().findElement(buttonDashboardOption).isDisplayed(), "Dashboard option is not displayed");
    }
}
