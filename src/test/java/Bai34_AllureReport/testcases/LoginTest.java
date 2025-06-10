package Bai34_AllureReport.testcases;

import Bai34_AllureReport.pages.LoginPage;
import Common.BaseTest;
import dataproviders.DataProviderFactory;
import io.qameta.allure.*;
import jdk.jfr.Description;
import keywords.WebUI;
import org.testng.annotations.Test;
import utils.LogUtils;

import java.util.Hashtable;
import java.util.logging.Level;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Epic("Regression")
    @Feature("Admin Login")
    @Story("Admin Login Success")
    @Owner("Huy1")
    @Severity(SeverityLevel.NORMAL)
    @Test (testName = "Login Success", description = "Login Success",priority = 1, dataProvider = "data_provider_login_success", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess(String email, String password){
        LogUtils.info("Tiến hành chạy test: loginSuccess");
        loginPage = new LoginPage();
        loginPage.loginCRM(email, password);

        WebUI.sleep(1);
        loginPage.verifyLoginSuccess();
    }

//    @Feature("Regression")
//    @Owner("Huy2")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test (priority = 1, dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
//    public void loginSuccessWithDataProvider(String email, String password){
//        loginPage = new LoginPage();
//        loginPage.loginCRM(email, password);
//        loginPage.verifyLoginSuccess();
//    }


//    @Feature("Smoke")
//    @Owner("Huy3")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test (priority = 1, dataProvider = "data_provider_login_excel_hash_table", dataProviderClass = DataProviderFactory.class)
//    // data đã được truyền vào hashtable nên tham số truyền vào function này phải từ hash table lấy ra
//    public void loginSuccessWithDataProviderHashTable(Hashtable<String, String> data){
//        loginPage = new LoginPage();
//        loginPage.loginCRM(data.get("Email"), data.get("Password"));
//        loginPage.verifyLoginSuccess();
//    }


    @Epic("Regression")
    @Feature("Admin Login")
    @Story("Admin Login Failed With Error Email")
    @Owner("Huy4")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void loginFailWithErrorEmail() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFailed();
    }


    @Epic("Smoke")
    @Feature("Admin Login")
    @Story("Admin Login Failed With Error Password")
    @Owner("Huy5")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginFailWithErrorPassword() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFailed();
    }


}
