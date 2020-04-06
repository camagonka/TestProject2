package sqta.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    // private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        //System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");
        if (browser == BrowserType.FIREFOX) {
            driver = new FirefoxDriver();
        }
        else if (browser == BrowserType.CHROME) {
            driver = new ChromeDriver();
        }
        else if (browser == BrowserType.IE) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.close();
         /* String verificationErrorString = verificationErrors.toString();
          if (!"".equals(verificationErrorString)) {
              fail(verificationErrorString);
          }*/
    }

    private boolean isAlertPresent() {
          try {
              driver.switchTo().alert();
              return true;
          } catch (NoAlertPresentException e) {
              return false;
          }
      }

    private String closeAlertAndGetItsText() {
          try {
              Alert alert = driver.switchTo().alert();
              String alertText = alert.getText();
              if (acceptNextAlert) {
                  alert.accept();
              } else {
                  alert.dismiss();
              }
              return alertText;
          } finally {
              acceptNextAlert = true;
          }
      }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
