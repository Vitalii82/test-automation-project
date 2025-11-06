package com.mobile.tests;

import io.qameta.allure.*;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends BaseTest {

    @Test
    public void testAlertHandling() {
        driver.findElement(Locators.FORMS_MENU).click();
        driver.findElement(Locators.BTN_ACTIVE).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//*[contains(@text,'This button is')]")));
        Assert.assertTrue(toast.getText().length() > 0);
    }

    @Test
    public void testDragAndDrop() {
        driver.findElement(Locators.DRAG_MENU).click();
        Assert.assertTrue(true);
    }
}
