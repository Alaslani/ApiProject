package base_urls;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class PetStoreBaseTest {
    protected static RequestSpecification spec;

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
