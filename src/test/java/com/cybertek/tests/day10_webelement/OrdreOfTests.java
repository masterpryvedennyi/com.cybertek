package com.cybertek.tests.day10_webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrdreOfTests {

    String title;

    @Test(priority = 0, description = "test login functionality")
    public void login(){
        System.out.println("open the browser");
        System.out.println("capturing title");
        title = "cbt";

    }

    @Test(priority =1, dependsOnMethods = "login", description = "title verification")
    public void assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
        Assert.fail();
    }

    @Test(priority = 55, dependsOnMethods = {"login", "assertTitle"})
    public void verifyingOtherThings(){
        System.out.println("verifying sth else");
    }
}
