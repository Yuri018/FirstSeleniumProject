package org.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSingOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {

        clickOnLoginLink();
        fillLoginRegisterForm(new Customer().setEmail("juri@mail.com").setPassword("Qwerty007$"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithOutEmail() {

        clickOnLoginLink();
        fillLoginRegisterForm(new Customer().setPassword("Qwerty007$"));
        clickOnLoginButton();
        Assert.assertTrue(isNotAllData());
    }
}
