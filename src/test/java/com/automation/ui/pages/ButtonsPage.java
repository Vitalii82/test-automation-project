package com.automation.ui.pages;

import com.automation.ui.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeBtn;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void doubleClickButton() {
        doubleClickBtn.click();
    }

    public void rightClickButton() {
        rightClickBtn.click();
    }

    public void singleClickButton() {
        clickMeBtn.click();
    }
}
