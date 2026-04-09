package com.automation.ui.tests;
import io.qameta.allure.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.ui.pages.*;
import java.time.Duration;

@Epic("UI")
@Feature("E2E")
@Story("Baseline Flow")
@Severity(SeverityLevel.NORMAL)
public class DemoQATests {
    private WebDriver driver;
    private WebDriverWait wait;
    private TextBoxPage textBoxPage;
    private RadioButtonPage radioPage;
    private WebTablesPage tablesPage;
    private ButtonsPage buttonsPage;
    private ModalDialogsPage modalPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        textBoxPage = new TextBoxPage(driver);
        radioPage = new RadioButtonPage(driver);
        tablesPage = new WebTablesPage(driver);
        buttonsPage = new ButtonsPage(driver);
        modalPage = new ModalDialogsPage(driver);
    }

    @DataProvider(name = "formData")
    public Object[][] getFormData() {
        return new Object[][] {
            {"John Doe", "john@example.com", "Kyiv", "Odessa"},
            {"Alice Smith", "alice@example.com", "Lviv", "Kharkiv"}
        };
    }

    @Test(dataProvider = "formData")
    public void testTextBoxForm(String name, String email, String curr, String perm) {
        textBoxPage.open();
        textBoxPage.fillForm(name, email, curr, perm);
        textBoxPage.submitForm();
        Assert.assertTrue(textBoxPage.isOutputVisible(), "Form output not visible!");
    }

    @Test
    public void testRadioButton() {
        radioPage.open();
        radioPage.clickYes();
        Assert.assertEquals(radioPage.getResultText(), "Yes");
    }

    @Test
    public void testWebTables() {
        tablesPage.open();
        tablesPage.addNewUser("Bob", "Marley", "bob@example.com", "36", "6000", "Music");
        Assert.assertTrue(driver.getPageSource().contains("Bob"));
    }

    @Test
    public void testButtons() {
        buttonsPage.open();
        Assert.assertTrue(buttonsPage.doubleClick(), "Double click message missing!");
    }

    @Test
    public void testModalDialog() {
        modalPage.open();
        Assert.assertTrue(modalPage.openAndVerifyModal(), "Modal not displayed!");
    }

    @Test
    @Description("Search WebTables by first name and verify result row is shown")
    public void testWebTablesSearch() {
        tablesPage.open();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox")));
        driver.findElement(By.id("searchBox")).sendKeys("Cierra");
        Assert.assertTrue(driver.getPageSource().contains("Cierra"),
            "Search for 'Cierra' should show matching row");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
