package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class C22_PojoList extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
           I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            First todo must be like:
                    {
                            "userId": 1,
                            "id": 1,
                            "title": "delectus aut autem",
                            "completed": false
                    }
*/

    @Test
    public void pojoListTest(){
        //Set the url
        spec.pathParams("first", "todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(1,"delectus aut autem", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        List<JsonPlaceHolderPojo> actualData = response.as(new TypeRef<List<JsonPlaceHolderPojo>>() {});//new TypeRef<>() {} --> This takes the data type and assign json to that data type.
        System.out.println("actualData = " + actualData.getFirst().getTitle());



    }



}