package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().Logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000);

        User user = new User()
                .setEmail("ela" + i + "@gmail.com")
                .setPassword("El12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationWrongEmail() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000);

        User user = new User()
                .setEmail("mika"+i+"gmail.com")
                .setPassword("Mk23457$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isAlertPresent1(""));
    }

    @Test
    public void registrationWrongPassword() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000);

        User user = new User()
                .setEmail("mika"+i+"@gmail.com")
                .setPassword("Mk236");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isAlertPresent1(""));
    }

    @Test
    public void registrationOfRegisteredUser() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000);

        User user = new User()
                .setEmail("inna_83@gmail.com")
                .setPassword("Aa13579$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

    @Test
    public void registrationOfRegisteredUserWithDifferentPassword() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000);

        User user = new User()
                .setEmail("inna_83@gmail.com")
                .setPassword("Ff13579$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }


}
