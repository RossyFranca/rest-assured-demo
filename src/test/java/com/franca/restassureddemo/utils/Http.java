package com.franca.restassureddemo.utils;


import io.restassured.response.Response;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@SpringJUnitConfig(TestConfig.class)
@Import(TestConfig.class)
public class Http {

    static String localUrl = YamlReader.getLocalUrl();

    public static Response getRequest(String path) {

        Response response = given().baseUri(localUrl).get(path).thenReturn();
        return response;
    }

    public static Response postRequest(String path, Map body) {

        Map<String, String> headers =
                new HashMap<String, String>() {
                    {
                        put("Content-type", "application/json");
                    }
                };
        Response response = given().headers(headers).baseUri(localUrl).body(body).post(path).thenReturn();

        return response;
    }


}
