package Bai32_Log4j.pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriverWait wait;


    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By iconProfile = By.xpath("//li[contains(@class, 'header-user-profile')]");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//span[@class='menu-text'][normalize-space()='Sales']");
    public By menuProposal = By.xpath("//span[normalize-space()='Proposal']");

    public CustomerPage clickCusomerPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCustomers));
        DriverManager.getDriver().findElement(menuCustomers).click();

        return new CustomerPage();
    }
}
