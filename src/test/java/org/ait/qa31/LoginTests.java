package org.ait.qa31;

import org.ait.qa31.models.Customer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getCustomer().isLoginLinkPresent()) {
            app.getCustomer().clickOnSingOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {

        app.getCustomer().clickOnLoginLink();
        app.getCustomer().fillLoginRegisterForm(new Customer().setEmail("juri@mail.com").setPassword("Qwerty007$"));
        app.getCustomer().clickOnLoginButton();
        Assert.assertTrue(app.getCustomer().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithOutEmail() {

        app.getCustomer().clickOnLoginLink();
        app.getCustomer().fillLoginRegisterForm(new Customer().setPassword("Qwerty007$"));
        app.getCustomer().clickOnLoginButton();
        Assert.assertTrue(app.getCustomer().isNotAllData());
    }
}
