package Bai28_ReadDataFromExcelFile.testcases;

import Bai28_ReadDataFromExcelFile.pages.DashboardPage;
import Bai28_ReadDataFromExcelFile.pages.LoginPage;
import Common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void verifyDashboardPage(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyDashboardPage();

    }

}
