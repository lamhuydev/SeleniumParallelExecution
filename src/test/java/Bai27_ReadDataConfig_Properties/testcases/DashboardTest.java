package Bai27_ReadDataConfig_Properties.testcases;

import Bai27_ReadDataConfig_Properties.pages.DashboardPage;
import Bai27_ReadDataConfig_Properties.pages.LoginPage;
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
