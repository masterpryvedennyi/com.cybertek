package com.cybertek.tests.office_hours4;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExamples {
    @Test
    public void test(){
        Assert.assertEquals(11, 1, "first hard assertion failed");
        Assert.assertEquals(2,2, "second hard assertion failed");
    }

    @Test
    public void test2(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(11, 1, "first soft assertion failed");
        softAssert.assertEquals(2,2, "second soft assertion failed");
        softAssert.assertAll();
    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(false, "first assertion");
        System.out.println("first assertion done");

        Assert.assertTrue(false, "second assertion");
        System.out.println("second assertion done");

        Assert.assertTrue(true, "third assertion");
        System.out.println("third assertion done");

        softAssert.assertTrue(true, "fourth assertion");
        System.out.println("fourth assertion done");

        softAssert.assertTrue(true, "fifth assertion");
        System.out.println("fifth assertion done");

        softAssert.assertAll();
    }
}
