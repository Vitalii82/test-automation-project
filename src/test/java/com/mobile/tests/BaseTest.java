import io.qameta.allure.*;
package com.mobile.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

@Epic("Mobile")
@Feature("E2E")
@Story("Baseline Flow")
@Severity(SeverityLevel.NORMAL)
public class BaseTest {
    protected AndroidDriver driver;
    protected Properties cfg;

    @BeforeClass
    public void setUp() throws Exception {
        cfg = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/_config.properties")) {
            cfg.load(fis);
        }
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(cfg.getProperty("capabilities.platformName", "Android"));
        options.setAutomationName(cfg.getProperty("capabilities.automationName", "UiAutomator2"));
        options.setDeviceName(cfg.getProperty("capabilities.deviceName", "Android Emulator"));

        String appPath = cfg.getProperty("capabilities.app", "apps/Android-NativeDemoApp-1.0.8.apk");
        if (Files.exists(Paths.get(appPath))) {
            options.setApp(appPath);
        }

        String appPackage = cfg.getProperty("capabilities.appPackage", "");
        String appActivity = cfg.getProperty("capabilities.appActivity", "");
        if (!appPackage.isEmpty()) options.setAppPackage(appPackage);
        if (!appActivity.isEmpty()) options.setAppActivity(appActivity);

        String appiumUrl = cfg.getProperty("appium_url", "http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(new URL(appiumUrl), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
