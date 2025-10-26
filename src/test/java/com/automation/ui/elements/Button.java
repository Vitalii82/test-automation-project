package com.automation.ui.elements;
import com.automation.ui.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Button extends BaseElement {
    public Button(WebDriver driver, By locator) {
        super(driver, locator);
    }
}
