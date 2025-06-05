package Bai29_DataProvider.pages;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerPage extends BasePage {

    private WebDriverWait wait;


    private String titleExpected = "Customers";
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']/descendant::input[contains(@placeholder,'Search...')]");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By buttonDropdownGroup = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div/descendant::input");
    private By itemVIP = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div/descendant::span[normalize-space()='VIP']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By itemVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZip = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']//following-sibling::div//input");
    private By itemVietnamCountry = By.xpath("//button[@data-id='country']//following-sibling::div//span[normalize-space()='Vietnam']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']/button[normalize-space()='Save']");
    private By itemCustomerFirst = By.xpath("//table[@id='clients']/tbody/tr[1]/td[3]/a");


    // total customer in customer page
    private By totalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    private By headerCustomerDetailPage = By.xpath("//h4[normalize-space()='Profile']");


    public void verifyDirectToCustomerPage() {

        wait.until(ExpectedConditions.titleIs(titleExpected));
        Assert.assertEquals(DriverManager.getDriver().getTitle(), titleExpected, "Title page is not correct");
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(headerCustomerPage)).getText(), "Customers Summary", "CustomerPage: header page is not correct");

    }

    public void clickButtonAddNewCustomer() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(buttonAddNewCustomer));
        addButton.click();
    }

    public void submitDataForNewCustomer(String customerName) {


        WebUI.setText(inputCompany, customerName);

        WebUI.setText(inputVAT, "10");

        WebUI.setText(inputPhoneNumber, "0123456789");
        WebUI.setText(inputWebsite, "https://anhtester.com/");
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", DriverManager.getDriver().findElement(By.xpath("//label[normalize-space()='Groups']")));

        WebUI.clickElement(buttonDropdownGroup);
        WebUI.sleep(1);

        WebUI.setText(inputSearchGroup, "VIP");

        WebUI.sleep(1);
        WebUI.clickElement(itemVIP);

        WebUI.clickElement(buttonDropdownGroup);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(itemVietnamese);
        WebUI.setText(inputAddress, "HN");
        WebUI.setText(inputCity, "HN");
        WebUI.setText(inputState, "HN");
        WebUI.setText(inputZip, "123456");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.clickElement(itemVietnamCountry);
        WebUI.clickElement(buttonSave);

    }

    public void verifyDirectToCustomerDetailPage() {

        WebUI.waitForElementVisible(headerCustomerDetailPage);
        Assert.assertEquals(WebUI.getText(headerCustomerDetailPage), "Profile", "CustomerPage: Header detail customer page not match");

    }

    public void verifyAddNewCustomerSuccess(String customerName) {

        Assert.assertEquals(DriverManager.getDriver().findElement(inputCompany).getAttribute("value"), customerName, "CustomerPage: Customer name not match with detail customer");
        Assert.assertEquals(DriverManager.getDriver().findElement(inputVAT).getAttribute("value"), "10", "CustomerPage: VAT not match");
        Assert.assertEquals(DriverManager.getDriver().findElement(inputPhoneNumber).getAttribute("value"), "0123456789", "CustomerPage: Phone number not match");
        Assert.assertEquals(DriverManager.getDriver().findElement(inputWebsite).getAttribute("value"), "https://anhtester.com/", "CustomerPage: Website input not match");
        Assert.assertEquals(DriverManager.getDriver().findElement(buttonDropdownGroup).getAttribute("title"), "VIP", "CustomerPage: Groups not match");
        Assert.assertEquals(DriverManager.getDriver().findElement(dropdownLanguage).getAttribute("title"), "Vietnamese", "CustomerPage: Language not match");

    }

    public int getTotalCustomer() {
        WebUI.sleep(1);
        String totalCustomerString = WebUI.getText(totalCustomers);
        System.out.println("getTotalCustomer currently: " + Integer.parseInt(totalCustomerString));
        return Integer.parseInt(totalCustomerString);
    }


    // search customer vừa add new
    public void searchCustomerAddNew(String customerName) {
        WebUI.setText(inputSearchCustomer, customerName);
        WebUI.sleep(2);
        String customerFirst = WebUI.getText(itemCustomerFirst);

        Assert.assertEquals(customerFirst, customerName, "The name of customer first not match with customer name input");

    }

    public void clickCustomerFirstInTable(){
        WebUI.clickElement(itemCustomerFirst);
    }


}
