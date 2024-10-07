package stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.appium.base.TestBase;
import org.appium.screens.HomeScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyStepdefs extends TestBase {
    HomeScreen home;
    AppiumDriver driver;
    private DesiredCapabilities capabilities;

    @Before
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("9.0");
        options.setDeviceName("cpv");
        options.setAutomationName("UiAutomator2");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppPackage("com.swaglabsmobileapp");
        /*capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "9.0");
        capabilities.setCapability("appium:deviceName", "cpv");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);*/
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Given("App is opened")
    public void appIsOpened() {
        home = new HomeScreen(driver);
    }

    @When("User login in app")
    public void userLoginInApp() {
        home.userLogin();
    }

    @Then("Add item to cart")
    public void addItemToCart() {
        home.addItemToCart();
    }

    @When("User navigates to the cart")
    public void userNavigatesToTheCart() {
        home.goToCart();
    }

    @Then("User checkout the items")
    public void userCheckoutTheItems() {
        home.checkout();
    }

    @Then("Validate the order details")
    public void validateTheOrderDetails() throws InterruptedException {
        home.validateTheOrderAmount();
    }
}
