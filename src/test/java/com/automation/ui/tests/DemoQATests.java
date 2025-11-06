import io.qameta.allure.*;
package com.automation.ui.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.ui.pages.*;

@Epic("UI")
@Feature("E2E")
@Story("Baseline Flow")
@Severity(SeverityLevel.NORMAL)
public class DemoQATests {
    private WebDriver driver;
    private TextBoxPage textBoxPage;
    private RadioButtonPage radioPage;
    private WebTablesPage tablesPage;
    private ButtonsPage buttonsPage;
    private ModalDialogsPage modalPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
