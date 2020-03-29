package com.cybertek.tests.day14;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;
import java.util.Properties;

public class PropertiesExample {

    @Test
    public void test(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

        //browser url
        //Properties - class from java that saves key value combinations
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "https://cybertekschool.com/");

        String browser = properties.getProperty("browser");
        System.out.println("browser name= " + browser);

        //I need the browser/url from properties fire
        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String pUrl = ConfigurationReader.getProperty("url");

        System.out.println("pUrl = " + pUrl);
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //get the form props file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();

    }

    @Test
    public void test3(){
        String str = Singleton.getInstance();
        System.out.println(str);
    }
}
