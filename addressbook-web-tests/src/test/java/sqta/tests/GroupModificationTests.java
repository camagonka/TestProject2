package sqta.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sqta.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().selectGroup(index);
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("test4").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);

        //Сортировка списка с помощью компоратора
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
