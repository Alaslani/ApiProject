// UserBaseUrl.java
package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static utilities.Authentication.generateToken;

public class UserBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v1")
                .addHeader("Authorization", "Bearer " + generateToken())
                .setContentType(ContentType.JSON)
                .build();
    }
}