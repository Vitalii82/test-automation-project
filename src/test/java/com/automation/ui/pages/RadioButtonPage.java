package com.automation.ui.pages;
import com.automation.ui.base.BasePage;
import com.automation.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {
    private Button yesRadio;
    private Label result;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        yesRadio = new Button(driver, By.xpath("//label[@for='yesRadio']"));
        result = new Label(driver, By.className("text-success"));
    }

    public void open() { open("radio-button"); }
    public void clickYes() { yesRadio.click(); }
    public String getResultText() { return result.getText(); }
}
