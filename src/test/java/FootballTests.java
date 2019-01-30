import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsStandings() {
        given().log().all()
                .spec(football_requestSpec)
                .queryParam("standingType", "HOME")
                .when().get("competitions/2021/standings")
                .then().log().all();
    }


    @Test
    public void getTeamCount_OneComp() {
        given().spec(football_requestSpec)
                .when().get("competitions/2000/teams")
                .then()
                .body("count", equalTo(32));
    }


    @Test
    public void getFirstTeamName() {
        given().spec(football_requestSpec)
                .when().get("competitions/2000/teams")
                .then()
                .body("teams.name[0]", is("Uruguay"));
    }


    @Test
    public void extractAllteamData() {
        String responseBody = given().spec(football_requestSpec)
                .when().get("competitions/2000/teams").asString(); // save as string
        System.out.println(responseBody);
    }


    @Test
    public void extractAllteamData_DoCheckfirst() {
        Response response = given().spec(football_requestSpec)
                .when().get("competitions/2000/teams")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .extract().response();
        String jsonResponseAsString = response.asString();
    }
}
