package sqta.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import sqta.model.GroupData;
import sqta.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();

        // List<GroupData> before = app.group().list();
        //Set<GroupData> before = app.group().all();
        Groups before = app.group().all2();

        GroupData group = new GroupData().withName("test7");
        app.group().create(group);

        // List<GroupData> after = app.group().list();
        //Set<GroupData> after = app.group().all();
        Groups after = app.group().all2();

        Assert.assertEquals(after.size(), before.size() + 1);
        //спользование компоратора для выявления максимального id
        // group.withId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

        //before.add(group);

        //Сортировка списка(List) с помощью компоратора
       /* Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);*/

      //Assert.assertEquals(before, after);
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
