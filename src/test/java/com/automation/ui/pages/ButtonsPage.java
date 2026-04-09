package com.automation.ui.pages;

import com.automation.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeBtn;

    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() { super.open("buttons"); }

    public boolean doubleClick() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return !driver.findElements(By.id("doubleClickMessage")).isEmpty()
                && driver.findElement(By.id("doubleClickMessage")).isDisplayed();
    }

    public void rightClickButton() {
        new Actions(driver).contextClick(rightClickBtn).perform();
    }

    public void singleClickButton() {
        clickMeBtn.click();
    }
}
