package org.ait.qa31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver webDriver;

    //before - setUp
    @BeforeMethod
    public void setUp(){

        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");//новый Хром
        webDriver.navigate().to("https://www.google.com");//Хром с историей
        webDriver.navigate().back();
        webDriver.navigate().forward();
        webDriver.navigate().refresh();
    }

    //tests
    @Test
    public void openGoogleTest(){
        System.out.println("Google opened!");
    }

    //after - teatDown
    @AfterMethod(enabled = false)
    public void tearDown(){
        webDriver.quit();//закроет все вкладки и браузер
        webDriver.close();//закроет текущую вкладку и браузер
    }
}
