package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
        /*
            takes a list of web elements
            returns a list of Strings
         */
        public static List<String> getElementsText(List<WebElement> listElement){
            // given a list web elements, extract the text of the elements into new list of Strings
            List<String> listSt = new ArrayList<>();
            for(WebElement each : listElement){
                listSt.add(each.getText());
            }
            return listSt;
        }
    }


