package org.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
//        if (isElementPresent(By.cssSelector("[href='/login']"))){
//            click(By.cssSelector("[href='/logout']"));
//        }
        click(By.cssSelector("[href='/login']"));

        type(By.xpath("//*[@id='Email']"), "juri@mail.com");

        type(By.cssSelector("#Password"), "Qwerty007$");

        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    @Test
    public void addProductToCartPositiveTest(){

        //click on the product cart
        click(By.cssSelector("[title='Show details for 14.1-inch Laptop']"));

        //click Add to cart button
        click(By.xpath("//*[@id='add-to-cart-button-31']"));

        //click Shopping cart link
        click(By.xpath("//*[@href='/cart']"));

        //assert Product is added to cart
        Assert.assertTrue(isAddProductToCart("14.1-inch Laptop"));
    }

    public boolean isAddProductToCart(String product) {
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='cart-item-row']"));

        for (WebElement element: products){
            if (element.getText().contains(product)){
                System.out.println(product);
                return true;
            }
        }
        return false;
    }
}
