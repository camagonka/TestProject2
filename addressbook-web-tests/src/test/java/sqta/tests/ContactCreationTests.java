package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactCreation(new ContactData("firstname", "lastname"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}

