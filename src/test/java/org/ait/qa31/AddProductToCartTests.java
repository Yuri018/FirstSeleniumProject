package org.ait.qa31;

import org.ait.qa31.models.Customer;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if (!app.getCustomer().isLoginLinkPresent()){
            app.getCustomer().clickOnSingOutButton();
        }
        app.getCustomer().clickOnLoginLink();
        app.getCustomer().fillLoginRegisterForm(new Customer().setEmail("juri@mail.com").setPassword("Qwerty007$"));
        app.getCustomer().clickOnLoginButton();
    }

    @Test
    public void addProductToCartPositiveTest(){

        app.getProduct().clickOnProductCartButton();
        app.getProduct().clickAddToCartButton();

        app.getProduct().clickOnShoppingCartLink();

        Assert.assertTrue(app.getProduct().isAddProductToCart("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        app.getProduct().removeProductFromCart();
    }
}
