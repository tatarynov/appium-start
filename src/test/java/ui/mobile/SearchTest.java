package ui.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactsListPage;

public class SearchTest extends BaseTest {

    private static Logger LOG = LoggerFactory.getLogger(SearchTest.class);

    @BeforeMethod
    public void preCondtions() {
        // just example
        // some call to BE
        // pre-conditions in DB
    }

    @DataProvider(name = "names")
    public static Object[][] names() {
        return new Object[][]{
                // expected format: {"some name", "expected email"}
                {"Jenny Cherry", "jqjenny16@yopmail.com"},
                {"Garance", "duepperson20@gmail.com"},
                {"Joy", "alstclair11@yopmail.com"},
                {"NotExisted", "notexisted@gmail.com"}
        };
    }

    @Test(description = "[Android] Search test",
            dataProvider = "names")
    public void testSearch(String name, String email) {
        LOG.info("Search test starts");
        LOG.info("Step 1 - Searching contact\n");
        ContactsListPage contactsListPage = new ContactsListPage(driver);
        contactsListPage.search(name);

        LOG.info("Step 2 - Clicking on found contact\n");
        ContactDetailsPage contactDetailsPage = contactsListPage.clickOnFirstName();
        String emailAddress = contactDetailsPage.getEmailAddress();

        LOG.info("Step 3 - Verifying contact card information\n");
        Assert.assertEquals(emailAddress, email);
        contactDetailsPage.goBack();
    }
}
