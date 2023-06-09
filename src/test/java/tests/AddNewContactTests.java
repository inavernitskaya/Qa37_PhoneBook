package tests;

import manager.DataProviderContact;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static tests.TestBase.app;
//for jenkins
public class AddNewContactTests extends TestBase {
    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$"));
            logger.info("Before method finish logout");
        }
    }

    @Test(dataProvider = "contactSuccess",dataProviderClass = DataProviderContact.class)
    public void  addContactSuccessAllFields(Contact contact) {

        logger.info("Tests run with data: --->" + contact.toString());
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
    }
    @Test(dataProvider = "contactCSV",dataProviderClass = DataProviderContact.class)
    public void  addContactSuccessAllFieldsCSV(Contact contact) {

        logger.info("Tests run with data: --->" + contact.toString());
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
    }

        @Test(groups = {"smoke","regress","retest"})
    public void addNewContactSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Contact cont = Contact.builder()
                .name("Kate" + i)
                .lastName("Ivanov")
                .phone("74849494" + i)
                .email("katya" + i + "@mail.com")
                .address("London,Trafalgar sq,5")
                .build();
        logger.info("Tests run with data:--->" +cont.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        // app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(cont.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(cont.getPhone()));
    }

    @Test(groups = "contact")
    public void addNewContactWrongName() {
        Contact cont = Contact.builder()
                .name("")
                .lastName("Ivanov")
                .phone("787484949345")
                .email("katya@mail.com")
                .address("London,Trafalgar sq,5")
                .description("empty name")
                .build();
        logger.info("Tests run with data:--->" +cont.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        // app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test(groups = "contact")
    public void addNewContactWrongAddress() {
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("")
                .description("empty address")
                .build();
        logger.info("Tests run with data:--->" +cont.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        //  app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test(groups = "contact")
    public void addNewContactWrongLastName() {
        int i = new Random().nextInt(1000) + 1000;
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("")
                .phone("78748494947346")
                .email("katya@mail.com")
                .address("NY")
                .description("empty last name")
                .build();
        logger.info("Tests run with data:--->" +cont.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        // app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

    }

    @Test(dataProvider = "contactWrongPhone",dataProviderClass = DataProviderContact.class)
    public void addNewContactWrongPhone(Contact contact){
//        Contact contact = Contact.builder()
//                .name("Tony")
//                .lastName("Stark")
//                .address("NY")
//                .phone("")
//                .email("stark@gmail.com")
//                .description("empty phone")
//                .build();
        logger.info("Tests run with data: --->"+contact.toString());
        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().saveContact();
        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));


    }

    @Test(groups = "contact")
    public void addNewContactWrongEmail() {
        Contact cont = Contact.builder()
                .name("Kate")
                .lastName("Ivanov")
                .phone("34567654367")
                .email("katyamail.com")
                .address("NY")
                .description("empty email")
                .build();
        logger.info("Tests run with data:--->" +cont.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(cont);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent2("Email not valid: must be a well-formed email address"));
        logger.info("Tests finish with massage:'Email not valid: must be a well-formed email address'");
    }

    //"Contact added" eql "Contact added"
    //
}

