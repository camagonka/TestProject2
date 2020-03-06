package sqta.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public void gotoGroupPage() {
       /* if(isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Group")
                && isElementPresent(By.name("new"))) {
         return;
        }*/
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomePage(){
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        driver.findElement(By.linkText("home")).click();
    }

}
