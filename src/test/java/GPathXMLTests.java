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


   @Test
    public void getAttributeName() {
       Response response = get(EndPoint.VIDEOGAMES);

       String category = response.path("videoGames.videoGame[0].@category");
       System.out.println(category);

   }

}
