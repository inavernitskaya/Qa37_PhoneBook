package tests;

import models.User;
import org.testng.annotations.BeforeClass;

public class RemoveContactTest extends TestBase {
    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$"));
        }
        app.getHelperContact().provideContacts(); ///if list<3 =====> add 3 contacts
    }

    public void removeFirstContact(){
        //Assert size list less when one

    }

    public void removeAllContact(){
        // "No contacts Here"

    }
}
