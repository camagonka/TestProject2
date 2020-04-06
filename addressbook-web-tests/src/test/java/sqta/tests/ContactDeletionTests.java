package sqta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sqta.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactDeletionTests extends TestBase {

    @Test(enabled = false)
    public void testContactDeletionTests() throws Exception {
        app.goTo().gotoContactPage();
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData("firstname", "test2", "test_surname"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactDeletion(before.size() - 1);
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().goToContactsBack();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size()-1);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Assert.assertEquals(before, after);
    }
}
