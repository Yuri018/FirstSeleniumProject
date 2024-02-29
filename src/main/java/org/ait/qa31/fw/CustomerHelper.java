package org.ait.qa31.fw;

import org.ait.qa31.models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerHelper extends BaseHelper{
    public CustomerHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton() {
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public void fillLoginRegisterForm(Customer customer) {
        type(By.xpath("//*[@id='Email']"), customer.getEmail());
        type(By.cssSelector("#Password"), customer.getPassword());
    }

    public void fillRegisterForm(Customer customer) {
        type(By.xpath("//*[@id='FirstName']"),customer.getFirstName());
        type(By.xpath("//*[@id='LastName']"),customer.getLastName());
        type(By.xpath("//*[@id='Email']"), customer.getEmail());
        type(By.cssSelector("#Password"), customer.getPassword());
        type(By.cssSelector("#ConfirmPassword"), customer.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnSingOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//*[@name='register-button']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
}
