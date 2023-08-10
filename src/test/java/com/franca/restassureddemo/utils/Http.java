package com.franca.restassureddemo.utils;


import io.restassured.response.Response;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static io.restassured.RestAssured.given;

@SpringJUnitConfig(TestConfig.class)
@Import(TestConfig.class)
public class Http {

    static String localUrl = YamlReader.getLocalUrl();
    public static Response getRequest(String path){

        Response response = given().baseUri(localUrl).get(path).thenReturn();
        return response;
    }

}
