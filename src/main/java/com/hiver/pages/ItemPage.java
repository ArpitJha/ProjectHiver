package com.hiver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ItemPage extends BasePage {

    public CartCheckoutPage addItemToCart(String cart) {
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window(driver.getWindowHandle());
        WebElement cartElement = driver.findElement(By.xpath("//button[text()='" + cart + "']"));
        cartElement.click();
        return new CartCheckoutPage();
    }
}
