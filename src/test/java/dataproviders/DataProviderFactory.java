package dataproviders;

import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login_excel", parallel = true)
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelDataProvider(SystemHelper.getCurrentDir() + "src/test/resources/testdata/CRM.xlsx", "LoginDataProvider");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_hash_table", parallel = true)
    public Object[][] dataLoginFromExcelHashTable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/CRM.xlsx", "LoginDataProvider", 3, 4);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_success", parallel = false)
    public Object[][] dataProviderLoginSuccess(){

        return new Object[][]{
                {"admin@example.com", "123456"},
        };
    }

    @DataProvider(name = "data_provider_1")
    public Object[][] dataProvider1(){
        return new Object[][]{{"value1", "value2"}, {"value3", "value4"}};
    }

}
