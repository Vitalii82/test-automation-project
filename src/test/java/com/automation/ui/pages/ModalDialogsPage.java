import io.qameta.allure.*;
package com.automation.ui.pages;
import com.automation.ui.base.BasePage;
import com.automation.ui.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalDialogsPage extends BasePage {
    private Button showModal;

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
        showModal = new Button(driver, By.id("showSmallModal"));
    }

    public void open() { open("modal-dialogs"); }
    public boolean openAndVerifyModal() {
        showModal.click();
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        boolean displayed = modal.isDisplayed();
        driver.findElement(By.id("closeSmallModal")).click();
        return displayed;
    }
}
