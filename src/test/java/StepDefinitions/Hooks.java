package StepDefinitions;

import cucumber.api.java.Before;

public class Hooks {

    @Before("@GetPlaceAPI,@DeletePlaceAPI")
    public void beforeScenario() throws Throwable {


        StepDefinition sdn = new StepDefinition();
        if (StepDefinition.place_id == null) {
            sdn.add_Place_API_Payload_with("CCCC", "English", "Lang street USA", "+1-979 786 9876");
            sdn.user_calls_the_with_the_HTTP_Request("AddPlaceAPI", "POST");
            sdn.verify_place_id_created_maps_to_using("CCCC", "GetPlaceAPI");

        }


    }
}
