package com.cybertek.tests.day18_html_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.base.VytrackTestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportExample {
    //WebDriver driver;
    //used to set up and build the reports
    ExtentReports report;

    //used to create the html report
    ExtentHtmlReporter htmlReporter;

    //used to define a test in report, do logging, mark test results
    ExtentTest test;

    @BeforeMethod
    public void setUp(){
        //WebDriverManager.chromedriver().setup();

        //initialize the report
        report = new ExtentReports();

        //i need to point to the location where report will be created
        //System.getProperty("user.dir") - get my current folder
        //+ "test-output/report.html" --> create folder test output and in it create file
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        //initialize the html report with the given path
        htmlReporter = new ExtentHtmlReporter(path);

        //set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        //attach the html reporter to the report object
        report.attachReporter(htmlReporter);

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome");
    }

    @AfterMethod
    public void tearDown(){
        // the report will be created when we call this line
        //if we dont call flush method it will not be generated
        //we do this at the end of everything
        //driver.close();
        report.flush();
    }

    @Test
    public void test(){
        //we have to create a test for every test case
        test = report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        //driver = new ChromeDriver();
        test.info("Going to website");
        //driver.get("https://www.google.com/");
        test.info("Verifying title");
        //Assert.assertEquals(driver.getTitle(), "Google");
        test.pass("VYT-123 Title verification test");
    }
}
