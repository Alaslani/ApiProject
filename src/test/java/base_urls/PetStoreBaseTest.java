package base_urls;

import io.restassured.RestAssured;
import org.junit.Before;

public class PetStoreBaseTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}