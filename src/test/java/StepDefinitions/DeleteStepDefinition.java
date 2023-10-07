package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static StepDefinitions.StepDefinition.place_id;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class DeleteStepDefinition extends Utils {

    private static RequestSpecification res;

    private static Response response;

    TestDataBuild data = new TestDataBuild();



    @Given("^Delete Place API Payloads$")
    public void delete_Place_API_Payloads() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }

    @When("^User calls \"([^\"]*)\" with the \"([^\"]*)\" HTTP Request$")
    public void user_calls_with_the_HTTP_Request(String resource, String method) throws Throwable {
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

    @Then("^the API call got success with the Status code (\\d+)$")
    public void the_API_call_got_success_with_the_Status_code(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }

    @Then("^\"([^\"]*)\" in the Response body is \"([^\"]*)\"$")
    public void in_the_Response_body_is(String keyValue, String Expectedvalue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(getJsonValue(response,keyValue),Expectedvalue);
    }
}
