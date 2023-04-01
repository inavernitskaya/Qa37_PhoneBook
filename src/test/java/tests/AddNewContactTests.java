package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static tests.TestBase.app;

public class AddNewContactTests extends TestBase{
   @BeforeClass
   public void preCondition(){
      if(!app.getHelperUser().isLogged()){
          app.getHelperUser().login(new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$"));
      }
       }

    @Test
    public void addNewContactSuccessAll() {
        int i = new Random().nextInt(1000) + 1000;
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("London,Trafalgar sq,5")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isLogged());
    }
        @Test
        public void addNewContactSuccess() {
            int i= new Random().nextInt(1000) + 1000;
            Contact cont = Contact.builder()
                    .name("Kate")
                    .lastName("Ivanov")
                    .phone("78748494947346")
                    .email("katya@mail.com")
                    .address("London,Trafalgar sq,5")
                    .build();
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(cont);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isLogged());
        }
    }

