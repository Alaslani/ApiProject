package homeworks.Week10;
import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserRequestHW13 extends PetStoreBaseTest {

    @Test
    public void deleteUserTest() {
        String username = "testUser"; // Username of the user to delete

        System.out.println("Deleting user: " + username);
        Response response = given()
                .pathParam("username", username)
                .when()
                .delete("/user/{username}")
                .then()
                .statusCode(200)
                .extract().response();

        response.prettyPrint();
        System.out.println("User deleted successfully.");
    }
}