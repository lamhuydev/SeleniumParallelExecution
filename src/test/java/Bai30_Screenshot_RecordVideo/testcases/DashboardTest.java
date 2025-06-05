package Bai30_Screenshot_RecordVideo.testcases;

import Bai30_Screenshot_RecordVideo.pages.DashboardPage;
import Bai30_Screenshot_RecordVideo.pages.LoginPage;
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
