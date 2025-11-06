package com.automation.ui.pages;

import io.qameta.allure.*;
import com.automation.ui.base.BasePage;
import com.automation.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends BasePage {
    private Button addButton;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        addButton = new Button(driver, By.id("addNewRecordButton"));
    }

    public void open() { open("webtables"); }
    public void addNewUser(String first, String last, String mail, String age, String salary, String dep) {
        addButton.click();
        new TextBox(driver, By.id("firstName")).type(first);
        new TextBox(driver, By.id("lastName")).type(last);
        new TextBox(driver, By.id("userEmail")).type(mail);
        new TextBox(driver, By.id("age")).type(age);
        new TextBox(driver, By.id("salary")).type(salary);
        new TextBox(driver, By.id("department")).type(dep);
        new Button(driver, By.id("submit")).click();
    }
}
