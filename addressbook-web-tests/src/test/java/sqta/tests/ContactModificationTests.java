package sqta.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sqta.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
        app.goTo().gotoContactPage();
        if(! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("firstname", "test2", "test_surname"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("firstname123", null, "test_surname123"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(after, before);
    }
}
