package com.automation.ui.elements;

import io.qameta.allure.*;
import com.automation.ui.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TextBox extends BaseElement {
    public TextBox(WebDriver driver, By locator) {
        super(driver, locator);
    }
    public void type(String text) {
        WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }
}
