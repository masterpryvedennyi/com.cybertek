package com.cybertek.tests.dat17_ddt_dataprovider_pom2;

import com.cybertek.base.VytrackTestBase;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CreateCalendarEventTests extends VytrackTestBase {

    @Test
    public void allDayEventRadioTest(){
        loginPage.login("driver_username", "driver_password");
        driver.get("https://qa3.vytrack.com/calendar/event/create");
        assertFalse(createCalendarEventsPage.allDayEventCheckBox.isSelected());
    }

    @Test
    public void repeatCheckBoxTest(){
        loginPage.login("driver_username", "driver_password");
        driver.get("https://qa3.vytrack.com/calendar/event/create");
        assertFalse(createCalendarEventsPage.repeatCheckBox.isSelected());
    }
}
