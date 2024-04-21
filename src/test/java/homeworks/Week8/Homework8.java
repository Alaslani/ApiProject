package homeworks.Week8;

import base_urls.ReqResBaseUrl; // Importing the ReqResBaseUrl class
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

public class Homework8 extends ReqResBaseUrl { // Extending ReqResBaseUrl
@Test
    public static void main(String[] args) {
        // Initialize base settings from the parent class
        new Homework8().setUp();

        // JSON payload as a Map
        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("name", "morpheus");
        jsonData.put("job", "leader");

        // Using 'spec' from ReqResBaseUrl, send the POST request
        Response response = given()
                .spec(spec) // Use the inherited RequestSpecification
                .contentType("application/json")
                .body(jsonData)
                .when()
                .post("/users");

        // Print the response in a readable format
        response.prettyPrint();

        // Then validate the response
        response.then()
                .assertThat()
                .statusCode(201) // Status code should be 201
                .body("name", equalTo("morpheus"),
                        "job", equalTo("leader"))
                .body("id", notNullValue()) // Check that id is not null and ignore the actual value
                .body("createdAt", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z")); // Check createdAt format


    }
}
