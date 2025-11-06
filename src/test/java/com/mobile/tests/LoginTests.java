package com.mobile.tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginValidCredentials() {
        driver.findElement(Locators.LOGIN_MENU).click();
        driver.findElement(Locators.INPUT_EMAIL).sendKeys("test@demo.com");
        driver.findElement(Locators.INPUT_PASSWORD).sendKeys("password");
        driver.findElement(Locators.BTN_LOGIN).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement status = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TXT_LOGIN_STATUS));
        Assert.assertTrue(status.getText().toLowerCase().contains("success"));
    }

    @Test
    public void testLoginInvalidCredentials() {
        driver.findElement(Locators.LOGIN_MENU).click();
        driver.findElement(Locators.INPUT_EMAIL).clear();
        driver.findElement(Locators.INPUT_EMAIL).sendKeys("wrong@demo.com");
        driver.findElement(Locators.INPUT_PASSWORD).clear();
        driver.findElement(Locators.INPUT_PASSWORD).sendKeys("wrong");
        driver.findElement(Locators.BTN_LOGIN).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement status = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TXT_LOGIN_STATUS));
        Assert.assertTrue(status.getText().toLowerCase().contains("fail") || status.getText().toLowerCase().contains("invalid"));
    }
}
