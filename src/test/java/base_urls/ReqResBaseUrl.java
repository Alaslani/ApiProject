package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class ReqResBaseUrl {

    protected static RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .build();
    }
}