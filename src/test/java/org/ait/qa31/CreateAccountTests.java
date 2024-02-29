package org.ait.qa31;

import org.ait.qa31.models.Customer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getCustomer().isLoginLinkPresent()) {
            app.getCustomer().clickOnSingOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest() {

        app.getCustomer().clickOnRegistrationLink();
        app.getCustomer().fillRegisterForm(new Customer()
                .setFirstName("testName")
                .setLastName("testLastName")
                .setEmail("juri@mail.com")
                .setPassword("Qwerty007$"));
        app.getCustomer().clickOnRegistrationButton();

        Assert.assertTrue(app.getCustomer().isNotAllData());
    }
}
