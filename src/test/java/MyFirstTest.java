import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        given().log().ifValidationFails() // log only in case the test fails.
                .when().get("videogames/1")
                .then().log().all(); // log all data

    }

    @Test
    public void deleteGame() {
        given()
                .spec(videoGame_requestSpec)// specificly
                .when()
                .delete("/videogames/5")
                .then()
                .spec(responseSpec);
    }
}
