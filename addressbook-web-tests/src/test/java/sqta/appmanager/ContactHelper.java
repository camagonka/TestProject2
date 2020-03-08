package sqta.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sqta.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
            type(By.name("firstname"), contactData.getFirstname());
            type(By.name("lastname"), contactData.getLastname());
        if(creation){
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
}
