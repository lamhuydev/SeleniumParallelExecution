package Bai32_Log4j.testcases;

import Bai32_Log4j.pages.CustomerPage;
import Bai32_Log4j.pages.DashboardPage;
import Bai32_Log4j.pages.LoginPage;
import Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    CustomerPage customerPage;
    DashboardPage dashboardPage;

    @Test
    public void addNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickCusomerPage();

        String customerName = "Anh Tester 0524H5";

        customerPage.verifyDirectToCustomerPage();

        // lấy total customer trước khi add new customer
        int beforeTotalCustomer = customerPage.getTotalCustomer();

        // click button add new customer
        customerPage.clickButtonAddNewCustomer();

        // điền data trong form add new customer
        customerPage.submitDataForNewCustomer(customerName);

        // click customer page
        customerPage.clickCusomerPage();

        // lấy total customer sau khi add new để so sánh
        int afterTotalCustomer = customerPage.getTotalCustomer();
        Assert.assertEquals(afterTotalCustomer, beforeTotalCustomer + 1, "The total customer before and after not match");

        // search customer vừa add new
        customerPage.searchCustomerAddNew(customerName);

        // click customer vừa search
        customerPage.clickCustomerFirstInTable();

        customerPage.verifyDirectToCustomerDetailPage();

        customerPage.verifyAddNewCustomerSuccess(customerName);

    }

}
