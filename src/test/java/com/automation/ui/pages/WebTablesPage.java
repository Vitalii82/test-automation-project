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

    private static final By SEARCH_BOX = By.id("searchBox");
    private static final By TABLE_ROWS = By.cssSelector(".rt-td");

    public void open() { open("webtables"); }

    public void search(String term) {
        waitForClickable(SEARCH_BOX);
        driver.findElement(SEARCH_BOX).sendKeys(term);
    }

    public boolean isRowVisible(String text) {
        return driver.findElements(TABLE_ROWS).stream()
                .anyMatch(e -> e.getText().equals(text));
    }

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
