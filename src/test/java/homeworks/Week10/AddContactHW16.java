package homeworks.Week10;

import base_urls.ContactBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AddContactHW16 extends ContactBaseUrl {

    @Test
    public void addContactTest() {
        // Set the endpoint
        spec.pathParam("first", "contacts");

        // Create the request body
        ContactPojo requestBody = new ContactPojo();
        requestBody.setFirstName("John");
        requestBody.setLastName("Doe");
        requestBody.setBirthdate("1970-01-01");
        requestBody.setEmail("jdoe@fake.com");
        requestBody.setPhone("8005555555");
        requestBody.setStreet1("1 Main St.");
        requestBody.setStreet2("Apartment A");
        requestBody.setCity("Anytown");
        requestBody.setStateProvince("KS");
        requestBody.setPostalCode("12345");
        requestBody.setCountry("USA");

        // Send the POST request
        Response response = given(spec)
                .body(requestBody)
                .post("{first}");

        // Print the response
        response.prettyPrint();

        // Assert the status code
        assertEquals(response.statusCode(), 201);

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