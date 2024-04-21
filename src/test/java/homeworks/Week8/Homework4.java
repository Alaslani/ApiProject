package homeworks.Week8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
/*
      Given
          https://reqres.in/api/users/2
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "email" is "janet.weaver@reqres.in",
      And
          "first_name" is "Janet"
      And
          "last_name" is "Weaver"
      And
          "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
   */
public class Homework4 {
    @Test
    public static void main(String[] args) {

        // Setup base URL from the inherited class
        RestAssured.baseURI = "https://reqres.in/api";

        // Given
        Response response = given()
                .when()
                .get("/users/2");

        // Print the entire response for debugging
        response.prettyPrint();

        // Then
        response.then()
                .assertThat()
                .statusCode(200) // Check that the status code is 200
                .contentType("application/json") // Check that the content type is JSON
                .body("data.email", equalTo("janet.weaver@reqres.in"), // Check email
                        "data.first_name", equalTo("Janet"), // Check first name
                        "data.last_name", equalTo("Weaver"), // Check last name
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")); // Check support text
    }
}
