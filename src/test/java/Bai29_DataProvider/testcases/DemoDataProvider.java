package Bai29_DataProvider.testcases;

import dataproviders.DataProviderFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {



    @Test(dataProvider = "data_provider_1", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider1(String param1, String param2){
        System.out.println(param1 + " -- " + param2);
    }
}
