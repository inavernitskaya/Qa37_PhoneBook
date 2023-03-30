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
        int i = random.nextInt(1000)+1000;
        User user = new User().withEmail("ela" + i + "@gmail.com").withPassword("El12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");
    }

    @Test(description = "Bug  report N23467 Fixed")
    public void registrationWrongEmail() {

        User user = new User().withEmail("dongmail.com").withPassword("Don12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        // Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format\n" +
        //         "            Email must contains one @ and minimum 2 symbols after last dot\n" +
        //          "            Password must contain at least one uppercase letter!\n" +
        //          "            Password must contain at least one lowercase letter!\n" +
        //         "            Password must contain at least one digit!\n" +
        //         "            Password must contain at least one special symbol from [‘$’,’~’,’-‘,’_’]!"));
        Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password format"));

    }

    @Test
    public void registrationWrongPassword()// public void registrationNeValidPasswordExistUser()
     {

        User user = new User().withEmail("don@gmail.com").withPassword("Don12");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        // Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format\n" +
        //         "            Email must contains one @ and minimum 2 symbols after last dot\n" +
        //          "            Password must contain at least one uppercase letter!\n" +
        //          "            Password must contain at least one lowercase letter!\n" +
        //         "            Password must contain at least one digit!\n" +
        //         "            Password must contain at least one special symbol from [‘$’,’~’,’-‘,’_’]!"));
        Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password format"));

    }


    @Test
    public void registrationExistsUser(){

        User user = new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));



    }

    // @Test
    // public void registrationOfRegisteredUserWithDifferentPassword() {
    //   Random random = new Random();
    //   int i = random.nextInt(1000);
    // System.out.println(i);

    // System.out.println(System.currentTimeMillis());
    // int z = (int) (System.currentTimeMillis() / 1000);

    //  User user = new User()
    // .setEmail("inna_83@gmail.com")
    //.setPassword("Ff13579$");

    // app.getHelperUser().openRegistrationForm();
    // app.getHelperUser().fillRegistrationForm(user);
    // app.getHelperUser().submitRegistration();

    // Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    // }

}

