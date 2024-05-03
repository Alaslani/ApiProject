package homeworks.Week10;

import base_urls.CURDbaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.Authentication3.generateToken;

public class DeleteUserHW15 extends CURDbaseurl {

    @Test
    public void deleteUserTest() {
        // Set the endpoint
        spec.pathParams("first", "users", "second", "me");

        // Send the DELETE request
        Response response = given(spec)
                .header("Authorization", "Bearer " + generateToken())
                .delete("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert that the response body is empty
        assertEquals(response.getBody().asString(), "");
    }
}