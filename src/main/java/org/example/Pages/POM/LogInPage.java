package org.example.Pages.POM;
import org.example.Drivers.Drivermanager;
import org.openqa.selenium.By;
import org.example.Base.Basepage;

public class LogInPage extends Basepage {
     public LogInPage() {
         super();
    }
    public void loginurl(String url){
        Drivermanager.getDriver().get(url);
    }
    private By Username=By.id("login-username");
    private By password=By.id("login-password");
    private By SubmitButton=By.id("js-login-btn");
    private  By ErrorMessage=By.xpath("//div[@id=\"js-notification-box-msg\"]");

    public LogInPage loginPagePositive() throws Exception {
        enterinput(Username, org.example.Utils.PropertyReader.readKey("username"));
        enterinput(password, org.example.Utils.PropertyReader.readKey("password"));
        click(SubmitButton);
        return  this;

    }
    public String loginPageNegative() throws Exception {
        enterinput(Username, org.example.Utils.PropertyReader.readKey("IncorrectUsername"));
        enterinput(password, org.example.Utils.PropertyReader.readKey("password"));
        click(SubmitButton);
        presenceOfElement(ErrorMessage);
        return getElement(ErrorMessage).getText();

    }
    public Dashboard afrerlogin(){
    return new Dashboard();
    }
}
