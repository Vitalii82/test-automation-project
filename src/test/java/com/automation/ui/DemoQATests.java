package com.automation.ui.tests;

import com.automation.ui.pages.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoQATests {
    private WebDriver driver;
    private TextBoxPage textBoxPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        try {
            // Setup Chrome driver automatically
            WebDriverManager.chromedriver().setup();

            // Safe Chrome options (avoid crash in headless, OneDrive, etc.)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            textBoxPage = new TextBoxPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to initialize WebDriver: " + e.getMessage());
        }
    }

    @Test
    public void fillTextBoxForm() {
        textBoxPage.open();
        textBoxPage.fillForm("Vitalii", "demo@mail.com", "Lutsk", "Ukraine");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
