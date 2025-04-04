package org.example.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.Drivers.Drivermanager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Basepage {
    //waits,Drivr,Commomn verifications,common functions

     public Basepage() {
    }
    public  void implicitwait(){
        Drivermanager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
    }
    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public void maximise(){
         Drivermanager.getDriver().manage().window().maximize();
    }

    public WebElement elementToBeClickable(final By elementIdentier) {
        WebElement element = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentier));
        return element;
    }
    public void click(By by){
        Drivermanager.getDriver().findElement(by).click();
    }
    protected  void enterinput(By by,String input){
        Drivermanager.getDriver().findElement(by).sendKeys(input);
    }
    public void waitforelementtobevisible(WebElement loc,String url){
        try {
            WebDriverWait w = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(10));

            w.until(ExpectedConditions.visibilityOf(loc));
            w.until(ExpectedConditions.urlContains(url));
        }
        catch (Exception e){
            System.out.println("wait for pop failed agfter expected condition"+e.toString());
        }
    }
    protected WebElement getElement(By key) {
        return Drivermanager.getDriver().findElement(key);
    }
    public void isdisplayed(By w){

         Drivermanager.getDriver().findElement(w).isDisplayed();
    }
}
