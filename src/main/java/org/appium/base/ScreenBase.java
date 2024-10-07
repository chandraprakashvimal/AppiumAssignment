package org.appium.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase {
    public static AppiumDriver driver;
    public ScreenBase(AppiumDriver driver) {
        ScreenBase.driver = driver;
    }
}
