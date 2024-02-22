package org.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        //maximize browser to window size
        driver.manage().window().maximize();

        //wait for all elements on the page to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void findElementByTadName() {
        //find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementBySimpleLocator() {
        //by id
        driver.findElement(By.id("city"));
        //className
        WebElement element = driver.findElement(By.className("navigation-link"));
        System.out.println(element.getText());
        //LinkText
        driver.findElement(By.linkText("Let the car work"));
        //partialLinkText (частичное совпадение)
        driver.findElement(By.partialLinkText("work"));

    }

    @Test
    public void findElementByCssSelector(){
        //id - #id
        driver.findElement(By.cssSelector("#city"));
        //className - .className
        driver.findElement(By.cssSelector(".navigation-link"));

        driver.findElement(By.cssSelector("[href='/search']"));
    }

    @Test
    public void findElementByXPath(){
        WebElement element = driver.findElement(By.xpath("//h1"));
        System.out.println(element.getText());

        driver.findElement(By.xpath("//*[@id='city']"));

        driver.findElement(By.xpath("//*[@class='navigation-link']"));

        driver.findElement(By.xpath("//*[@href='/search']"));

        //поиск по тексту - полное совпадение
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));

        //поиск по тексту - частичное совпадение
        WebElement element1 = driver.findElement(By.xpath("//*[.='Find your car now!']"));
        System.out.println(element1.getText());
        WebElement element2 = driver.findElement(By.xpath("//*[contains(.,'your car now!')]"));
        System.out.println(element2.getText());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
