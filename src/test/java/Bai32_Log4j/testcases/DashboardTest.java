package Bai32_Log4j.testcases;

import Bai32_Log4j.pages.DashboardPage;
import Bai32_Log4j.pages.LoginPage;
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
