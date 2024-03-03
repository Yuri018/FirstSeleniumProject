package org.ait.qa31;

import org.ait.qa31.models.Customer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]>addCustomer(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"oliver", "Kan", "kan@mail.com", "Qwerty007$"});
        list.add(new Object[]{"oliver1", "Kan", "kan1@mail.com", "Qwerty007$"});
        list.add(new Object[]{"oliver2", "Kan", "kan2@mail.com", "Qwerty007$"});
        return list.iterator();
    }

    @Test(dataProvider = "addCustomer")
    public void addCustomerTestFromDataProvider(String name, String lastName, String email, String password){
        app.getCustomer().clickOnRegistrationLink();
        app.getCustomer().fillRegisterForm(new Customer()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getCustomer().clickOnRegistrationButton();

        Assert.assertTrue(app.getCustomer().isSignOutButtonPresent());
    }

    @DataProvider
    public Iterator<Object[]> addCustomerFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Customer().setFirstName(split[0]).setLastName(split[1]).setEmail(split[2])
                    .setPassword(split[3]).setPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "addCustomerFromCSV")
    public void addCustomerTestFromDataProviderWithFile(Customer customer){
        app.getCustomer().clickOnRegistrationLink();
        app.getCustomer().fillRegisterForm(customer);
        app.getCustomer().clickOnRegistrationButton();

        Assert.assertTrue(app.getCustomer().isSignOutButtonPresent());
    }
}
