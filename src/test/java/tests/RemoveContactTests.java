package tests;

import models.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$"));
            logger.info("Before method finish logout");

        }
        app.helperContact().provideContacts();

    }


    @Test
    public void removeFirstContact(){
        Assert.assertEquals(app.helperContact().removeOneContact(),1);

    }
    @Test
    public void removeAllContacts(){
        app.helperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");

    }
}
