import io.qameta.allure.*;
package com.automation.ui.base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseElement {
    protected WebDriver driver;
    protected By locator;

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void click() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText() {
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return el.getText();
    }

    public boolean isVisible() {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
