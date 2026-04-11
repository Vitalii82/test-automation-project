package com.automation.ui.pages;

import com.automation.ui.base.BasePage;
import com.automation.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablesPage extends BasePage {
    private Button addButton;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        addButton = new Button(driver, By.id("addNewRecordButton"));
    }

    private static final By SEARCH_BOX = By.id("searchBox");
    private static final By TABLE_ROWS = By.cssSelector(".rt-td");

    public void open() {
        open("webtables");
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, #adplus-anchor, .adsbygoogle').forEach(el => el.remove());");
    }

    public void search(String term) {
        waitForClickable(SEARCH_BOX);
        org.openqa.selenium.WebElement box = driver.findElement(SEARCH_BOX);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", box);
        box.clear();
        box.sendKeys(term);
    }

    public boolean isRowVisible(String text) {
        return driver.findElements(TABLE_ROWS).stream()
                .anyMatch(e -> e.getText().equals(text));
    }

    public boolean isRowPresent(String... columnValues) {
        try {
            wait.until(d -> {
                for (org.openqa.selenium.WebElement rowGroup :
                        d.findElements(By.cssSelector(".rt-tbody .rt-tr-group"))) {
                    try {
                        List<org.openqa.selenium.WebElement> rows = rowGroup.findElements(By.cssSelector(".rt-tr"));
                        if (rows.isEmpty()) continue;
                        List<String> cells = rows.get(0).findElements(By.cssSelector(".rt-td"))
                                .stream().map(e -> e.getText().trim()).collect(Collectors.toList());
                        if (cells.size() < 2 || cells.stream().allMatch(String::isEmpty)) continue;
                        if (cells.get(0).equals(columnValues[0].trim()) &&
                            cells.get(1).equals(columnValues[1].trim())) {
                            return true;
                        }
                    } catch (StaleElementReferenceException ignored) {}
                }
                return false;
            });
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean hasNoResults() {
        try {
            wait.until(d -> d.findElements(By.cssSelector(".rt-tbody .rt-td")).stream()
                .allMatch(c -> c.getText().trim().isEmpty()));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
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
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".rt-tbody"), first));
    }
}
