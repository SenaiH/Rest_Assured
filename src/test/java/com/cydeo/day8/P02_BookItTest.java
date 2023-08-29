package com.cydeo.day8;

import com.cydeo.utilities.BookItTestBase;
import com.cydeo.utilities.BookItUtils;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P02_BookItTest extends BookItTestBase {

    String email = "lfinnisz@yolasite.com";
    String password = "lissiefinnis";
    String accessToken = BookItUtils.getToken(email,password);

    @DisplayName("GET /api/campuses")
    @Test
    public void test1(){
        System.out.println("accessToken = " + accessToken);

        given().accept(ContentType.JSON)
                .header("Authorization",accessToken)
                .when().get("/api/campuses").prettyPeek()
                .then().statusCode(200);


    }

    //Create new Util class nad it will generate token based on provided email and password
    //BookItUtils.getToken(String email,String password)

    @DisplayName("GET /api/users/me")
    @Test
    public void test2(){
        given()
                .accept(ContentType.JSON)
                .header("Authorization",BookItUtils.getToken(email,password))
                .when()
                .get("/api/users/me").prettyPeek()
                .then()
                .statusCode(200);
    }

    @DisplayName("GET /api/users/me")
    @Test
    public void test3(){
        given()
                .accept(ContentType.JSON)
                .auth().oauth2(accessToken)
                .when()
                .get("/api/users/me").prettyPeek()
                .then()
                .statusCode(200);
    }
}
/*
String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODMxNiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.AfWgzpG2pL-Sdq099hoRVsADQwTTrj6tCtYddW1wIRM";
 */