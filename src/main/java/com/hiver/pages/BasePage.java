package com.hiver.pages;

import com.hiver.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class BasePage extends Base {

    @FindBy(xpath = "//span[text()='Electronics']")
    WebElement electronics;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public ItemListPage selectItem(String subCategory) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Electronics']"))).findElement(By.xpath("//span[text()='Electronics']"));
        actions.moveToElement(webElement);
        WebElement subCategoryElement = driver.findElement(By.xpath("//a[text()='" + subCategory + "']"));
        actions.moveToElement(subCategoryElement).click().build().perform();
        return new ItemListPage();
    }
}
