import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OAuthTest {

    @Test
    public void getAccessToken(){
        Response response = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .log().all()
                .when()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();

        String accessToken = response.jsonPath().get("access_token");

        given()
                .queryParam("access_token",accessToken)
                .log().all()
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .then()
                .log().all().extract().response();
    }
}
