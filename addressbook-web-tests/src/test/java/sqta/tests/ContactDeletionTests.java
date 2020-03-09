package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.ContactData;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testGroupDeletionTests() throws Exception {
        app.getNavigationHelper().gotoContactPage();
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData("firstname", "test_surname", "test2"), true);
        }
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().submitContactDeletion();
    }
}
