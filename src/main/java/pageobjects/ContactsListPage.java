package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactsListPage extends BasePage {

    @AndroidFindBy(id = "main_search")
    @iOSFindBy(xpath = "")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.jayway.contacts:id/name']")
    @iOSFindBy(xpath = "")
    private MobileElement firstName;

    public ContactsListPage(AppiumDriver driver) {
        super(driver);
    }

    public void search(String name) {
        searchField.sendKeys(name);
    }

    public ContactDetailsPage clickOnFirstName() {
        firstName.click();
        return new ContactDetailsPage(driver);
    }
}
