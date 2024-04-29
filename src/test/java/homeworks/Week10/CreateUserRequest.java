package homeworks.Week10;

import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.UserPojo;

import static io.restassured.RestAssured.given;

public class CreateUserRequest extends PetStoreBaseTest {

    @Test
    public void createUserTest() {
        UserPojo newUser = new UserPojo(
                123,
                "testUser",
                "Test",
                "User",
                "testuser@example.com",
                "password123",
                "1234567890",
                1
        );

        System.out.println("Creating a new user...");
        Response response = given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();
        System.out.println("User created successfully.");
    }
}
