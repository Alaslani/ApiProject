package base_urls;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class automatioBaseUrl {
    protected static RequestSpecification spec;

    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "https://automationexercise.com/api";

    }
}

