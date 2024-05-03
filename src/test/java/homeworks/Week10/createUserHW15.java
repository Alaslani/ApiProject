package homeworks.Week10;
import base_urls.CURDbaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.CURDpojo;
import utilities.ObjectMapperUtilsCURD;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class createUserHW15 extends CURDbaseurl {

    @Test
    public void createUserTest() {
        // Set the endpoint
        spec.pathParam("first", "users");

        // Set the request body
        CURDpojo requestBody = new CURDpojo();
        requestBody.setFirstName("Ahmed");
        requestBody.setLastName("me");
        requestBody.setEmail("test@Ahmed.com");
        requestBody.setPassword("myPassword");

        // Send the POST request
        Response response = given(spec)
                .body(ObjectMapperUtilsCURD.convertJavaToJson(requestBody))
                .post("{first}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 201);

        // Assert the response body
        CURDpojo actualData = ObjectMapperUtilsCURD.convertJsonToJava(response.asString(), CURDpojo.class);
        assertEquals(actualData.getFirstName(), requestBody.getFirstName());
        assertEquals(actualData.getLastName(), requestBody.getLastName());
        assertEquals(actualData.getEmail(), requestBody.getEmail());
    }
}