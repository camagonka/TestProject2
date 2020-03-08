package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModificationTests(){
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test3", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupCreation(new GroupData("test2","test3","test123"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
