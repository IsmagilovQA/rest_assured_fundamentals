package config;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/app/";

    }
}
