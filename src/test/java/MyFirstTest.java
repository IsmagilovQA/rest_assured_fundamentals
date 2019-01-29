import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest {

    @Test
    public void myFirstTest() {
        given()
                .when().get("http://localhost:8080/app/videogames/1")
                .then()
                .statusCode(200);

    }
}
