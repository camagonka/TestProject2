package sqta.tests;

import org.testng.annotations.*;
import sqta.model.GroupData;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
      app.gotoGroupPage();
      app.initGroupCreation();
      app.fillGroupCreation(new GroupData("test2", "test3", "test4"));
      app.submitGroupCreation();
      app.returnToGroupPage();
    }

}
