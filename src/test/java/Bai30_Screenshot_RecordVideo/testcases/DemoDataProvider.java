package Bai30_Screenshot_RecordVideo.testcases;

import dataproviders.DataProviderFactory;
import org.testng.annotations.Test;

public class DemoDataProvider {



    @Test(dataProvider = "data_provider_1", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider1(String param1, String param2){
        System.out.println(param1 + " -- " + param2);
    }
}
