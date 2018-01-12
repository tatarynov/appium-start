package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactDetailsPage extends BasePage {

    @AndroidFindBy(id = "email")
    @iOSFindBy(accessibility = "email")
    private MobileElement email;

    public ContactDetailsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getEmailAddress() {
        return email.getText();
    }
}
