import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {
        given()
                .when().get(EndPoint.VIDEOGAMES)
                .then();
    }


    @Test
    public void createNewGameByJSON() {

        String gameBodyJson = "{\n" +
                "  \"id\": 15,\n" +
                "  \"name\": \"My video Game\",\n" +
                "  \"releaseDate\": \"2019-01-29T09:59:35.600Z\",\n" +
                "  \"reviewScore\": 55,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(gameBodyJson)
                .when().post(EndPoint.VIDEOGAMES)
                .then();

    }


    @Test
    public void createNewGameByXML() {

        String ganeBodyXML = "<videoGame category=\"Driving\" rating=\"Mature\">\n" +
                "    <id>17</id>\n" +
                "    <name>My video Game 3</name>\n" +
                "    <releaseDate>2019-01-29T00:00:00+02:00</releaseDate>\n" +
                "    <reviewScore>62</reviewScore>\n" +
                "  </videoGame>";
        given()
                .body(ganeBodyXML)
                .when().post(EndPoint.VIDEOGAMES)
                .then().log().all();
    }


    @Test
    public void updateGame() {

        String updatedGameBodyJson = "{\n" +
                "  \"id\": 15,\n" +
                "  \"name\": \"My updated video Game\",\n" +
                "  \"releaseDate\": \"2019-01-29T09:59:35.600Z\",\n" +
                "  \"reviewScore\": 55,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";
        given()
                .body(updatedGameBodyJson)
                .when().put("/videogames/15")
                .then();

    }


    @Test
    public void deleteGame() {
        given()
                .when().delete("/videogames/4")
                .then().log().all();
    }


}
