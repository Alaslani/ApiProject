package homeworks.Week9;
import base_urls.PetStoreBaseTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

//Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets" with the status "available" and asserts that there are more than 100.

public class Homework10 extends PetStoreBaseTest {

    @Test
    public void testNumberOfAvailablePets() {
        // Fetch pets by status 'available' using inherited base URI from PetStoreBaseTest
        Response response = given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200) // Validate the response status code is 200
                .extract()
                .response();

        // Assert there are more than 100 pets available
        response.then().body("size()", greaterThan(100));


        // Get the number of available pets
        int numberOfPets = response.jsonPath().getList("$").size();

        // Assert the number of available pets is more than 100
        Assert.assertTrue("Number of available pets should be more than 100", numberOfPets > 100);

        // Print the number of available pets for debugging
        System.out.println("Number of available pets: " + numberOfPets);
    }
    }

