import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ContactsListPage extends BasePage {

    public ContactsListPage(AppiumDriver driver) {
        super(driver);
    }

    public void search(String name) {
        MobileElement searchField = driver.findElementById("main_search");
        searchField.sendKeys(name);
    }

    public void clickOnFirstName() {
        if (android) {
            MobileElement elementByXpath = driver.findElementByXPath(
                    "//android.widget.TextView[@resource-id='com.jayway.contacts:id/name']");
            elementByXpath.click();
        } else {
            MobileElement elementByXpath = driver.findElementByXPath(""); //TODO: add locator for iOS
            elementByXpath.click();
        }
    }
}
