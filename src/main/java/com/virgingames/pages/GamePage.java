package com.virgingames.pages;

import com.aventstack.extentreports.Status;
import com.virgingames.customlisteners.CustomListeners;
import com.virgingames.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class GamePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[4]/div[1]/h1[1]" )
    WebElement pageName;

    public String verifyPageName(){
        Reporter.log("Verify page name" + pageName.toString());
        CustomListeners.test.log(Status.PASS, "Verify page name");
        return getTextFromElement(pageName);
    }
}

