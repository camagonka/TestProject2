package sqta.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sqta.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() throws Exception {
        app.goTo().gotoContactPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("firstname1", "test4", "test_surname");
        app.getContactHelper().createContact((contact), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);

        //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        //спользование компоратора для выявления максимального id
        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        //Сортировка списка с помощью компоратора
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}

