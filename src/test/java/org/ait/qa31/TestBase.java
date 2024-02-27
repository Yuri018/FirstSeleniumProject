package org.ait.qa31;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());

        if (alert == null){
            return false;
        } else {
            alert.accept();
            return true;
        }
    }

    protected void clickOnLoginButton() {
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public void fillLoginRegisterForm() {
        type(By.xpath("//*[@id='Email']"), "juri@mail.com");
        type(By.cssSelector("#Password"), "Qwerty007$");
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnSingOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//*[@name='register-button']"));
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("//*[@href='/cart']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }
}
