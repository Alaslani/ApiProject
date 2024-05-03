// Authentication3.java
package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication3 {

    public static String generateToken() {
        String url = "https://thinking-tester-contact-list.herokuapp.com/users";

        String requestBody = """
                {
                    "firstName": "Test",
                    "lastName": "User",
                    "email": "test@fake.com",
                    "password": "myPassword"
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        return response.jsonPath().getString("token");
    }
}