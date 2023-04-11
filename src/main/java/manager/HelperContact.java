package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        // pause(500);
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact cont) {
        type(By.cssSelector("input[placeholder='Name']"), cont.getName());
        type(By.cssSelector(" input[placeholder='Last Name']"), cont.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"), cont.getPhone());
        type(By.xpath("//input[@placeholder='email']"), cont.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), cont.getAddress());
        type(By.xpath("//input[@placeholder='description']"), cont.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//b[normalize-space()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));

        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }


    public void removeFirstContact() {
        click(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)"));
        click(By.xpath("//button[normalize-space()='Remove']"));
    }

    public boolean isListOfContactBecomeShort() {
        return isElementPresent(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > h3:nth-child(2)"));
    }

    public void removeAllContacts() {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            

        }
    }
}




