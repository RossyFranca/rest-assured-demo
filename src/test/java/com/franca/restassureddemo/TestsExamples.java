package com.franca.restassureddemo;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static com.franca.restassureddemo.utils.Http.getRequest;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestsExamples {


    @Test
    public void testOne() {

        Response response = given().get("http://localhost:3000/usuarios").thenReturn();
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        assertEquals(HttpStatus.SC_OK,response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath("schemas/usuarios-schema.json"));

    }
    @Test
    public void testTwo(){
        Response response = getRequest("usuarios");
        assertEquals(HttpStatus.SC_OK,response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath("schemas/usuarios-schema.json"));
    }

}

