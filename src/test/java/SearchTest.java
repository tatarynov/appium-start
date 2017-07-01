import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactsListPage;

public class SearchTest extends BaseTest {


    @BeforeMethod
    public void preCondtions() {
        // call to BE
    }

    @Test
    public void testSearch() {
        ContactsListPage contactsListPage = new ContactsListPage(driver);
        contactsListPage.search("Joy");

        ContactDetailsPage contactDetailsPage = contactsListPage.clickOnFirstName();
        String emailAddress = contactDetailsPage.getEmailAddress();

        Assert.assertEquals(emailAddress, "alstclair11@yopmail.com");
    }
}
