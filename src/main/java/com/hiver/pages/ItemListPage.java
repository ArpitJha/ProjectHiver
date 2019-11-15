package com.hiver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemListPage extends BasePage {

    public ItemPage selectMobile(String mobileName) {
//        wait.until()
        WebElement mobileElement = driver.findElement(By.xpath("//div[text()[contains(.,'" + mobileName + "')]]"));
        mobileElement.click();
        return new ItemPage();
    }
}
