package tests.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "delete list")
    public static  Object[][] dataSet(){
        return new Object[][] {{"706"}};
    }
}
