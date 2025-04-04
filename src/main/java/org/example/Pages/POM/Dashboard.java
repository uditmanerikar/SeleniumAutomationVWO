package org.example.Pages.POM;

import org.example.Base.Basepage;
import org.example.Drivers.Drivermanager;
import org.openqa.selenium.By;

public class Dashboard extends Basepage {
     Dashboard() {
    }


    By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");
    By ActiveTests = By.xpath("//span[text()='Active Tests']");
    By UntestedHypotheses = By.xpath("//span[text()='Untested Hypotheses']");
    By RolledOutExperiences = By.xpath("//span[text()='Rolled Out Experiences']");
    By TotalExperiences= By.xpath("//span[text()='Total Experiences']");


    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
    public void checkvisibility(){
        isdisplayed(ActiveTests);
        System.out.println(Drivermanager.getDriver().findElement(ActiveTests).getText());
    }

}

