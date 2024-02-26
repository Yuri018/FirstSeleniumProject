package org.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginPositiveTest(){

        click(By.cssSelector("[href='/login']"));

        type(By.xpath("//*[@id='Email']"), "juri@mail.com");

        type(By.cssSelector("#Password"), "Qwerty007$");

        click(By.xpath("//*[@class='button-1 login-button']"));

        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }

}
