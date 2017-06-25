package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class BasePage {

    AppiumDriver<MobileElement> driver;
    static boolean ios = false;
    static boolean android = false;

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

    public void scrollDownAndroid(MobileElement element) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();

        TouchAction action = new TouchAction(driver);
        action.press(x, y).moveTo(x, y + 50).release().perform();
    }

    // Not working, need to investigate
    public void scrollToElement(String text) {
        String query = String.format("new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView(" +
                "new UiSelector().text(\"%s\"));", text);
        MobileElement element = ((AndroidDriver<MobileElement>) driver)
                .findElementByAndroidUIAutomator(query);
        element.click();
    }
}
