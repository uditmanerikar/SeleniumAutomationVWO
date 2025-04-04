package org.example.Drivers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.example.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public class Drivermanager {
    public static final ThreadLocal<WebDriver> w = new ThreadLocal<>();

    public static void setWebDriver(WebDriver driver){
w.set(driver);
    }

    public static WebDriver getDriver(){

        return w.get();
    }
    public static void unload(){
        w.remove();
    }


    public static void down() {
        if (Objects.nonNull(Drivermanager.getDriver())) {
            getDriver().quit();
            unload();
        }
    }
    public static void init() {
        if (Objects.isNull(Drivermanager.getDriver())){
            EdgeOptions e=new EdgeOptions();
            e.addArguments("--guest");
            e.addArguments("--remote-allow-origins=*");
            WebDriver driver = new EdgeDriver(e);
            setWebDriver(driver);
        }
    }

         



    }
