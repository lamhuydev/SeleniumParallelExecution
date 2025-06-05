package Bai28_ReadDataFromExcelFile.testcases;

import Bai28_ReadDataFromExcelFile.pages.LoginPage;
import Common.BaseTest;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test (priority = 1)
    public void loginSuccess(){

        ExcelHelper excelHelper = new ExcelHelper();

        String xpathExcelFile = "src/test/resources/testdata/CRM.xlsx";

        excelHelper.setExcelFile(xpathExcelFile, "Login");

        String emailExcel = excelHelper.getCellData("Email", 1);
        String passwordExcel = excelHelper.getCellData("Password", 1);
        loginPage = new LoginPage();
        loginPage.loginCRM(emailExcel, passwordExcel);
        loginPage.verifyLoginSuccess();
    }

    @Test (priority = 2)
    public void loginFailWithErrorEmail() {

        ExcelHelper excelHelper = new ExcelHelper();

        String xpathExcelFile = "src/test/resources/testdata/CRM.xlsx";

        excelHelper.setExcelFile(xpathExcelFile, "Login");

        String emailExcel = excelHelper.getCellData("Email", 2);
        String passwordExcel = excelHelper.getCellData("Password", 2);


        loginPage = new LoginPage();
        loginPage.loginCRM(emailExcel, passwordExcel);
        loginPage.verifyLoginFailed();
    }

    @Test (priority = 3)
    public void loginFailWithErrorPassword() {
        ExcelHelper excelHelper = new ExcelHelper();

        String xpathExcelFile = "src/test/resources/testdata/CRM.xlsx";

        excelHelper.setExcelFile(xpathExcelFile, "Login");

        String emailExcel = excelHelper.getCellData("Email", 3);
        String passwordExcel = excelHelper.getCellData("Password", 3);


        loginPage = new LoginPage();
        loginPage.loginCRM(emailExcel, passwordExcel);
        loginPage.verifyLoginFailed();
    }


}
