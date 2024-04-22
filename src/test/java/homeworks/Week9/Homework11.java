package homeworks.Week9;

import base_urls.automatioBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Homework11 extends automatioBaseUrl {

    @Test
    public void testNumberOfWomenProducts() {


        Response response = given()
                .log().all()
                .when()
                .get("/productsList")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();

        // JSONPath to navigate through the nested structure
        int countOfWomenProducts = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();
        System.out.println("Number of products for 'Women': " + countOfWomenProducts);
        assert countOfWomenProducts == 12 : "Expected 12 Women products, but found " + countOfWomenProducts;
    }
}
