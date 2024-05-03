package homeworks.Week10;

import base_urls.CURDbaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.CURDpojo;
import utilities.ObjectMapperUtilsCURD;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.Authentication3.generateToken;

public class ReadUserHW15 extends CURDbaseurl {

    @Test
    public void readUserTest() {
        // Set the endpoint
        spec.pathParams("first", "users", "second", "me");

        // Send the GET request
        Response response = given(spec)
                .header("Authorization", "Bearer " + generateToken())
                .get("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert the response body
        CURDpojo actualData = ObjectMapperUtilsCURD.convertJsonToJava(response.asString(), CURDpojo.class);
        assertEquals(actualData.getFirstName(), "Ahmed");
        assertEquals(actualData.getLastName(), "me");
        assertEquals(actualData.getEmail(), "teste@Ahmed.com");
    }
}