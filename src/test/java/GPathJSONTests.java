import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
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


    @Test
    public void extractSingleValueWithFind() {
        Response response = given().get("teams/18");
        String certainPlayer = response.path("squad.find {it.shirtNumber == 35}.name");
        System.out.println(certainPlayer);
    }


    @Test
    public void extractListOfValuesWithFindAll() {
        Response response = given().get("teams/18");
        List<?> values = response.path("squad.findAll {it.shirtNumber < 25}.name"); // List<?> or <String>
        System.out.println(values);
    }


    @Test
    public void extractSingleValueWithHighestNumber() {
        Response response = given().get("teams/18");
        String playerName = response.path("squad.max {it.shirtNumber}.name");
        System.out.println(playerName);
    }


    @Test
    public void collectAllShirtNumbers() {
        Response response = given().get("teams/18");
        List<Integer> collectAllShirts = response.path("squad.collect {it.shirtNumber}");
        System.out.println(collectAllShirts);
    }


    @Test
    public void extractMultipleValuesAndSum() {
        Response response = given().get("teams/18");
        int sumAllId = response.path("squad.collect {it.id}.sum()");
        System.out.println(sumAllId);
    }

}
