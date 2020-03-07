package com.cybertek.tests.day03.locators2;

import com.github.javafaker.Faker;

public class FakerPractice {
    public static void main(String[] args) {
        //create faker object
        Faker fakeData = new Faker();
        //I need first name
        String name = fakeData.name().firstName();
        System.out.println(name);
        String password = fakeData.random().toString();
        System.out.println(password);
    }
}
