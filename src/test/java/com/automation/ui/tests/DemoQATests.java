package com.automation.ui.tests;
import com.automation.ui.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.ui.pages.*;

@Epic("UI")
@Feature("E2E")
@Story("Baseline Flow")
@Severity(SeverityLevel.NORMAL)
public class DemoQATests extends BaseTest {
    private TextBoxPage textBoxPage;
    private RadioButtonPage radioPage;
    private WebTablesPage tablesPage;
    private ButtonsPage buttonsPage;
    private ModalDialogsPage modalPage;

    @BeforeClass
    public void initPages() {
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

    @Test(groups = "flaky")
    public void testWebTables() {
        tablesPage.open();
        tablesPage.addNewUser("Bob", "Marley", "bob@example.com", "36", "6000", "Music");
        Assert.assertTrue(tablesPage.isRowPresent("Bob", "Marley", "bob@example.com", "36", "6000", "Music"),
            "Newly added row for Bob Marley not found in table!");
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

    @Test(groups = "flaky")
    @Description("Search WebTables by first name and verify result row is shown")
    public void testWebTablesSearch() {
        tablesPage.open();
        tablesPage.search("Cierra");
        Assert.assertTrue(tablesPage.isRowPresent("Cierra", "Vega", "cierra@example.com", "39", "10000", "Insurance"),
            "Search for 'Cierra' should show Cierra Vega's complete row!");
    }

    @Test(groups = "flaky")
    @Description("Search WebTables with a term that matches no rows and verify empty state is shown")
    public void testWebTablesSearchNoResults() {
        tablesPage.open();
        tablesPage.search("zzz_no_match");
        Assert.assertTrue(tablesPage.hasNoResults(),
            "Table should show no results for an unmatched search term");
    }

}
