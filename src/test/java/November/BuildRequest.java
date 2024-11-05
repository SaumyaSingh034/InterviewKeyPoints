package November;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BuildRequest {

    @Test
    public void buildRequest(){
        Response response = given().auth().basic("username","password")
                .header("Content-Type", "application/json")
                .queryParam("key","value")
                .body("String body")
                .when()
                .post("url")
                .then()
                .statusCode(201)
                .extract()
                .response();

    }
}
