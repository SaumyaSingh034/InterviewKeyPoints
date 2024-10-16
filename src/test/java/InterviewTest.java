import complexPayload.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class InterviewTest {

    @Test
    public void practice1() {
        RestAssured.baseURI = "";
        Response response = given().header("ContentType", "application/json").log().all()
                .body("")
                .when()
                .post("").then()
                .statusCode(200).extract().response();
        JsonPath js = new JsonPath(response.toString());
        js.get("");
    }

    @Test
    public void responseValidation(){
        String response = Payload.complexJsonAnuj();
        JsonPath js = new JsonPath(response);
        int size = js.get("store.book.size()");
        for(int i=0;i<size;i++) {
            String author = js.get("store.book["+i+"].title");
            System.out.println(author);
            float price = js.get("store.book["+i+"].price");
            if(price>10) {
                System.out.println(price);
            }
        }
    }


}
