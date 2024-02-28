package org.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!isLoginLinkPresent()){
            clickOnSingOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new Customer().setEmail("juri@mail.com").setPassword("Qwerty007$"));
        clickOnLoginButton();
    }

    @Test
    public void addProductToCartPositiveTest(){

        clickOnProductCartButton();
        clickAddToCartButton();

        clickOnShoppingCartLink();

        Assert.assertTrue(isAddProductToCart("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        removeProductFromCart();
    }
}
