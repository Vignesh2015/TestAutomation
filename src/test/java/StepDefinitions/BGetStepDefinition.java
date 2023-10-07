package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils;

import static StepDefinitions.StepDefinition.place_id;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class BGetStepDefinition extends Utils {

    private static RequestSpecification res;
    private static Response response;


    @Given("^Get Place API Payload$")
    public void get_Place_API_Payload() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification()).queryParam("place_id",place_id);
    }

    @When("^User calls the \"([^\"]*)\" with a \"([^\"]*)\" HTTP Request$")
    public void user_calls_the_with_a_HTTP_Request(String resource, String method) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        APIResources resourceAPi = APIResources.valueOf(resource);
        System.out.println(resourceAPi.getResource());

        if(method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourceAPi.getResource());
        }else if(method.equalsIgnoreCase("GET")){
            response = res.when().get(resourceAPi.getResource());
        }else{
            response = res.when().delete(resourceAPi.getResource());
        }
    }

    @Then("^the API call got success with a Status code (\\d+)$")
    public void the_API_call_got_success_with_a_Status_code(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }

    @Then("^\"([^\"]*)\" in a Response body is \"([^\"]*)\"$")
    public void in_a_Response_body_is(String keyValue, String Expectedvalue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(getJsonValue(response,keyValue),Expectedvalue);
    }

}
