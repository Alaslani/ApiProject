package homeworks.Week10;

import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReadUserRequest extends PetStoreBaseTest {

    @Test
    public void readUserTest() {
        String username = "testUser"; // Username of the user to read

        System.out.println("Reading user: " + username);
        Response response = given()
                .pathParam("username", username)
                .when()
                .get("/user/{username}")
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();
        System.out.println("User read successfully.");
    }
}