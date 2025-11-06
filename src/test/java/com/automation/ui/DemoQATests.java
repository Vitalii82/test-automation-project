package com.automation.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.automation.ui.pages.TextBoxPage;

public class DemoQATests {
    private WebDriver driver;
    private TextBoxPage textBoxPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void testTextBoxForm() {
        textBoxPage.open();
        textBoxPage.fillForm("Vitalii", "test@mail.com", "Lutsk", "Ukraine");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
