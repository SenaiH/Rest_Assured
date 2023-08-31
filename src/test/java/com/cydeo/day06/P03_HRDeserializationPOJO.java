package com.cydeo.day06;

import com.cydeo.pojo.Employee;
import com.cydeo.pojo.Region;
import com.cydeo.pojo.Regions;
import com.cydeo.utilities.HrTestBase;
//import com.sun.org.apache.xerces.internal.util.PropertyState;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class P03_HRDeserializationPOJO extends HrTestBase {
    @DisplayName("GET regions to desserializate to POJO - LOMBOK -JSON PROPERTY")
    @Test
    public void test1(){
        JsonPath jsonPath = get("/regions")
                .then().statusCode(200)
                .extract().jsonPath();

        //get first region from items array and convert it to Region class
        Region region1 = jsonPath.getObject("items[0]", Region.class);

        System.out.println("region1 = " + region1);

//        System.out.println("region1.getRegion_id() = " + region1.getRegion_id());
//        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());

        System.out.println("region1.getRegionName() = " + region1.getRegionName());
        System.out.println("region1.getRegionId() = " + region1.getRegionId());
        System.out.println("region1.getLinks().get(0).getHref() = " + region1.getLinks().get(0).getHref());

    }

    @DisplayName("GET employee to deserialization to POJO with only required fields")
    @Test
    public void test2(){

        JsonPath jsonPath = get("/employees")
                .then().statusCode(200)
                .extract().jsonPath();

        Employee employee1 = jsonPath.getObject("items[0]", Employee.class);

        System.out.println("employee1 = " + employee1);


    }



}
