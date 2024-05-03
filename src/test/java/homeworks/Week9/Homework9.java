package homeworks.Week9;

import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import pojos.UserPojo;

/*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

public class Homework9 extends PetStoreBaseTest {

    @Test
    public void createUser() {
        UserPojo newUser = new UserPojo(
                0, "johndoe", "John", "Doe", "john.doe@example.com",
                "password123", "123-456-7890", 1
        );

        // Send a POST request and store the response
        Response response = given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/user")
                .thenReturn();

        // Validate the response status code and print the response body
        response.then()
                .statusCode(200)
                .log().body();

        // Print the entire response
        response.prettyPrint();

        // Verify user creation by fetching user details
        Response getUserResponse = given()
                .pathParam("username", newUser.getUsername())
                .when()
                .get("/user/{username}")
                .thenReturn();



        // Print the response of the GET request
        getUserResponse.prettyPrint();
    }
}
