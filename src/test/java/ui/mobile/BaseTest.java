package ui.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import support.adb.AdbController;
import support.reports.ExtentReportsListener;
import support.utils.DriverManager;
import support.utils.PlatformManager;

@Listeners(ExtentReportsListener.class)
public class BaseTest {

    private DriverManager driverManager = new DriverManager();
    private PlatformManager platformManager = new PlatformManager();
    private PlatformManager.Platform platform;
    private PlatformManager.Browser browser;

    protected AdbController adbController = new AdbController();
    protected AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = driverManager.setUp();
        platform = platformManager.getPlatform();
        browser = platformManager.getBrowser();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driverManager.getServer().killAppiumProcess();
    }
}
