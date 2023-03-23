package logIn;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTests {
    @Test
    public void testFailedLogIn (){
        logInPage.setEmail("email");
        logInPage.setPassword("password");
        logInPage.clickLogIn();
        assertEquals(logInPage.getErrorMessage(),"Userid or Password did Not Match !!",
                "Error message is not correct");


    }
}
