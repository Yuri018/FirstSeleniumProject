package org.ait.qa31.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {

    static WebDriver driver;
    String browser;
    CustomerHelper customer;
    ProductHelper product;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        customer = new CustomerHelper(driver);
        product = new ProductHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public CustomerHelper getCustomer() {
        return customer;
    }

    public ProductHelper getProduct() {
        return product;
    }
}
