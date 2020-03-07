package sqta.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sqta.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactCreation(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home page")).click();
    }
}
