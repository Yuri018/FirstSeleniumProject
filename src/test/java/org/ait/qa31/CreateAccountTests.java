package org.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (isElementPresent(By.cssSelector("[href='/login']"))){
            click(By.cssSelector("[href='/logout']"));
        }
    }

    @Test
    public void createNewAccountPositiveTest(){

        //click on Login link
        click(By.cssSelector("[href='/register']"));

        //enter FirstName
        type(By.xpath("//*[@id='FirstName']"), "juri");

        //enter LastName
        type(By.xpath("//*[@id='LastName']"), "ryzhkov");

        //enter Email
        type(By.xpath("//*[@id='Email']"), "juri@mail.com");


        //enter password
        type(By.cssSelector("#Password"), "Qwerty007$");

        //confirm password
        type(By.xpath("//*[@data-val-equalto-other='*.Password']"), "Qwerty007$");

        //click on the Registration button
        click(By.xpath("//*[@name='register-button']"));

        //assert Sing Out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//*[@href='/logout']")));
    }
}
