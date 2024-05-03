package homeworks.Week9;


import base_urls.PetStoreBaseTest;
import pojos.PetPojo;
import static io.restassured.RestAssured.given;
import org.junit.Test;
import pojos.PetPojo1;

/*/
//Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
(All actions must be done on same pet)
(Use Pojo)
 */
public class Homework12 extends PetStoreBaseTest {

    @Test
    public void testPetLifecycle() {

        // Create a new Pet
        PetPojo1 myPet = new PetPojo1(99123, "Fido", "available");
        given()
                .contentType("application/json")
                .body(myPet)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);

        // Read the created Pet
        given()
                .pathParam("petId", myPet.getId())
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .log().body();

        // Update the Pet
        myPet.setName("FidoUpdated");
        myPet.setStatus("pending");
        given()
                .contentType("application/json")
                .body(myPet)
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .log().body();

        // Delete the Pet
        given()
                .pathParam("petId", myPet.getId())
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200);
    }
}