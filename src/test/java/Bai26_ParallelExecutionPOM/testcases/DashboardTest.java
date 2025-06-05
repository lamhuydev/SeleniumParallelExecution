package Bai26_ParallelExecutionPOM.testcases;

import Bai26_ParallelExecutionPOM.pages.DashboardPage;
import Bai26_ParallelExecutionPOM.pages.LoginPage;
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
