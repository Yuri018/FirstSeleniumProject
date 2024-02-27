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
        if (!isLoginLinkPresent()){
            clickOnSingOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm();
        clickOnLoginButton();
    }

    @Test
    public void addProductToCartPositiveTest(){

        clickOnProductCartButton();
        click(By.xpath("//*[@id='add-to-cart-button-31']"));

        //click Shopping cart link
        clickOnShoppingCartLink();

        //assert Product is added to cart
        Assert.assertTrue(isAddProductToCart("14.1-inch Laptop"));
    }

    public void clickOnProductCartButton() {
        click(By.cssSelector("[title='Show details for 14.1-inch Laptop']"));
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
