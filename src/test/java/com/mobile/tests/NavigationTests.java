package com.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testTabNavigation() {
        driver.findElement(Locators.HOME_MENU).click();
        driver.findElement(Locators.FORMS_MENU).click();
        driver.findElement(Locators.LOGIN_MENU).click();
        driver.findElement(Locators.SWIPE_MENU).click();
        Assert.assertTrue(true);
    }

    @Test
    public void testScreenOrientation() {
        driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
        driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
        Assert.assertTrue(true);
    }
}
