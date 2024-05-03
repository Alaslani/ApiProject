package homeworks.Week10;

import base_urls.ContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static utilities.Authentication4.createContact;

public class GetContactHW16 extends ContactBaseUrl {

    @Test
    public void getContactTest() {
        // Create a new contact
        String contactId = createContact();

        // Set the endpoint with the contactId
        spec.pathParams("first", "contacts", "second", contactId);

        // Send the GET request
        Response response = given(spec)
                .get("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert the response body
        ContactPojo actualData = response.as(ContactPojo.class);
        assertNotNull(actualData.getFirstName());
        assertNotNull(actualData.getLastName());
        assertNotNull(actualData.getBirthdate());
        assertNotNull(actualData.getEmail());
        assertNotNull(actualData.getPhone());
        assertNotNull(actualData.getStreet1());
        assertNotNull(actualData.getStreet2());
        assertNotNull(actualData.getCity());
        assertNotNull(actualData.getStateProvince());
        assertNotNull(actualData.getPostalCode());
        assertNotNull(actualData.getCountry());
    }
}