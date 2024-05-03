package homeworks.Week10;

import base_urls.ContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.Authentication4.createContact;

public class DeleteContactHW16 extends ContactBaseUrl {

    @Test
    public void deleteContactTest() {
        // Create a new contact
        String contactId = createContact();

        // Set the endpoint with the contactId
        spec.pathParams("first", "contacts", "second", contactId);

        // Send the DELETE request
        Response response = given(spec)
                .delete("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert the response body
        assertEquals(response.getBody().asString(), "");
    }
}