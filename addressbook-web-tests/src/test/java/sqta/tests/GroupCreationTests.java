package sqta.tests;

import org.testng.annotations.*;
import sqta.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test3", "test3", "test4"));
    }
}
