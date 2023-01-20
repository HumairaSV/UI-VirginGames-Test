package com.virgingames.testsuite;

import com.aventstack.extentreports.Status;
import com.virgingames.customlisteners.CustomListeners;
import com.virgingames.pages.HomePage;
import com.virgingames.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
     GamePage gamePage = new GamePage();

   /* choose from the below games in the below variable to test if the game is clickable on homepage
    Secrets of the Phoenix, Double Bubble Jackpot, Lightning Dice, Multihand Blackjack, Slingo Centurion, Blox Bingo, Tiki's Catch of the Day*/
    public static String game = "Lightning Dice";

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        gamePage = new GamePage();
    }

    @Test
    public void clickOnGameDisplayedUnderDifferentCategories(){
        homePage.clickOnAcceptCookiesButton();
        homePage.selectGameTab(game);
        Assert.assertTrue(gamePage.verifyPageName().contains(game), "Not navigated to the selected game page");
    }
}
