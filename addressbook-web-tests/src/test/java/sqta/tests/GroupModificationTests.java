package sqta.tests;

import org.testng.annotations.Test;
import sqta.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModificationTests(){

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupCreation(new GroupData("test123","test123","test123"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
