package sqta.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sqta.model.GroupData;
import sqta.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupCreation(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        type(By.name("group_name"), groupData.getName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        type(By.name("group_header"), groupData.getHeader());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        driver.findElement(By.name("edit")).click();
    }

    public void submitGroupModification() {
        driver.findElement(By.name("update")).click();
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupCreation(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupCreation(group);
        submitGroupModification();
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupCreation(group);
        submitGroupModification();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    public Groups all2() {
        Groups groups = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}
