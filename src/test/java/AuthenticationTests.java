import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class AuthenticationTests {

    @BeforeClass
    public static void setup() {
        RestAssured.proxy("localhost", 8888);
    }


    @Test
    public void basicPreemptiveAuthTest() {
        given().auth().preemptive().basic("usernmae", "password")
                .when().get("http://localhost:8080/someEndpoint");
    }


    @Test
    public void basicChallengedAuthTest() {
        given().auth().basic("usernmae", "password")
                .when().get("http://localhost:8080/someEndpoint");
    }


    @Test
    public void oauth1Test() {
        // do not forget to add dependency for Scribe to build.gradle file
        given().auth().oauth(
                "consumerKey", "comsumerSecret",
                "accessToken", "secretTopen")
                .when().get("http://localhost:8080/someEndpoint");
    }


    @Test
    public void oauth2Test() {
        given().auth().oauth2("accessToken")
                .when().get("http://localhost:8080/someEndpoint");
    }
}
