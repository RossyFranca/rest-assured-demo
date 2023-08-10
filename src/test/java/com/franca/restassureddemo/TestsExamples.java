package com.franca.restassureddemo;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestsExamples {

    @Test
    public void testOne(){

    Response response = given().get("http://localhost:3000/#/").thenReturn();
    System.out.println(response);

    }
}
