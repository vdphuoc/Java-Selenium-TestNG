package util;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Initialized {
    @BeforeClass
    public void beforeClass(){
        Manager.getDriver().get(Manager.properties.getProperty("url"));
    }

    @BeforeMethod
    public void beforeMethod(){
        //imp later
    }

    @AfterMethod
    public void afterMethod(){
        // imp later
    }

    @AfterClass
    public void afterClass(){
        Manager.quickDriver();
    }
}
