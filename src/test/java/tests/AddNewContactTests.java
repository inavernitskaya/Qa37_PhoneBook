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
                .name("Kate"+i)
                .lastName("Ivanov")
                .phone("78748494947346"+i)
                .email("katya"+i+"@mail.com")
                .address("London,Trafalgar sq,5")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(cont.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(cont.getPhone()));
    }
        @Test
        public void addNewContactSuccess() {
            int i= new Random().nextInt(1000) + 1000;
            Contact cont = Contact.builder()
                    .name("Kate"+i)
                    .lastName("Ivanov")
                    .phone("78748494947346"+i)
                    .email("katya"+i+"@mail.com")
                    .address("London,Trafalgar sq,5")
                    .build();
            app.getHelperContact().openContactForm();
            app.getHelperContact().fillContactForm(cont);
            app.getHelperContact().saveContact();
            Assert.assertTrue(app.getHelperContact().isContactAddedByName(cont.getName()));
            Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(cont.getPhone()));
        }

    @Test
    public void addNewContactWrongName(){
        Contact cont = Contact.builder()
                .name("")
                .lastName("Ivanov")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("London,Trafalgar sq,5")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void  addNewContactWrongAddress(){
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("NY")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }
    @Test
    public void addNewContactWrongPhone(){
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("")
                .email("katya@mail.com")
                .address("NY")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid : Phone number must contain only digits! And lenght min 10 max 15"));

    }
    @Test
    public void addNewContactWrongEmail(){
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("34567654367")
                .email("katyamail.com")
                .address("NY")
                .description("student")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));
    }

    //"Contact added" eql "Contact added"
    //
    }

