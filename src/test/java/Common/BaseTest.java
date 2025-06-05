package Common;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import listener.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.time.Duration;


@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("edge")String browser) {
        WebDriver driver = setupDriver(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public WebDriver setupDriver(String browser){
        WebDriver driver;

        PropertiesHelper.loadAllFiles();


        // this if else have priority is "browser" in config
        if(!PropertiesHelper.getValue("browser").isEmpty() || !PropertiesHelper.getValue("browser").isBlank()){
            browser = PropertiesHelper.getValue("browser");
        }

        switch (browser.trim().toLowerCase()){
            case "chrome":
                driver = initChrome();
                System.out.println("Run with Chrome browser");
                break;
            case "edge":
                driver = initEdge();
                System.out.println("Run with Edge browser");
                break;
            default:
                System.out.println("Run with Edge browser (default)");
                driver = initEdge();
                break;
        }
        return driver;
    }

    public WebDriver initChrome(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver initEdge(){
        WebDriver driver;
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        if(DriverManager.getDriver() != null){
            DriverManager.quitDriver();
        }
    }
}
