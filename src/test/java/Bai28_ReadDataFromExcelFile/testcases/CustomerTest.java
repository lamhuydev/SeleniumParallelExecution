package Bai28_ReadDataFromExcelFile.testcases;

import Bai28_ReadDataFromExcelFile.pages.CustomerPage;
import Bai28_ReadDataFromExcelFile.pages.DashboardPage;
import Bai28_ReadDataFromExcelFile.pages.LoginPage;
import Common.BaseTest;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    CustomerPage customerPage;
    DashboardPage dashboardPage;

    @Test
    public void addNewCustomer() {

        // Khởi tạo đối tượng excelHelper
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/CRM.xlsx", "Customer");



        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();

//        customerPage = new CustomerPage();
//        customerPage.clickCusomerPage();

        customerPage = dashboardPage.clickCusomerPage();

        int row_excel_data = Integer.parseInt(PropertiesHelper.getValue("row_excel_data"));
        String customerName =  excelHelper.getCellData("Customer_Name", row_excel_data);


        customerPage.verifyDirectToCustomerPage();

        // lấy total customer trước khi add new customer
        int beforeTotalCustomer = customerPage.getTotalCustomer();

        // click button add new customer
        customerPage.clickButtonAddNewCustomer();

        // điền data trong form add new customer
        customerPage.submitDataForNewCustomer();

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

        excelHelper.setCellData("Passed", "Status", row_excel_data);

    }

}
