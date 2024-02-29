package org.ait.qa31.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductHelper extends BaseHelper{
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("//*[@href='/cart']"));
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
