package org.ait.qa31;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {
    static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isNotAllData() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement warningMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='validation-summary-errors']")));

        return warningMessage != null;
    }

    protected void clickOnLoginButton() {
        click(By.xpath("//*[@class='button-1 login-button']"));
    }

    public void fillLoginRegisterForm(Customer customer) {
        type(By.xpath("//*[@id='Email']"), customer.getEmail());
        type(By.cssSelector("#Password"), customer.getPassword());
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

    public void clickAddToCartButton() {
        click(By.xpath("//*[@id='add-to-cart-button-31']"));
    }

    public void clickOnProductCartButton() {
        click(By.cssSelector("[title='Show details for 14.1-inch Laptop']"));
    }

    public void removeProductFromCart() {
        click(By.xpath("//*[@name='removefromcart']"));
        click(By.xpath("//*[@name='updatecart']"));
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
