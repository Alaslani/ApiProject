package homeworks.Week8;

import base_urls.ReqResBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
/*
      Given
             https://reqres.in/api/unknown/
      When
           I send GET Request to the URL
      Then

           1)Status code is 200
           2)Print all pantone_values
           3)Print all ids greater than 3 on the console
             Assert that there are 3 ids greater than 3
           4)Print all names whose ids are less than 3 on the console
             Assert that the number of names whose ids are less than 3 is 2
   */
public class Homework7 extends ReqResBaseUrl {

    @Test
    public void testUnknownResource() {
        // Given
        Response response = given()
                .spec(spec)
                .when()
                .get("/unknown/")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data.pantone_value", everyItem(isA(String.class)))
                .body("data.findAll { it.id > 3 }.id", hasSize(3))
                .body("data.findAll { it.id < 3 }.name", hasSize(2))
                .extract()
                .response();

        // Print debugging information
        printResponseData(response);
    }

    private void printResponseData(Response response) {
        List<String> pantoneValues = response.path("data.pantone_value");
        List<Integer> idsGreaterThan3 = response.path("data.findAll { it.id > 3 }.id");
        List<String> namesLessThan3 = response.path("data.findAll { it.id < 3 }.name");

        System.out.println("All Pantone Values:");
        pantoneValues.forEach(System.out::println);

        System.out.println("IDs greater than 3:");
        idsGreaterThan3.forEach(System.out::println);

        System.out.println("Names with IDs less than 3:");
        namesLessThan3.forEach(System.out::println);
    }
}
