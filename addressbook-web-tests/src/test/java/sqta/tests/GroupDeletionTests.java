package sqta.tests;

import javafx.scene.Group;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sqta.model.GroupData;
import sqta.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testGroupDeletionTests() throws Exception {
        //List<GroupData> before = app.group().list();
       // Set<GroupData> before = app.group().all();
        Groups before = app.group().all2();

        GroupData deletedGroup = before.iterator().next();
        //int index = before.size() - 1;
        //app.group().delete(index);
        app.group().delete(deletedGroup);
        //List<GroupData> after = app.group().list();
        //Set<GroupData> after = app.group().all();
        Groups after = app.group().all2();

        Assert.assertEquals(after.size(), before.size() - 1);
        System.out.println("after = " + after.size() + " before = " + before.size());

        //before.remove(deletedGroup);
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withOut(deletedGroup)));

    }
}
