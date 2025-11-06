package com.automation.ui;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class UITests extends BaseTest {

    @Test
    public void clickAndVerifyTitle() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("A/B Testing")).click();
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }

    @Test
    public void textInput() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("123");
        Assert.assertEquals(input.getAttribute("value"), "123");
    }

    @Test
    public void dropdownSelect() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
    }

    @Test
    public void checkBoxToggle() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        if (!checkbox.isSelected()) checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }

    @Test
    public void handleAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(result.contains("You successfully clicked an alert"));
    }

    @Test
    public void scrollToElement() {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1000)");
        Assert.assertTrue(driver.getPageSource().contains("Infinite Scroll"));
    }

    @Test
    public void hoverAction() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement avatar = driver.findElement(By.className("figure"));
        actions.moveToElement(avatar).perform();
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void takeScreenshot() throws IOException {
        driver.get("https://the-internet.herokuapp.com/");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dst = new File("target/screenshot.png");
        FileUtils.copyFile(src, dst);
        Assert.assertTrue(dst.exists());
    }

    @Test
    public void navigationTest() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.navigate().to("https://the-internet.herokuapp.com/abtest");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("the-internet"));
    }

    @Test
    public void dynamicContentTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_content");
        List<WebElement> paragraphs = driver.findElements(By.cssSelector(".large-10"));
        Assert.assertTrue(paragraphs.size() > 0);
    }
}
