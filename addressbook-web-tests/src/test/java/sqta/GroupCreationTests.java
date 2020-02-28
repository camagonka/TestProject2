package sqta;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
      gotoGroupPage();
      initGroupCreation();
      fillGroupCreation(new GroupData("test2", "test3", "test4"));
      submitGroupCreation();
      returnToGroupPage();
    }

}
