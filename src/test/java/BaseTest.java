import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobjects.BasePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    static AndroidDriver<MobileElement> driver;
    public Platform platform = Platform.IOS;

    enum Platform {
        IOS,
        ANDROID
    }

    @BeforeTest
    public void setUp() {
        if (platform.equals(Platform.IOS)) {

        } else if (platform.equals(Platform.ANDROID)) {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "/app/Android");
            File app = new File(appDir, "Contacts.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "NotUsed");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", "com.jayway.contacts");
            capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
            capabilities.setCapability("newCommandTimeout", "300");
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        new BasePage(driver).setPlatform();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
