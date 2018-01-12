package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import support.utils.DriverManager;

import java.util.HashMap;

public class BasePage {

    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void scrollDownIos(double seconds) {
        // iOS - Scroll down
        HashMap<String, String> swipeObject = new HashMap<>();
        swipeObject.put("duration", String.valueOf(seconds));
        swipeObject.put("direction", "up");
        driver.executeScript("mobile: swipe", swipeObject);
    }

    public void scrollDownIos() {
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        driver.executeScript("mobile: scroll", scrollObject);
    }

    // Not working, need to investigate
    public void scrollToElement(String scrollableContent, String text) {
        String query = String.format("new UiScrollable(new UiSelector().resourceId(\"%s\")).scrollIntoView(" +
                "new UiSelector().text(\"%s\"));", scrollableContent, text);
        MobileElement element = ((AndroidDriver<MobileElement>) driver)
                .findElementByAndroidUIAutomator(query);
        element.click();
    }

    // Android
    public void scrollToElement(MobileElement elementFrom, MobileElement elementTo) {
        Point locationFrom = elementFrom.getLocation();
        Point locationTo = elementTo.getLocation();
        new TouchAction(driver)
                .press(PointOption.point(locationFrom.getX(), locationFrom.getY()))
                .moveTo(PointOption.point(locationTo.getX(), locationTo.getY()))
                .perform();
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void goBack() {
        driver.navigate().back();
    }
}
