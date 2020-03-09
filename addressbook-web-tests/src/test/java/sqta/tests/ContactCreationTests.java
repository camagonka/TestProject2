package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().createContact(new ContactData("firstname", "test_surname", "test2"), true);
    }

}

