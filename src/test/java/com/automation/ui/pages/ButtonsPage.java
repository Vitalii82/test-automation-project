package com.automation.ui.pages;
import com.automation.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void open() { open("buttons"); }
    public boolean doubleClick() {
        WebElement dblBtn = driver.findElement(By.id("doubleClickBtn"));
        new Actions(driver).doubleClick(dblBtn).perform();
        return driver.findElement(By.id("doubleClickMessage")).isDisplayed();
    }
}
