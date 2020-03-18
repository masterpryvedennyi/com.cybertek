package com.cybertek.tests.day09.testing_intro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAsserionTest {

    @Test
    public void test1(){
        String expected = "one";
        String actual = "one";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2(){
        String expected = "one";
        String actual = "two";
        System.out.println("starting to compare");
        Assert.assertEquals(actual, expected);
        System.out.println("test complete");

    }

    @Test
    public void test3(){
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void test4(){
        String expected = "one";
        String actual = "not one";
        Assert.assertTrue(expected.equals(actual));

        int a = 100;
        int e = 200;
        Assert.assertTrue(e>a);
    }

    @Test
    public void test5(){
       //verify that url is equal to google.com
        String expected = "https://www.google.com/";
        String actual = "https://www.google.com/";

        //verify title starts with java
        String expected1 = "java";
        String actual1 = "java - Google Search";
        Assert.assertTrue(actual.contains(expected));

    }
}
