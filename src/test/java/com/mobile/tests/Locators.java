package com.mobile.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Locators {
    public static final By LOGIN_MENU = AppiumBy.accessibilityId("Login");
    public static final By FORMS_MENU = AppiumBy.accessibilityId("Forms");
    public static final By SWIPE_MENU = AppiumBy.accessibilityId("Swipe");
    public static final By DRAG_MENU = AppiumBy.accessibilityId("Drag");
    public static final By HOME_MENU = AppiumBy.accessibilityId("Home");

    public static final By INPUT_EMAIL = AppiumBy.accessibilityId("input-email");
    public static final By INPUT_PASSWORD = AppiumBy.accessibilityId("input-password");
    public static final By BTN_LOGIN = AppiumBy.accessibilityId("button-LOGIN");
    public static final By TXT_LOGIN_STATUS = AppiumBy.xpath("//*[@content-desc='login-text' or @text='Success' or @text='Fail']");

    public static final By INPUT_TEXT = AppiumBy.accessibilityId("text-input");
    public static final By SWITCH = AppiumBy.accessibilityId("switch");
    public static final By DROPDOWN = AppiumBy.accessibilityId("Dropdown");
    public static final By DROPDOWN_OPTION = AppiumBy.androidUIAutomator("new UiSelector().text(\"This app is awesome\")");
    public static final By BTN_ACTIVE = AppiumBy.accessibilityId("button-Active");

    public static final By SWIPE_CARD = AppiumBy.accessibilityId("slideTextContainer");

    public static final By DRAG_SRC = AppiumBy.accessibilityId("drag-c1");
    public static final By DRAG_TGT = AppiumBy.accessibilityId("drop-c1");
}
