package sqta.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sqta.model.GroupData;
import sqta.model.Groups;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testGroupModificationTests() {
       // List<GroupData> before = app.group().list();
        //Set<GroupData> before = app.group().all();
        Groups before = app.group().all2();

       // int index = before.size() - 1;
        GroupData modifyGroup = before.iterator().next();
       // app.group().selectGroup(index);
       // GroupData group = new GroupData()
        //      .withId(before.get(index).getId()).withName("test4").withHeader("test2").withFooter("test3");

        GroupData group = new GroupData()
              .withId(modifyGroup.getId()).withName("test4").withHeader("test2").withFooter("test3");
        app.group().modify(group);

        //List<GroupData> after = app.group().list();
        //Set<GroupData> after = app.group().all();
        Groups after = app.group().all2();

        assertEquals(after.size(), before.size());

        //before.remove(modifyGroup);
       // before.add(group);

        //Сортировка списка с помощью компоратора
       /* Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);*/
        assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        assertThat(after, equalTo(before.withOut(modifyGroup).withAdded(group)));

    }
}
