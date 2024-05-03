package homeworks.Week10;

import base_urls.ContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.Authentication4.createContact;

public class UpdateContactHW16 extends ContactBaseUrl {

    @Test
    public void updateContactTest() {
        // Create a new contact
        String contactId = createContact();

        // Set the endpoint with the contactId
        spec.pathParams("first", "contacts", "second", contactId);

        // Create the request body
        ContactPojo requestBody = new ContactPojo();
        requestBody.setFirstName("Amy");
        requestBody.setLastName("Miller");
        requestBody.setBirthdate("1992-02-02");
        requestBody.setEmail("amiller@fake.com");
        requestBody.setPhone("8005554242");
        requestBody.setStreet1("13 School St.");
        requestBody.setStreet2("Apt. 5");
        requestBody.setCity("Washington");
        requestBody.setStateProvince("QC");
        requestBody.setPostalCode("A1A1A1");
        requestBody.setCountry("Canada");

        // Send the PUT request
        Response response = given(spec)
                .body(requestBody)
                .put("{first}/{second}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 200);

        // Assert the response body
        ContactPojo actualData = response.as(ContactPojo.class);
        assertEquals(actualData.getFirstName(), requestBody.getFirstName());
        assertEquals(actualData.getLastName(), requestBody.getLastName());
        assertEquals(actualData.getBirthdate(), requestBody.getBirthdate());
        assertEquals(actualData.getEmail(), requestBody.getEmail());
        assertEquals(actualData.getPhone(), requestBody.getPhone());
        assertEquals(actualData.getStreet1(), requestBody.getStreet1());
        assertEquals(actualData.getStreet2(), requestBody.getStreet2());
        assertEquals(actualData.getCity(), requestBody.getCity());
        assertEquals(actualData.getStateProvince(), requestBody.getStateProvince());
        assertEquals(actualData.getPostalCode(), requestBody.getPostalCode());
        assertEquals(actualData.getCountry(), requestBody.getCountry());
    }
}