package org.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewAccountPositiveTest(){

        //click onLogin link
        driver.findElement(By.cssSelector("[href='/register']")).click();

        //enter FirstName
        driver.findElement(By.xpath("//*[@id='FirstName']")).click();
        driver.findElement(By.xpath("//*[@id='FirstName']")).clear();
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("juri");

        //enter LastName
        driver.findElement(By.xpath("//*[@id='LastName']")).click();
        driver.findElement(By.xpath("//*[@id='LastName']")).clear();
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("ryzhkov");

        //enter Email
        driver.findElement(By.xpath("//*[@id='Email']")).click();
        driver.findElement(By.xpath("//*[@id='Email']")).clear();
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("juri@mail.com");


        //enter password
        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("Qwerty007$");

        //confirm password
        driver.findElement(By.xpath("//*[@data-val-equalto-other='*.Password']")).click();
        driver.findElement(By.xpath("//*[@data-val-equalto-other='*.Password']")).clear();
        driver.findElement(By.xpath("//*[@data-val-equalto-other='*.Password']")).sendKeys("Qwerty007$");

        //click on the Registration button
        driver.findElement(By.xpath("//*[@name='register-button']")).click();

        //assert Sing Out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//*[@href='/logout']")));
    }
}
