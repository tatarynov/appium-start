import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactsListPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSearch() {
        ContactsListPage contactsListPage = new ContactsListPage(driver);
        contactsListPage.search("Joy");

        ContactDetailsPage contactDetailsPage = contactsListPage.clickOnFirstName();
        String emailAddress = contactDetailsPage.getEmailAddress();

        Assert.assertEquals("alstclair11@yopmail.com", emailAddress);
    }
}
