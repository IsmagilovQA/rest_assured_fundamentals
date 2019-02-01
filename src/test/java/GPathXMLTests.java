import config.EndPoint;
import config.TestConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

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


   @Test
    public void getListOfXmlNodes() {
       String responseAsString = get(EndPoint.VIDEOGAMES).asString();

       List<Node> allResults = XmlPath.from(responseAsString).get(
               "videoGames.videoGame.findAll {element -> return element}");
       System.out.println(allResults.get(2).get("name").toString());
   }

}
