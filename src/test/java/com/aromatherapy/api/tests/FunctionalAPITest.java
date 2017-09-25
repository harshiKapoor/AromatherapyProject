package com.aromatherapy.api.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class FunctionalAPITest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if(port == null) {
            RestAssured.port = Integer.valueOf(5000);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath == null) {
            basePath = "/shops";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }
}
