import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsStandings() {
        given().log().all()
                .spec(football_requestSpec)
                .queryParam("standingType", "HOME")
                .when().get("competitions/2021/standings")
                .then().log().all();
    }
}
