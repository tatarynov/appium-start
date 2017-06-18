import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {

    AppiumDriver<MobileElement> driver;
    boolean ios = false;
    boolean android = false;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void getPlatofrmName() {
        String platformName = (String) driver.getCapabilities().getCapability("platformName");
        if (platformName.equals("Android")) {
            android = true;
        } else {
            ios = true;
        }
    }
}
