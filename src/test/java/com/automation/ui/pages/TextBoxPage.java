package com.automation.ui.pages;
import com.automation.ui.base.BasePage;
import com.automation.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
    private TextBox fullName;
    private TextBox email;
    private TextBox currentAddress;
    private TextBox permanentAddress;
    private Button submit;
    private Label output;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        fullName = new TextBox(driver, By.id("userName"));
        email = new TextBox(driver, By.id("userEmail"));
        currentAddress = new TextBox(driver, By.id("currentAddress"));
        permanentAddress = new TextBox(driver, By.id("permanentAddress"));
        submit = new Button(driver, By.id("submit"));
        output = new Label(driver, By.id("output"));
    }

    public void open() { open("text-box"); }
    public void fillForm(String name, String mail, String curr, String perm) {
        fullName.type(name);
        email.type(mail);
        currentAddress.type(curr);
        permanentAddress.type(perm);
    }
    public void submitForm() { submit.click(); }
    public boolean isOutputVisible() { return output.isVisible(); }
}
