package Bai33_ExtentReports.testcases;

import Bai33_ExtentReports.pages.DashboardPage;
import Bai33_ExtentReports.pages.LoginPage;
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
