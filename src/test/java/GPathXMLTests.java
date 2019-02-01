import config.EndPoint;
import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class GPathXMLTests extends TestConfig {

   @Test
   public void getFirstGameInList() {
       Response response = get(EndPoint.VIDEOGAMES);

       String firstName = response.path("videoGames.videoGame.name[0]");
       System.out.println(firstName);
   }

}
