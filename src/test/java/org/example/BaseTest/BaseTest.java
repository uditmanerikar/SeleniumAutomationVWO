package org.example.BaseTest;

import org.example.Drivers.Drivermanager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {//common across base page also
    @BeforeMethod
    protected void setup() throws MalformedURLException {
        Drivermanager.init();
    }

    @AfterMethod
    public void teardown(){
        Drivermanager.down();
    }
}
