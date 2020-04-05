package com.cybertek.tests.dat17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuOptionsTests extends VytrackTestBase {

    @Test
    public void test(){
        loginPage.login("driver_username", "driver_password");


        dashboardPage.changeMenu("Fleet", "Vehicles");
        dashboardPage.changeMenu("System", "Jobs");
        dashboardPage.changeMenu("Activities", "Calendar Events");
    }

    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1, String menu2, String expectedTitle){
        loginPage.login("driver_username", "driver_password");
        dashboardPage.changeMenu(menu1, menu2);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    @DataProvider(name = "test-data")
    public Object[][] getData(){
        return new Object[][]{
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                {"System", "System Calendars", "System Calendars - System"}
        };
    }

    //login as driver
    //verify that driver can see menu options Fleet, Customers, Activities,
    @Test
    public void testAllOptionsDriver(){
        loginPage.login("driver_username", "driver_password");
        List<String> expectedList = Arrays.asList("Fleet", "Customers", "Activities", "System");
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(actualList, expectedList);
    }

}
