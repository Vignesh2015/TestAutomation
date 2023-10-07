package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name,String language,String Address, String Phonenumber ){

        AddPlace addnewPlaces = new AddPlace();
        addnewPlaces.setAccuracy(60);
        addnewPlaces.setName(name);
        addnewPlaces.setPhone_number(Phonenumber);
        addnewPlaces.setAddress(Address);
        addnewPlaces.setWebsite("http://google.com");
        addnewPlaces.setLanguage(language);

        Location ls = new Location();
        ls.setLat(-38.383495);
        ls.setLng(33.427366);
        addnewPlaces.setLocation(ls);

        List<String> addTypes = new ArrayList<String>();
        addTypes.add("shoe park1");
        addTypes.add("shop1");
        addnewPlaces.setTypes(addTypes);
        return addnewPlaces;
    }

    public AddPlace addPlacePayload(String name,String language,String Address ){

        AddPlace addnewPlaces = new AddPlace();
        addnewPlaces.setAccuracy(60);
        addnewPlaces.setName(name);
        addnewPlaces.setPhone_number("+1 989 656 8787");
        addnewPlaces.setAddress(Address);
        addnewPlaces.setWebsite("http://google.com");
        addnewPlaces.setLanguage(language);

        Location ls = new Location();
        ls.setLat(-38.383495);
        ls.setLng(33.427366);
        addnewPlaces.setLocation(ls);

        List<String> addTypes = new ArrayList<String>();
        addTypes.add("shoe park1");
        addTypes.add("shop1");
        addnewPlaces.setTypes(addTypes);
        return addnewPlaces;
    }

    public String deletePlacePayload(String placeID){

        return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
    }
}
