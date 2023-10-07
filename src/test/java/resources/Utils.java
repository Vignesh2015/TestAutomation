package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    public static RequestSpecification reqSpec;
    public RequestSpecification requestSpecification() throws IOException {

        //RestAssured.baseURI = "https://rahulshettyacademy.com";

        if (reqSpec == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            /*****RequestSpecBuilder*****/
             reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("BASE_URL")).
                    addQueryParam("key", "qaclick123").
                    addFilter(RequestLoggingFilter.logRequestTo(log)).
                    addFilter(ResponseLoggingFilter.logResponseTo(log)).
                    setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }

    public ResponseSpecification responseSpecification(){
        ResponseSpecification respSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).
                expectStatusCode(200).build();
        return respSpec;
    }

    public static String getGlobalValue(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Vignesh\\IdeaProjects\\RestAPIFramework\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        System.out.println(prop.getProperty(key));
        return prop.getProperty(key);


    }

    public static String getJsonValue(Response response, String key){
        String bodyresp = response.asString();
        JsonPath js = new JsonPath(bodyresp);
        return js.get(key).toString();
    }
}
