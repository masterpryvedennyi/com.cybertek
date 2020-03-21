package com.cybertek.tests.day09.testing_intro;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    @Test
    public void test1(){
        System.out.println("this is test1");
        Assert.assertEquals(true, false);
    }

    @Test
    public void test2(){
        System.out.println("this is test2");
    }
}
