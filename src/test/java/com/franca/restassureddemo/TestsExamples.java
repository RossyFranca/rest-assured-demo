package com.franca.restassureddemo;

import com.franca.restassureddemo.utils.YamlReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringJUnitConfig(TestsExamples.TestConfig.class)
@Import(TestsExamples.TestConfig.class)
public class TestsExamples {

    @Test
    public void testUrlLocalProperty() {
        String expectedUrl = "http://localhost:3000";
        String localUrl = YamlReader.getLocalUrl();

        System.out.println("Local URL: " + localUrl);
        assertEquals(expectedUrl,localUrl );
    }
    @Test
    public void testOne() {

        Response response = given().get("http://localhost:3000/usuarios").thenReturn();
        System.out.println(response.getStatusCode());
       // System.out.println(response.getBody().asString());
        String responseJson = response.asString();
        System.out.println(responseJson);
       response.then().body(matchesJsonSchemaInClasspath("schemas/usuarios-schema.json"));



    }
@TestConfiguration
public static class TestConfig {
}
}

