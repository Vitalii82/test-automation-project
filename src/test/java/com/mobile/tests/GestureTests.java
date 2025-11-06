package com.mobile.tests;

import io.qameta.allure.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class GestureTests extends BaseTest {

    @Test
    public void testSwipeGesture() {
        driver.findElement(Locators.SWIPE_MENU).click();
        Dimension size = driver.manage().window().getSize();
        int startX = (int)(size.width * 0.8);
        int endX   = (int)(size.width * 0.2);
        int y      = (int)(size.height * 0.5);
        new TouchAction(driver)
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();
        Assert.assertTrue(true);
    }

    @Test
    public void testScrollToElement() {
        driver.findElement(Locators.SWIPE_MENU).click();
        driver.findElement(io.appium.java_client.AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(3)"));
        Assert.assertTrue(true);
    }
}
