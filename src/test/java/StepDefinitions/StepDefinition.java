package StepDefinitions;
import io.restassured.RestAssured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.runner.RunWith;
import cucumber.api.java.en.Then;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils {
     private static RequestSpecification res;
    private static Response response;
    TestDataBuild data = new TestDataBuild();
    public static String place_id;


    @Given("^Add Place API Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_Place_API_Payload_with(String name, String language, String Address, String Phonenumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

         /******ResponseSpecBuilder******/
         //respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

          res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name, language, Address, Phonenumber));
    }

    @Given("^Add Place API Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_Place_API_Payload_with(String name, String language, String Address) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        res = given().spec(requestSpecification())
                .body(data.addPlacePayload(name, language, Address));
    }

    @When("^User calls the \"([^\"]*)\" with the \"([^\"]*)\" HTTP Request$")
    public void user_calls_the_with_the_HTTP_Request(String resource, String method) throws Throwable  {
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


          /*response = res.log().all().when().post(resourceAPi.getResource()).
                then().assertThat().spec(responseSpecification()).extract().response();*/

    }

    @Then("^the API call got success with Status code (\\d+)$")
    public void the_API_call_got_success_with_Status_code(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(response.getStatusCode(),200);
    }

    @Then("^\"([^\"]*)\" in Response body is \"([^\"]*)\"$")
    public void in_Response_body_is(String keyValue, String Expectedvalue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

             assertEquals(getJsonValue(response,keyValue),Expectedvalue);


    }

    @Then("^verify place_id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        place_id = getJsonValue(response,"place_id");
        System.out.println(place_id);
        res = given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_the_with_the_HTTP_Request(resource,"GET");
        String actualName = getJsonValue(response,"name");
        Assert.assertEquals(actualName,expectedName);

    }




}
