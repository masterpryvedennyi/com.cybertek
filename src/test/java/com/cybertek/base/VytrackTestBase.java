package com.cybertek.base;

import com.cybertek.pages.*;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class VytrackTestBase {
        protected WebDriver driver;
        protected WebDriverWait wait;
        protected LoginPage loginPage;
        protected DashboardPageBase dashboardPage;
        protected VehiclesPage vehiclesPage;
        protected CreateCalendarEventsPage createCalendarEventsPage;

        @BeforeMethod
        public void setUpMethod() {
            driver = Driver.getDriver();
            wait = new WebDriverWait(driver, 10);
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.get(ConfigurationReader.getProperty("vytrack_url"));
            loginPage = new LoginPage();
            dashboardPage = new DashboardPageBase();
            vehiclesPage = new VehiclesPage();
            createCalendarEventsPage = new CreateCalendarEventsPage();
        }

        @AfterMethod
        public void tearDownMethod() throws InterruptedException {
            Thread.sleep(5000);
            Driver.closeDriver();
        }

    }