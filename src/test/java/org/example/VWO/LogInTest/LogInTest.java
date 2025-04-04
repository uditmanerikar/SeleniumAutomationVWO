package org.example.VWO.LogInTest;

import net.bytebuddy.build.Plugin;
import org.assertj.core.api.Assertions;
import org.example.Base.Basepage;
import org.example.BaseTest.BaseTest;
import org.example.Drivers.Drivermanager;
import org.example.Pages.POM.Dashboard;
import org.example.Pages.POM.LogInPage;
import org.example.Utils.PropertyReader;
import org.testng.annotations.Test;

public class LogInTest  extends Basepage {
    @Test(priority =2)
    public void testloginpositive() throws Exception {
        Drivermanager.init();
        LogInPage l=new LogInPage();
        l.maximise();
        l.loginurl(PropertyReader.readKey("url"));
        l.loginPagePositive();
       // Dashboard d=l.loginurl(com.tta.utils.PropertyReader.readKey("url")).loginPagePositive().afrerlogin();
        Dashboard d=l.afrerlogin();
        String expectedusername=d.loggedInUserName();
        Assertions.assertThat(expectedusername).isNotNull().contains(PropertyReader.readKey("ExpectedUsername"));
        d.checkvisibility();


    }
    @Test(priority =1)
    public void testloginNegative() throws Exception {
        Drivermanager.init();
        LogInPage l=new LogInPage();
        l.maximise();
        l.loginurl(PropertyReader.readKey("url"));
        l.loginPageNegative();
        String ErrorMessage1=l.loginPageNegative();
        System.out.println(ErrorMessage1);
        //Assertions.assertThat(ErrorMessage1).isNotNull().isNotBlank().contains(PropertyReader.readKey("ErrorMessage"));
    }
}
