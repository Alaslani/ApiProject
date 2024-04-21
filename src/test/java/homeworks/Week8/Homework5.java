package homeworks.Week8;

import base_urls.ReqResBaseUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Homework5 extends ReqResBaseUrl {

    public static void main(String[] args) {
        // Initialize base settings from the parent class
        new Homework5().setUp();

        // Using 'spec' from ReqResBaseUrl
        Response response = given()
                .spec(spec)
                .when()
                .get("/users/23");

        // Print the response in a readable format
        response.prettyPrint();

        // Then validate the response
        response.then()
                .assertThat()
                .statusCode(404) // HTTP Status Code should be 404
                .statusLine("HTTP/1.1 404 Not Found") // Status Line should be "HTTP/1.1 404 Not Found"
                .header("Server", "cloudflare") // Server should be "cloudflare"
                .body(equalTo("{}")); // Response body should be an empty JSON object



    }
}