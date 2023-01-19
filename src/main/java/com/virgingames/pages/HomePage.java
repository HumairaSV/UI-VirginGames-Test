package com.virgingames.pages;

import com.aventstack.extentreports.Status;
import com.virgingames.customlisteners.CustomListeners;
import com.virgingames.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Accept')]" )
    WebElement acceptCookies;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'StyledGamesRow-sc-whe244-1 fnHoRL']/div")
    List<WebElement> gamesSelectTab;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/section[4]/div[1]/h1[1]" )
    WebElement pageName;



    public void clickOnAcceptCookiesButton(){
        Reporter.log("Click on the accept cookies button" + acceptCookies.toString());
        clickOnElement(acceptCookies);
        CustomListeners.test.log(Status.PASS, "Click on accept cookies button ");
    }


    public void selectGameTab(String game){
        Reporter.log("Select a game Tab" + gamesSelectTab.toString());
                   List<WebElement> selectList = webElementList(gamesSelectTab);
            try {
                for (WebElement element : selectList) {
                    if (element.getText().equalsIgnoreCase(game)) {
                        element.click();
                    }
                }
            } catch (StaleElementReferenceException e) {
                selectList = webElementList(gamesSelectTab);
            }
        CustomListeners.test.log(Status.PASS, "Select game Tab" + game);
        }

    public String verifyPageName(){
        Reporter.log("Verify page name" + pageName.toString());
        CustomListeners.test.log(Status.PASS, "Verify page name");
        return getTextFromElement(pageName);
    }

    }




