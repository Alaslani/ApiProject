package homeworks_week8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework3 {
    @Test
    public void testUserDetails() {

        // Setup base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Given
        Response response = given()
                .when()
                .get("/users/3");

        // Print the entire response for debugging
        response.prettyPrint();

        // Then
        response.then()
                .assertThat()
                .statusCode(200) // Check that the status code is 200
                .contentType("application/json") // Check that the content type is JSON
                .statusLine("HTTP/1.1 200 OK"); // Check the status line
    }
}