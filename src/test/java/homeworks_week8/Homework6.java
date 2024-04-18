package homeworks_week8;

import base_urls.ReqResBaseUrl; // Importing the ReqResBaseUrl class
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
/*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
public class Homework6 extends ReqResBaseUrl { // Extending ReqResBaseUrl

    public static void main(String[] args) {
        // Initialize base settings from the parent class
        new Homework6().setUp();

        // Using 'spec' from ReqResBaseUrl
        Response response = given()
                .spec(spec) // Use the inherited RequestSpecification
                .when()
                .get("/unknown/3");

        // Print the response in a readable format
        response.prettyPrint();

        // Then validate the response
        response.then()
                .assertThat()
                .statusCode(200) // HTTP Status Code should be 200
                .contentType("application/json; charset=utf-8") // Response content type
                .body("data.id", equalTo(3),
                        "data.name", equalTo("true red"),
                        "data.year", equalTo(2002),
                        "data.color", equalTo("#BF1932"),
                        "data.pantone_value", equalTo("19-1664"),
                        "support.url", equalTo("https://reqres.in/#support-heading"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}
