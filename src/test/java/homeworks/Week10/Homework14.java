
package homeworks.Week10;
import base_urls.DummyRestApiBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Employee;
import utilities.ObjectMapperUtils1;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class Homework14 extends DummyRestApiBaseUrl {

    /*
     Given
         https://dummy.restapiexample.com/api/v1/employees
     When
         User sends Get Request to the Url
     Then
         Status code is 200
     And
         There are 24 employees
     And
         "Tiger Nixon" and "Garrett Winters" are among the employees
     And
         The greatest age is 66
     And
         The name of the lowest age is "Tatyana Fitzpatrick"
     And
         Total salary of all employees is 6,644,770
  */

    @Test
    public void homework14() throws JsonProcessingException {
        // Set the URL
        spec.pathParams("first", "employees");

        // Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        // Assert status code is 200
        assertEquals(response.statusCode(), 200);

        // Convert the response body to a list of Employee objects
        List<Employee> employeeList = ObjectMapperUtils1.convertJsonToJavaList(response.asString(), Employee.class);

        // Assert there are 24 employees
        assertEquals(employeeList.size(), 24);

        // Assert "Tiger Nixon" and "Garrett Winters" are among the employees
        List<String> employeeNames = employeeList.stream()
                .map(Employee::getEmployee_name)
                .collect(Collectors.toList());
        assertTrue(employeeNames.contains("Tiger Nixon"));
        assertTrue(employeeNames.contains("Garrett Winters"));

        // Find the greatest age
        int maxAge = employeeList.stream()
                .mapToInt(Employee::getEmployee_age)
                .max()
                .orElseThrow();
        assertEquals(maxAge, 66);

        // Find the name of the lowest age
        String minAgeEmployee = employeeList.stream()
                .min((e1, e2) -> Integer.compare(e1.getEmployee_age(), e2.getEmployee_age()))
                .map(Employee::getEmployee_name)
                .orElseThrow();
        assertEquals(minAgeEmployee, "Tatyana Fitzpatrick");

        // Calculate the total salary of all employees
        int totalSalary = employeeList.stream()
                .mapToInt(Employee::getEmployee_salary)
                .sum();
        assertEquals(totalSalary, 6644770);
    }
}