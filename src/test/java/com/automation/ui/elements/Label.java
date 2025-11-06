import io.qameta.allure.*;
package com.automation.ui.elements;
import com.automation.ui.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Label extends BaseElement {
    public Label(WebDriver driver, By locator) {
        super(driver, locator);
    }
}
