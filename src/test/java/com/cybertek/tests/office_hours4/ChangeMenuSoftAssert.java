package com.cybertek.tests.office_hours4;

import com.cybertek.base.VytrackTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class ChangeMenuSoftAssert extends VytrackTestBase {

    //go to vy track
    //verify we are logged in
    //change menu to vehicles and verify title
    //change menu to customers and virify title

    @Test
    public void test() throws InterruptedException {
        loginPage.login("driver_username", "driver_password");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        dashboardPage.changeMenu("Fleet", "Vehicles");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("my Jeep car"), "vehicles title verification");

        dashboardPage.changeMenu("Customers", "Accounts");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Accounts"), "accounts title verification");
    }
}
