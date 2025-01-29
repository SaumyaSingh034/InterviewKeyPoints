package interviewPrep;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractResponse {

    @Test
    public void extractResponse(){
        Response response = given().pathParam("userId", "123")
                .header("content-type", "application/json")
                .body("")
                .when()
                .post(" ");

        response.jsonPath().get("path");
        JsonPath js = new JsonPath(response.asString());
        js.get("path");
    }
}
