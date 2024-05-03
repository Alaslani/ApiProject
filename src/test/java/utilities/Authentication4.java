package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication4 {
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

    public static String createContact() {
        String url = "https://thinking-tester-contact-list.herokuapp.com/contacts";

        String requestBody = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }
                """;

        Response response = given()
                .header("Authorization", "Bearer " + generateToken())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        return response.jsonPath().getString("_id");
    }
}