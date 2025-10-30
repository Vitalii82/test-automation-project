package com.mobile.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTests extends BaseTest {

    @Test
    public void testFormSubmission() {
        driver.findElement(Locators.FORMS_MENU).click();
        driver.findElement(Locators.INPUT_TEXT).sendKeys("Hello Carina");
        driver.findElement(Locators.SWITCH).click();
        driver.findElement(Locators.DROPDOWN).click();
        driver.findElement(Locators.DROPDOWN_OPTION).click();
        driver.findElement(Locators.BTN_ACTIVE).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[contains(@text,'This button is')]")));
        Assert.assertTrue(toast.getText().length() > 0);
    }

    @Test
    public void testSwitchToggle() {
        driver.findElement(Locators.FORMS_MENU).click();
        WebElement switchEl = driver.findElement(Locators.SWITCH);
        switchEl.click();
        switchEl.click();
        Assert.assertTrue(switchEl.isDisplayed());
    }
}
