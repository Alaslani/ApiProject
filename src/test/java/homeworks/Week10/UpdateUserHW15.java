package homeworks.Week10;

import base_urls.CURDbaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.CURDpojo;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.Authentication3.generateToken;
import static utilities.ObjectMapperUtilsCURD.convertJsonToJava;

public class UpdateUserHW15 extends CURDbaseurl {


    @Test
    public void updateUserTest() {
        // Set the endpoint
        spec.pathParams("first", "users", "second", "me");

        // Set the expected data
        String strJson = """
                {
                    "firstName": "Updated",
                    "lastName": "Username",
                    "email": "test2@fake.com",
                    "password": "myNewPassword"
                }
                """;

        CURDpojo expectedData = convertJsonToJava(strJson, CURDpojo.class);
        System.out.println("expectedData = " + expectedData);

        // Send the PUT request
        Response response = given(spec)
                .header("Authorization", "Bearer " + generateToken())
                .body(expectedData)
                .put("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert the response body
        CURDpojo actualData = convertJsonToJava(response.asString(), CURDpojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getEmail(), expectedData.getEmail());
    }
}