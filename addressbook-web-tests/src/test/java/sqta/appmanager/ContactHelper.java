package sqta.appmanager;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sqta.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }

    public void initContactModification() {
        driver.findElement(By.cssSelector("img[alt='Edit']")).click();
    }

    public void submitContactModification() {
        driver.findElement(By.xpath("//input[@value='Update']")).click();
    }


    public void createContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void initContactDeletion(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitContactDeletion() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();

        //нажатие ОК
        Alert alert = driver.switchTo().alert();
        ((Alert) alert).accept();

        //нажатие Cancel
       /* Alert alert = driver.switchTo().alert();
        ((Alert) alert).dismiss();        */
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
       // List<WebElement> elements = driver.findElements(By.xpath("//*/tr[@name='entry']"));
       /* for (int i = 2; i < elements.size() + 2; i++) {
            String firstname = driver.findElement(By.xpath("//tr[" + i + "]/td[3]")).getText();
            String lastname = driver.findElement(By.xpath("//tr[" + i + "]/td[2]")).getText();
            int id = Integer.parseInt(driver.findElement(By.xpath("//input[@type='checkbox']")).getAttribute("id"));
            ContactData contact = new ContactData(firstname, lastname, null);
            contacts.add(contact);
        }*/

        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            contacts.add(new ContactData(id, firstname, null, lastname));
        }
        return contacts;
    }

    public void goToContactsBack(){
        driver.findElement((By.linkText("home"))).click();
    }
}

