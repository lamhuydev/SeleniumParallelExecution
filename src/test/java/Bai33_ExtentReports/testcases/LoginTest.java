package Bai33_ExtentReports.testcases;

import Bai33_ExtentReports.pages.LoginPage;
import Common.BaseTest;
import dataproviders.DataProviderFactory;
import keywords.WebUI;
import org.testng.annotations.Test;
import utils.LogUtils;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

    LoginPage loginPage;


    @Test (testName = "Login Success", description = "Login Success",priority = 1, dataProvider = "data_provider_login_success", dataProviderClass = DataProviderFactory.class)
    public void loginSuccess(String email, String password){
        LogUtils.info("Tiến hành chạy test: loginSuccess");
        loginPage = new LoginPage();
        loginPage.loginCRM(email, password);

        WebUI.sleep(1);
        loginPage.verifyLoginSuccess();
    }

    @Test (priority = 1, dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessWithDataProvider(String email, String password){
        loginPage = new LoginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }

    @Test (priority = 1, dataProvider = "data_provider_login_excel_hash_table", dataProviderClass = DataProviderFactory.class)
    // data đã được truyền vào hashtable nên tham số truyền vào function này phải từ hash table lấy ra
    public void loginSuccessWithDataProviderHashTable(Hashtable<String, String> data){
        loginPage = new LoginPage();
        loginPage.loginCRM(data.get("Email"), data.get("Password"));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginFailWithErrorEmail() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFailed();
    }

    @Test
    public void loginFailWithErrorPassword() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFailed();
    }


}
