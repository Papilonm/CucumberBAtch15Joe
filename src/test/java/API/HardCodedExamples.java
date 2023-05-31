package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class HardCodedExamples {
   String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
   String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUzODYyNDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTQyOTQ0NywidXNlcklkIjoiNTQ1NyJ9.LUiZri1hxegd66Jk8BDa-8qRBqnFrHjPjs22_WL6Mn8";



   @Test
   public void createEmployee(){
       //prepare the request
       RequestSpecification prepareRequest=given().
               header("Content-Type","application/json").
               header("Authorization",token).body("{\n" +
                       "  \"emp_firstname\": \"bowser\",\n" +
                       "  \"emp_lastname\": \"peaches\",\n" +
                       "  \"emp_middle_name\": \"M\",\n" +
                       "  \"emp_gender\": \"M\",\n" +
                       "  \"emp_birthday\": \"2005-05-22\",\n" +
                       "  \"emp_status\": \"Confirmed\",\n" +
                       "  \"emp_job_title\": \"Engineer\"\n" +
                       "}");

       //Send the request/hitting the endPoint
       Response response=prepareRequest.when().post("/createEmployee.php");

       //It will print the output in the console
       response.prettyPrint();
       //verifying the assertions
       response.then().assertThat().statusCode(201);

       //Verifying firstName
       response.then().assertThat().
               body("Employee.emp_firstname",equalTo("bowser"));
       System.out.println("My Test Case is Passed");



   }
}
