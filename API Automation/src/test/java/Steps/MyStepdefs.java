package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.net.URLEncoder.encode;

public class MyStepdefs {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static boolean active;
    private static String userId;
    private static String baseURL = "https://63fe35bb571200b7b7c75edc.mockapi.io/awaed/users";
    private static Response response;

    @Given("User is creating new account")
    public void userIsCreatingNewAccount() {
        firstName = "Mai";
        lastName = "Mohsen";
        email = "maai.mohsen.1996@gmail.com";
        active = true;

        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{\"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName
                        + "\", \"email\":\"" + email + "\", \"active\":" + active +"}")
                .post();
    }

    @And("account is created successfully")
    public void accountIsCreatedSuccessfully() {
        Assert.assertEquals(201,response.getStatusCode());
        String responseBody = response.body().asString();
        userId = JsonPath.from(responseBody).get("id");

    }

    @When("User try to get account data")
    public void userTryToGetAccountData()  {
        String userIdEncoded = URLEncoder.encode("{" +userId+ "}", StandardCharsets.UTF_8 );
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.get(userIdEncoded);
    }

    @Then("Data is retrieved with correct values")
    public void dataIsRetrievedWithCorrectValues() {
        Assert.assertEquals(200,response.getStatusCode());
        String responseBody = response.body().asString();
        String responseFirstName = JsonPath.from(responseBody).get("firstName");
        Assert.assertEquals(firstName,responseFirstName);

    }
}
