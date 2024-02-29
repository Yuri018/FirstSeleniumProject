package org.ait.qa31.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
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

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
