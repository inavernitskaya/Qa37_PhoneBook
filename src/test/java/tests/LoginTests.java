package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if Sign Out present----> LogOut
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().Logout();
            logger.info("Before method finish logout");
        }
    }


    @Test
    public void loginSuccess() {

        logger.info("Start test with name 'LoginSuccess'");
        logger.info("Test data---> email: 'inna_83@gmail.com' & password: 'Aa13579$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("inna_83@gmail.com", "Aa13579$");
        app.getHelperUser().submitLogin();
        // time ---> signOut

        //Assert is SignOut present
        //Assert.assertEquals(,);
        //Assert.assertNotEquals();
        //Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }


    @Test
    public void loginSuccessModel() {
        logger.info("Test data---> email: 'inna_83@gmail.com' & password: 'Aa13579$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("inna_83@gmail.com", "Aa13579$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data---> email: 'inna_83gmail.com' & password: 'Aa13579$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("inna_83gmail.com", "Aa13579$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text  button 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data---> email: 'inna_83@gmail.com' & password: 'Aa13'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("inna_83@gmail.com", "Aa13");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text  button 'Wrong email or password'");
    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data---> email: 'pinokio@gmail.com' & password: 'Aa13975425$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pinokio@gmail.com", "Aa13975425$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text  button 'Wrong email or password'");

    }
}