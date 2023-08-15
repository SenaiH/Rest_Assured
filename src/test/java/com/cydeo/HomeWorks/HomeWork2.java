package com.cydeo.HomeWorks;

import com.cydeo.utilities.HrTestBase;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork2 extends HrTestBase {

    @Test
    public void task1(){

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("country_id", "US")
                .when().get("/countries/{country_id}");

        //response.prettyPrint();

        //- Then status code is 200
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        //- And Content - Type is Json
        assertEquals("application/json", response.getContentType());

        //- And country_id is US
        assertEquals("US",response.path("country_id"));

        //- And Country_name is United States of America
        assertEquals("United States of America", response.path("country_name"));

        //And Region_id is 2
        assertEquals(2, (int)response.path("region_id"));

    }
/*
TASK 1 :
- Given accept type is Json
- Path param value- US
- When users sends request to /countries
- Then status code is 200
- And Content - Type is Json
- And country_id is US
- And Country_name is United States of America
 And Region_id is 2
 */

 @Test
 public void task2(){

     Response response = given()
             .accept(ContentType.JSON)
             .and()
             .queryParam("q", "{\"department_id\":80}")
             .when()
             .get("/employees");

     //response.prettyPrint();

     //- Then status code is 200
     assertEquals(HttpStatus.SC_OK,response.getStatusCode());

     //- And Content - Type is Json
     assertEquals("application/json",response.getContentType());

     //- And all job_ids start with 'SA'
     List<String> allJobs = response.path("items.job_id");
     for (String eachJob : allJobs) {
         assertTrue(eachJob.startsWith("SA"));
     }

     //- And all department_ids are 80
     List<Integer> allDepartments = response.path("items.department_id");

     for (Integer eachDepartment : allDepartments) {
         assertEquals(80,eachDepartment);
     }

     //- Count is 25
     assertEquals(25,(int)response.path("count"));


 }
/*
Given accept type is Json
- Query param value - q={"department_id":80}
- When users sends request to /employees
- Then status code is 200
- And Content - Type is Json
- And all job_ids start with 'SA'
- And all department_ids are 80
- Count is 25
 */

    @Test
    public void task3(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .queryParam("q", "{\"region_id\":3}")
                .when()
                .get("/countries");

        //- Then status code is 200
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        //- And all regions_id is 3
        List<Integer> allRegionId = response.path("items.region_id");
        for (Integer eachId : allRegionId) {
            assertEquals(3, eachId);
        }

        //- And count is 6
        assertEquals(6,(int)response.path("count"));

        //- And hasMore is false
        assertEquals("false",response.path("hasMore").toString());

        //- And Country_name are;
        //Australia,China,India,Japan,Malaysia,Singapore

        List<String> actualCountriesNames = response.path("items.country_name");
        List<String> expectedCountriesNames = new ArrayList<>(Arrays.asList("Australia","China","India","Japan","Malaysia","Singapore"));

        assertEquals(expectedCountriesNames,actualCountriesNames);

    }
/*
- Given accept type is Json
 Query param value q={“region_id":3}
- When users sends request to /countries
- Then status code is 200
- And all regions_id is 3
- And count is 6
- And hasMore is false
- And Country_name are;
Australia,China,India,Japan,Malaysia,Singapore
 */

}
