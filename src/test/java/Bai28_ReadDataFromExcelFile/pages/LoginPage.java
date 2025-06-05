package Bai28_ReadDataFromExcelFile.pages;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    private WebDriverWait wait;

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    private void setEmail(String email) {
//        DriverManager.getDriver().findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {
//        DriverManager.getDriver().findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    private void clickLogin() {
        DriverManager.getDriver().findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess() {
        WebUI.sleep(2);
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Login failed");
    }

    public void verifyLoginFailed() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("authentication"), "Login failed");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "");
        Assert.assertEquals(DriverManager.getDriver().findElement(errorMessage).getText(), "Invalid email or password", "unmatch error message");
    }

    public void loginCRM(String email, String password) {
        DriverManager.getDriver().get(PropertiesHelper.getValue("url_crm_anhtester"));
//      DriverManager.getDriver().get("https://crm.anhtester.com/admin/authentication");
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        setEmail(email);
        setPassword(password);
        clickLogin();

    }

    public DashboardPage loginCRM() {
        DriverManager.getDriver().get("https://crm.anhtester.com/admin/authentication");
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        setEmail("admin@example.com");
        setPassword("123456");
        clickLogin();
        verifyLoginSuccess();


        // liên kết với DashboardPage
        return new DashboardPage();

    }
}
