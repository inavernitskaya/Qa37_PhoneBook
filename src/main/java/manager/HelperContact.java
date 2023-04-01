package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        pause(500);
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact cont) {
        type(By.cssSelector("input[placeholder='Name']"), cont.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), cont.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"), cont.getPhone());
        type(By.xpath("//input[@placeholder='email']"), cont.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), cont.getAddress());
        type(By.xpath("//input[@placeholder='description']"), cont.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//b[normalize-space()='Save']"));
    }

}


    //  public void fillCarForm(Car car) {
    //     typeLocation(car.getLocation());
    //    type(By.id("make"), car.getManufacture());
    //     type(By.cssSelector("#model"), car.getModel());
    //     type(By.xpath("//input[@id='year']"), car.getYear());
    //     select(By.id("fuel"),car.getFuel());
    //    type(By.id("seats"),String.valueOf(car.getSeats()));
    //    type(By.id("class"), car.getCarClass());
    //   type(By.id("serialNumber"),car.getCarRegNumber());
    // type(By.id("price"),String.valueOf(car.getPrice()));
    //     type(By.id("price"),car.getPrice()+"");
    //    type(By.id("about"),car.getAbout());

