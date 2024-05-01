package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.LeftSideMenu;

public class AlertsTests extends BaseTest {

    @BeforeClass
    public void classPredictions() {
        // click on alerts frame on main page
        new HomePage(driver).clickOnAlertsFrames();
        // click on alerts on left menu
        new LeftSideMenu(driver).clickOnAlerts();
    }

    @AfterMethod
    public void postConditionAfterMethod() {
        new AlertsPage(driver).closeAlertIfPresent();
    }

    @Test
    public void fiveSecondsWaitAlertOpen() {
        Assert.assertTrue(new AlertsPage(driver).verifyAlert5SecsOpen());
    }

    @Test
    public void promptAlertTextTest() {
        Assert.assertTrue(new AlertsPage(driver).verifyTextFromPromptDisplaysCorrect("jdsfhkj"));
    }
}
