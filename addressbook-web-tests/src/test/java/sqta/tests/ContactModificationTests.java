package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
