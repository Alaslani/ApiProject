package requests;

import base_urls.BookerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C15_PostRequestNestedMap extends BookerBaseUrl {
    /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                "firstname": "John",
                "lastname": "Doe",
                "totalprice": 15,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2023-03-07",
                    "checkout": "2024-09-25"
                },
                "additionalneeds": "Lunch"
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 2243,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 471,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2023-03-07",
                                                        "checkout": "2024-09-25"
                                                    },
                                                    "additionalneeds": "Lunch"
                                                }
                                            }
     */
    @Test
    public void nestedMapTest(){
        //Set the url
        spec.pathParams("first","booking");

        //Set the expected data
        //First we need to prepare inner json as map
        Map<String, String > bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2023-03-07");
        bookingdatesMap.put("checkout","2024-09-25");
        //System.out.println("bookingdatesMap = " + bookingdatesMap);

        //Now we prepare outer map
        Map<String, Object > expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Doe");
        expectedData.put("totalprice",15);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Lunch");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();



    }


}












