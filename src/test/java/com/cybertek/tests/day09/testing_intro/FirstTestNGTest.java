package com.cybertek.tests.day09.testing_intro;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {

    @Ignore
    @Test
    public void test1(){
        System.out.println("Test one");
    }

    @Test
    public void test2(){
        System.out.println("Test two");
    }
}
