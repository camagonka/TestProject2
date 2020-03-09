package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if(! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("firstname", "test_surname", "test2"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("firstname123", "test_surname123", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
