import config.EndPoint;
import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

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


    @Test
    public void getSingleGame() {
        given()
                .pathParam("videoGameId", 7)
                .when().get(EndPoint.SINGE_VIDEOGAME)
                .then().log().all();
    }


    @Test
    public void testVideoGameSerializationByJSON() {

        VideoGame_POJO videoGame = new VideoGame_POJO("21", "Super Mario",
                "2019-04-29", "75",
                "Action", "Kids");

        given().spec(videoGame_requestSpec)
                .body(videoGame)
                .when().post(EndPoint.VIDEOGAMES)
                .then().log().all();
    }


    @Test
    public void testVideoGameDeserializationByJSON() {
        Response response = given()
                .pathParam("videoGameId", 21)
                .when().get(EndPoint.SINGE_VIDEOGAME);

        VideoGame_POJO videoGame = response.getBody().as(VideoGame_POJO.class);
        System.out.println(videoGame.toString());

    }
}
