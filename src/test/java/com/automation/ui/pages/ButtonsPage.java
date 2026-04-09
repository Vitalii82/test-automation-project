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
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "var el = arguments[0];" +
            "el.scrollIntoView({block:'center'});" +
            "var ev = new MouseEvent('dblclick', {bubbles:true, cancelable:true});" +
            "el.dispatchEvent(ev);",
            doubleClickBtn);
        try {
            WebElement msg = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                    .visibilityOfElementLocated(By.id("doubleClickMessage")));
            return msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void rightClickButton() {
        new Actions(driver).contextClick(rightClickBtn).perform();
    }

    public void singleClickButton() {
        clickMeBtn.click();
    }
}
