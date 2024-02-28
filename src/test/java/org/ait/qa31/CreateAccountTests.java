package org.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnSingOutButton();
        }
    }

//    @Test
//    public void createNewAccountPositiveTest(){
//
//        //click on Login link
//        click(By.cssSelector("[href='/register']"));
//
////        //enter FirstName
////        type(By.xpath("//*[@id='FirstName']"), "juri");
////
////        //enter LastName
////        type(By.xpath("//*[@id='LastName']"), "ryzhkov");
//
//        //enter Email
//        fillLoginRegisterForm();
//
//        //confirm password
//        type(By.xpath("//*[@data-val-equalto-other='*.Password']"), "Qwerty007$");
//
//        //click on the Registration button
//        clickOnRegistrationButton();
//
//        //assert Sing Out button is present
//        Assert.assertTrue(isElementPresent(By.xpath("//*[@href='/logout']")));
//    }

    @Test
    public void createExistedAccountNegativeTest(){

        clickOnLoginLink();
        fillLoginRegisterForm(new Customer().setEmail("juri@mail.com").setPassword("Qwerty007$"));
        clickOnRegistrationButton();

        Assert.assertTrue(isNotAllData());
    }
}
