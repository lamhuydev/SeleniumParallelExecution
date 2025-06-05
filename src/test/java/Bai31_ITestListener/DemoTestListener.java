package Bai31_ITestListener;


import drivers.DriverManager;
import helpers.CaptureHelper;
import listener.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class DemoTestListener {

    private WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = new EdgeDriver();
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    public void demoTestSuccess(){
        driver.get("https://crm.anhtester.com/admin");
    }


    @Test(priority = 2)
    public void demoTestFail(){
        driver.get("https://crm.anhtester.com/admin");
        WebElement h2 = driver.findElement(By.xpath("//h1[normalize-space()='Login']"));
        Assert.assertEquals(h2.getText(), "Login1");
    }


    @Test(priority = 3)
    public void demoTestSkip(){
        throw new SkipException("Skipping the test method");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
