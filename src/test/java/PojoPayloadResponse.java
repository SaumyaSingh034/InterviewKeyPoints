import CreatePoJoComplex.GetCourses;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class PojoPayloadResponse {
    String accessToken;

    @Test
    public void getAccessToken(){
        Response response = given()
                .formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .log().all()
                .when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .then().statusCode(200).extract().response();

         accessToken = response.jsonPath().get("access_token");
        System.out.println(accessToken);
    }

    @Test(dependsOnMethods = "getAccessToken")
    public void validatePojoResponse(){
        GetCourses gc=	given().filter(new RequestLoggingFilter()).filter(new ResponseLoggingFilter())
                .queryParams("access_token", accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);

        //System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());
        System.out.println(gc.getCourses().getApi().get(0).getCourseTitle());
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void sslConfig(){
        given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
                .when().post("");
       given().config(config().logConfig(LogConfig.logConfig().blacklistHeader("api")));
       given().header("multiplevalue", "val2","val1","val3")
               .when().post();

    }


}
