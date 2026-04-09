package com.automation.ui.pages;

import com.automation.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Tests the Accordian page (demoqa.com/accordian).
 * Simple collapse/expand — no React tree, no ads interference.
 */
public class CheckBoxPage extends BasePage {

    private final By firstSection  = By.id("section1Heading");
    private final By firstContent  = By.id("section1Content");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/accordian");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSection));
    }

    /** Clicks section 1 heading via JS to avoid overlay. */
    public void selectHome() {
        WebElement heading = driver.findElement(firstSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", heading);
    }

    /** Returns true if section 1 content panel is visible. */
    public boolean isHomeSelected() {
        try {
            WebElement content = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstContent));
            return content.isDisplayed() && !content.getText().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
