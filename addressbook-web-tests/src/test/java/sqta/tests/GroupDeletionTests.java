package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletionTests() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test3", null, null));
        }
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().deleteSelectedGroups();
            app.getGroupHelper().returnToGroupPage();
        }


}
