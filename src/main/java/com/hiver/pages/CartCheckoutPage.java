package com.hiver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartCheckoutPage extends BasePage {

    public CartCheckoutPage increaseItemCount(int count) {
        WebElement countElement = driver.findElement(By.xpath("//button[text()='+']"));
        for (int i = 0; i < count; i++) {
            if (countElement.isEnabled()) {
                countElement.click();
            } else {
                break;
            }
        }
        return this;
    }

    public String getPayableAmount() {
        WebElement amount = driver.findElement(By.xpath("//div[text()='Total Payable']/following-sibling::span"));
        return amount.getText();
    }
}
