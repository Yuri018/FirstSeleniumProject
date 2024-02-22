package org.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork03FindTenElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelector(){
        WebElement elementH1 = driver.findElement(By.cssSelector("h2"));
        System.out.println(elementH1.getText());
        driver.findElement(By.cssSelector("[href='/books']"));
        driver.findElement(By.cssSelector("[href='/camera-photo']"));
        driver.findElement(By.cssSelector(".listbox"));
        WebElement element = driver.findElement(By.cssSelector("[href='/apparel-shoes']"));
        System.out.println(element.getText());

        driver.findElement(By.cssSelector("[value=Subscribe]"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        WebElement element1 = driver.findElement(By.cssSelector(".answer:nth-of-type(2)"));
        System.out.println(element1.getText());
        WebElement element2 = driver.findElement(By.cssSelector(".answer:last-of-type"));
        System.out.println(element2.getText());

    }

    @Test
    public void findElementByXPath(){
        driver.findElement(By.xpath("//h2"));
        driver.findElement(By.xpath("//*[@href='/books']"));
        driver.findElement(By.xpath("//*[@href='/camera-photo']"));
        WebElement element = driver.findElement(By.xpath("//*[@class='listbox']"));
        System.out.println(element.getText());
        driver.findElement(By.xpath("//*[@href='/apparel-shoes']"));
        driver.findElement(By.xpath("//*[@value='Subscribe']"));
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));
//        driver.findElement(By.xpath("//*[@class='answer:nth-of-type(2)']"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
