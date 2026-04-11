package com.automation.ui.tests;

import com.automation.ui.BaseTest;
import com.automation.ui.pages.CheckBoxPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("UI")
@Feature("CheckBox")
public class CheckBoxTest extends BaseTest {

    private CheckBoxPage checkBoxPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    @Story("Select home checkbox")
    @Severity(SeverityLevel.NORMAL)
    @Description("Expand the tree, select Home checkbox and verify the result is shown")
    public void selectHomeCheckBox() {
        checkBoxPage.open();
        checkBoxPage.selectHome();
        Assert.assertTrue(checkBoxPage.isHomeSelected(),
                "Expected 'home' in result text after selecting Home checkbox");
    }
}
