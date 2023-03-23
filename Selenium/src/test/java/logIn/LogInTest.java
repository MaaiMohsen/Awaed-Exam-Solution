package logIn;

import base.BaseTests;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class LogInTest extends BaseTests {
    Faker faker = new Faker();
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    String email = fakeValuesService.bothify("????##@gmail.com");

    @Test
    public void testFailedLogIn (){
        logInPage.setEmail(email);
        logInPage.setPassword(faker.address().firstName());
        logInPage.clickLogIn();
        assertEquals(logInPage.getErrorMessage(),"Userid or Password did Not Match !!",
                "Error message is not correct");


    }
}
