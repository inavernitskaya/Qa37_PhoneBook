package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        //    WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
        //    // xpath //a[text()='LOGIN']

        //     loginTab.click();
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        // WebElement emailInput = wd.findElement(By.name("email"));
        // emailInput.click();
        // emailInput.clear();
        // emailInput.sendKeys(email);
        type(By.name("email"), email);

        // WebElement passwordInput = wd.findElement(By.xpath("//input[last]"));
        // passwordInput.click();
        // passwordInput.clear();
        // passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"), password);

    }

    public void submitLogin() {

        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        pause(1000);
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
        // return false;
    }

     public void Logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }


///*********************** REGISTRATION ********************************


    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void submitRegistration() {
        pause(1000);
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isAlertPresent2(String message) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        if(alert != null && alert.getText().contains(message)){

            // click ok
            // pause
            alert.accept();
            // click cancel  --->  alert.dismiss();
            // type into alert      -->alert.sendKeys("hello");


            return true;
        }
        return false;
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(5));
        boolean res =wait.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),"No Contacts here!"));
        return res;
    }

    public String getMessage(){

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1"))));

        return wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")).getText();
    }

      public void login(User user) {
            openLoginRegistrationForm();
            fillLoginRegistrationForm(user);;
            submitLogin();
            //closeWindow();

        }

    private void closeWindow() {
         if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
       }
    }

