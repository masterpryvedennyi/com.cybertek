package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.VytrackTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PageHeadersTests extends VytrackTestBase {
    //go to vytrack
    //login as a driver
    //verify header is "Dashboard"

    @Test
    public void dashboardPageTest(){
        loginPage.login("driver_username", "driver_password");
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        assertEquals(actual, "Quick Launchpad");
    }

    //go to vytrack
    //go to Fleet vehicles
    //login as driver
    //verify header is "Cars"

    @Test
    public void fleetVehicleTest() {
        loginPage.login("driver_username", "driver_password");
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();

        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Cars");


    }
}
