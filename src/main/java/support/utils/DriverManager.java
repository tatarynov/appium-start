package support.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;


public class DriverManager {

    private AppiumServer invokeAppiumServer = new AppiumServer();
    private PlatformManager platformManager = new PlatformManager();

    private AppiumDriver<MobileElement> driver;
    private PlatformManager.Platform platform;
    private PlatformManager.Browser browser;

    private static ThreadLocal<AppiumServer> appiumServerThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver<MobileElement>> driverThreadLocal = new ThreadLocal<>();

    public AppiumDriver<MobileElement> setUp() throws Exception {
        String appiumUrl = invokeAppiumServer.startAppiumServer();
        appiumServerThreadLocal.set(invokeAppiumServer);

        platform = platformManager.getPlatform();
        browser = platformManager.getBrowser();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
            if (platform.equals(PlatformManager.Platform.ANDROID)) {
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "Contacts.apk");

                capabilities.setCapability(PLATFORM_NAME, "Android");
                capabilities.setCapability(DEVICE_NAME, "Any");
                capabilities.setCapability(APP, app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.jayway.contacts");
                capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
                capabilities.setCapability("newCommandSettingsTimeout", "3000");
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

                driver = new AndroidDriver<>(new URL(appiumUrl), capabilities);
            } else if (platform.equals(PlatformManager.Platform.IOS)) {
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/iOS");
                File app = new File(appDir, "ContactsSimulator.app");

                capabilities.setCapability(PLATFORM_NAME, "iOS");
                capabilities.setCapability(DEVICE_NAME, "iPhone Simulator");
                capabilities.setCapability(APP, app.getAbsolutePath());
                capabilities.setCapability(AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(NO_RESET, true);
                capabilities.setCapability(NEW_COMMAND_TIMEOUT, "30000");

                driver = new IOSDriver<>(new URL(appiumUrl), capabilities);
            } else if (platform.equals(PlatformManager.Platform.WEB) && browser.equals("safari")) {
                capabilities.setCapability("browserName", MobileBrowserType.SAFARI);
                capabilities.setCapability("deviceName", "iPhone Simulator");
                capabilities.setCapability("platformVersion", "10.2");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformName", MobilePlatform.IOS);

                driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else if (platform.equals(PlatformManager.Platform.WEB) && browser.equals("chrome")) {
                capabilities.setCapability("platformName", MobilePlatform.ANDROID);
                capabilities.setCapability("browserName", MobileBrowserType.CHROME);
                capabilities.setCapability("deviceName", "ChromeTest");

                driver = new AppiumDriver<>(new URL(appiumUrl), capabilities);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driverThreadLocal.set(driver);

        return driver;
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driverThreadLocal.get();
    }

    public AppiumServer getServer() {
        return appiumServerThreadLocal.get();
    }
}
