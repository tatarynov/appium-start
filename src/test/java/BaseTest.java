import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class BaseTest {

    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() {
        String platformName = System.getProperty("env");
        String browser = System.getProperty("browser");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            if (platformName.equals("android")) {
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "FasTip.apk");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "NotUsed");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "org.traeg.fastip");
                capabilities.setCapability("appActivity", "org.traeg.fastip.MainActivity");
                capabilities.setCapability("newCommandSettingsTimeout", "300");
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else if (platformName.equals("ios")) {
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/iOS");
                File app = new File(appDir, "ContactsSimulator.app");
                capabilities.setCapability(PLATFORM_NAME, "iOS");
                capabilities.setCapability(DEVICE_NAME, "iPhone Simulator");
                capabilities.setCapability(APP, app.getAbsolutePath());
                capabilities.setCapability(AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(NO_RESET, true);
                capabilities.setCapability(NEW_COMMAND_TIMEOUT, "300");
                driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else if (platformName.equals("web") && browser.equals("safari")) {
                capabilities.setCapability("browserName", MobileBrowserType.SAFARI);
                capabilities.setCapability("deviceName", "iPhone Simulator");
                capabilities.setCapability("platformVersion", "10.2");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformName", MobilePlatform.IOS);
                driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else if (platformName.equals("web") && browser.equals("chrome")) {
                capabilities.setCapability("platformName", MobilePlatform.ANDROID);
                capabilities.setCapability("browserName", MobileBrowserType.CHROME);
                capabilities.setCapability("deviceName", "ChromeTest");
                driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
