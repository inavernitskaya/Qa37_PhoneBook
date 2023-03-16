package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if Sign Out present----> LogOut
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().Logout();
        }
    }


    @Test
    public void loginSuccess(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("inna_83@gmail.com","Aa13579$");
       app.getHelperUser().submitLogin();
       // time ---> signOut

        //Assert is SignOut present
        //Assert.assertEquals(,);
        //Assert.assertNotEquals();
        //Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("inna_83@gmail.com","Aa13579$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }
}
