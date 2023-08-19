package com.cydeo.HomeWorks;

import com.cydeo.pojo.Region;
import com.cydeo.pojo.Regions;
import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Day6_HomeWork extends HrTestBase {
    @DisplayName("GET all regions and verify data")
    @Test
    public void test3() {  //Day06


        JsonPath jsonPath = given().accept(ContentType.JSON).get("/regions")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        Regions regions = jsonPath.getObject("", Regions.class);

        List<Region> items = regions.getItems();

        List<Integer> regionIds = Arrays.asList(1, 2, 3, 4);
        List<String> regionNames = Arrays.asList("Europe" ,"Americas" , "Asia", "Middle East and Africa");


        for (int i = 0; i < items.size(); i++) {
            Region region = items.get(i);

            assertThat(regionIds.get(i),is(region.getRegionId()));
            assertThat(regionNames.get(i),is(region.getRegionName()));
        }

        assertThat(items.size(),is(4));
    }

        /*
    TASK

    Given accept is application/json
    When send request  to /regions endpoint
    Then status should be 200
            verify that region ids are 1,2,3,4
            verify that regions names Europe ,Americas , Asia, Middle East and Africa
            verify that count is 4
        -- Create Regions POJO
        -- And ignore field that you dont need

     */

}
