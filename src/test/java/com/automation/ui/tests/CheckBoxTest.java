package com.automation.ui.tests;

import com.automation.ui.pages.CheckBoxPage;
import io.qameta.allure.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("UI")
@Feature("CheckBox")
@Story("Select home checkbox")
@Severity(SeverityLevel.NORMAL)
public class CheckBoxTest {

    private WebDriver driver;
    private CheckBoxPage checkBoxPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    @Description("Expand the tree, select Home checkbox and verify the result is shown")
    public void selectHomeCheckBox() {
        checkBoxPage.open();
        checkBoxPage.selectHome();
        Assert.assertTrue(checkBoxPage.isHomeSelected(),
                "Expected 'home' in result text after selecting Home checkbox");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
