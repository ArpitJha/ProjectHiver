package com.hiver;

import com.hiver.base.BaseTest;
import com.hiver.pages.FlipkartHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartSelenium extends BaseTest {

    private FlipkartHomePage flipkartHomePage;

    @BeforeClass
    public void beforeTest() {
        // TODO in case we want to set test prerequisites
        flipkartHomePage = new FlipkartHomePage();
        WebElement loginPopup = driver.findElement(By.xpath("//button[text()='✕']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginPopup));
        loginPopup.click();

    }

    @Test
    public void testSelectMobile() throws InterruptedException {
        String amount = flipkartHomePage.selectItem("Vivo")
                .selectMobile("Vivo Z1Pro")
                .addItemToCart("ADD TO CART")
                .increaseItemCount(1)
                .getPayableAmount();

        System.out.println(amount);
    }



}
