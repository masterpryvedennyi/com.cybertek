package com.cybertek.tests.day15_webtables;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTests extends TestBase {

    @BeforeMethod
    public void setUpTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
    }

    //get all table
    @Test
    public void printTable(){
        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());
    }

    //get all headers
    @Test
    public void getHeaders(){
        //get all headers in single element
        WebElement header = driver.findElement(By.tagName("thead"));
        System.out.println(header.getText());


        //get all headers in a list
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        System.out.println(BrowserUtils.getElementsText(headers));
    }

    //get table size
    @Test
    public void getTableSize(){
        //get number of cols
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number columns: " + headers.size());

        //get number of rows
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(rowsWithHeader.size());

        //get number of rows without header
        List<WebElement> rowsWithOutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        System.out.println(rowsWithOutHeader.size());
    }

    //get table row based on index
    public static String getTableRowXpath(int index){
        String xpath = "//table[@id='table1']/tbody/tr["+index+"]";
        return xpath;

    }

    @Test
    public void getSingleBasedByIndex(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[2]"));
        System.out.println(cell.getText());

        String xpath = getCellXpathByIndex(2,4);
    }
    public static String getCellXpathByIndex(int row, int column){
        String xpath = "//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        return xpath;
    }

    //go through the table using loops and get all values
    @Test
    public void iterateTheTableUsingLoops(){
        //get the number of rows
        int rowCount = getRowCount();
        //get the number of cols
        int colCount = getColCount();

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= colCount; j++) {
                String xpath = getCellXpathByIndex(i, j);
                WebElement cell = driver.findElement(By.xpath(xpath));
                System.out.println(cell.getText());
            }
        }
    }

    //return num of rows without the table header
    public int getRowCount(){
        List<WebElement> rowsWithOutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        return rowsWithOutHeader.size();
    }

    public int getColCount(){
        List<WebElement> colCount = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return colCount.size();
    }
}
