import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends BaseTest {

    @Test
    public void firstWebTest() {
        driver.get("https://google.com.ua");
        MobileElement input = driver.findElement(MobileBy.xpath("//input[@id='lst-ib']"));
        input.sendKeys("appium web automation");
        input.submit();

        MobileElement elementByPartialLinkText = driver
                .findElementByPartialLinkText("Introduction - Appium: Mobile App Automation Made Awesome.");
        Assert.assertTrue(elementByPartialLinkText.isDisplayed());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
