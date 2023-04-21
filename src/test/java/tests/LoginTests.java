package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if Sign Out present----> LogOut
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().Logout();
            logger.info("Before method finish logout");
        }
    }


    @Test(dataProvider="loginData",dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {

        logger.info("Start test with name 'LoginSuccess'");
       // logger.info("Test data---> email: 'inna_83@gmail.com' & password: 'Aa13579$'");
        logger.info("Test data---> email: "+email+" & password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        // time ---> signOut
        //Assert is SignOut present
        //Assert.assertEquals(,);
        //Assert.assertNotEquals();
        //Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data---> "+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
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