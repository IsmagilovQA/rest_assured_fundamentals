package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    public static RequestSpecification videoGame_requestSpec;
    public static RequestSpecification football_requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {

        //RestAssured.proxy("localhost", 8888); // in case you wwant to track traffic via Charles

        videoGame_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setBasePath("/app/")
                .addHeader("Content-Type", "application/xml") // or xml
                .addHeader("Accept", "application/xml") // or xml
                .build();
        /*
        if we want to include these checks within all tests - we should write the line below.
        If no, we just need to comment it and specify spec() in test
        */
        RestAssured.requestSpecification = videoGame_requestSpec;

        football_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.football-data.org")
                .setBasePath("/v2/")
                .addHeader("X-Auth-Token", "5073ec390ec249b38233a8be389f6ee6")
                .addHeader("X-Response-Control", "minified")
                .build();


        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        RestAssured.responseSpecification = responseSpec;


    }
}
