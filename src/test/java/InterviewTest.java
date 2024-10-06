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


}
