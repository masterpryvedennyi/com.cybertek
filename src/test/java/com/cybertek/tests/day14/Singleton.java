package com.cybertek.tests.day14;

public class Singleton {
    //make it private constructor
    private Singleton(){

    }

    private static String string;

    public static String getInstance(){
        //when called first time, it sets a value for browser
        if(string == null){
            //when called 2nd time, value is already set to chrome
            string = "chrome";
        }
        return string;
    }
}
