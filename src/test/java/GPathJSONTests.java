import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPathJSONTests extends TestConfig {

    @Test
    public void extractMapElementsWithFind() {
        Response response = given().get("competitions/2000/teams");

        // Displaying all data for single team with name 'Argentina'
        Map<String,?> allTeamDataForSingleTeam = response.path("teams.find {it.name == 'Argentina'}");
        System.out.println(allTeamDataForSingleTeam);
    }




}
