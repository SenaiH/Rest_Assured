package com.cydeo.HomeWorks;

import com.cydeo.utilities.HrTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWork1 extends HrTestBase {

    @Test
    public void task1(){
        Response response = RestAssured.given().accept(ContentType.JSON).when().get("/countries/US");

       //response.prettyPrint();

        System.out.println(response.statusCode());

        Assertions.assertEquals(200,response.statusCode());

        System.out.println(response.contentType());

        Assertions.assertEquals("application/json",response.contentType());

        Assertions.assertTrue(response.body().asString().contains("United States of America"));

/*
Task 1 :
- Given accept type is Json
- When users sends request to /countries/US
- Then status code is 200
- And Content - Type is application/json
- And response contains United States of America
 */

    }

    @Test
    public void task2(){

        Response response = RestAssured.given().accept(ContentType.JSON).when().get(" /employees/1");

        //response.prettyPrint();

        System.out.println(response.statusCode());

        Assertions.assertEquals(404,response.statusCode());


    }
/*
- Given accept type is Json
- When users sends request to /employees/1
- Then status code is 404
 */

  @Test
  public void task3(){

      Response response = RestAssured.given().accept(ContentType.JSON).when().get("/regions/1");

      System.out.println(response.statusCode());

      Assertions.assertEquals(200,response.statusCode());

      Assertions.assertEquals("application/json", response.contentType());

      Assertions.assertTrue(response.body().asString().contains("Europe"));

      Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

      Assertions.assertEquals("chunked", response.header("Transfer-Encoding"));

  }
/*
- Given accept type is Json
- When users sends request to /regions/1
- Then status code is 200
- And Content - Type is application/json
- And response contains Europe
- And header should contains Date
- And Transfer-Encoding should be chunked
 */
}
