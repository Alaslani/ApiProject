package homeworks.Week10;
import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.UserPojo;

import static io.restassured.RestAssured.given;

public class UpdateUserRequest extends PetStoreBaseTest {

    @Test
    public void updateUserTest() {
        String username = "testUser"; // Username of the user to update
        UserPojo updatedUser = new UserPojo(
                null,
                username,
                "Updated",
                "User",
                "updateduser@example.com",
                "updatedpassword123",
                "1234567890",
                1
        );

        System.out.println("Updating user: " + username);
        Response response = given()
                .contentType("application/json")
                .pathParam("username", username) // Set the username path parameter
                .body(updatedUser)
                .when()
                .put("/user/{username}") // Use the path parameter in the URL
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();
        System.out.println("User updated successfully.");
    }
}