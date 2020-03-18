package com.cybertek.tests.day09.testing_intro;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @Test
    public void test1(){
        System.out.println("this is test1");
    }

    @Test
    public void test2(){
        System.out.println("this is test2");
    }
}
