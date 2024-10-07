package org.appium.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appium.base.ScreenBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomeScreen extends ScreenBase {
    public HomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    WebDriverWait wd;
    @AndroidFindBy(accessibility = "test-Username")
    WebElement userName;

    @AndroidFindBy(accessibility = "test-Password")
    WebElement password;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"standard_user\")")
    WebElement selectUser;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]/following-sibling::android.view.ViewGroup/android.widget.TextView[contains(@text, \"ADD TO CART\")]")
    WebElement addItem1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Bike Light\"]/following-sibling::android.view.ViewGroup/android.widget.TextView[contains(@text, \"ADD TO CART\")]")
    WebElement addItem2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement cart;
    @AndroidFindBy(accessibility = "test-LOGIN")
    WebElement loginBtn;

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    WebElement checkoutBtn;

    @AndroidFindBy(accessibility = "test-REMOVE")
    WebElement removeItem;

    @AndroidFindBy(accessibility = "test-First Name")
    WebElement firstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    WebElement lastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    WebElement zipCode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CONTINUE\"]")
    WebElement continueBtn;

    @AndroidFindBy(accessibility = "test-FINISH")
    WebElement finishBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Total: \")]")
    WebElement totalAmount;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    WebElement successMessage;

    public void userLogin() {
        wd = new WebDriverWait(driver, Duration.ofSeconds(10));

        wd.until(ExpectedConditions.elementToBeClickable(selectUser)).click();

        wd.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void addItemToCart() {
        wd = new WebDriverWait(driver, Duration.ofSeconds(20));
        wd.until(ExpectedConditions.elementToBeClickable(addItem1)).click();
        wd.until(ExpectedConditions.elementToBeClickable(addItem2)).click();
    }

    public void goToCart() {
        wd = new WebDriverWait(driver, Duration.ofSeconds(10));
        wd.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public void checkout() {
        wd = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Identify Elememt using Text
        WebElement
                element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView("
                        + "new UiSelector().text(\"CHECKOUT\"))"));
        element.click();
//        wd.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        wd.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys("chandra");
        wd.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys("prakash");
        wd.until(ExpectedConditions.elementToBeClickable(zipCode)).sendKeys("226017");
        wd.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();


    }

    public void validateTheOrderAmount() throws InterruptedException {
        wd = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);
        //Identify Element using Text
        WebElement
                element = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView("
                        + "new UiSelector().description(\"test-FINISH\"))"));
        String amount = wd.until(ExpectedConditions.elementToBeClickable(totalAmount)).getText();
        wd.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
        String message = wd.until(ExpectedConditions.elementToBeClickable(successMessage)).getText();
        System.out.println("Order amount= " + amount);
        System.out.println("Success message= " + message);
        assertEquals("Total: $43.18", amount);
        assertEquals("THANK YOU FOR YOU ORDER", message);
    }
}
