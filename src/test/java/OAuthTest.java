import POJO.CoursesDetails;
import POJO.GetCourses_POJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OAuthTest {

    @Test
    public void getAccessToken(){
        RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi";
        Response response = given().formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .log().all()
                .when()
                .post("/oauth2/resourceOwner/token")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();

        String accessToken = response.jsonPath().get("access_token");

        response = given()
                .queryParam("access_token",accessToken)
                .log().all()
                .when()
                .get("/getCourseDetails")
                .then()
                .log().all().extract().response();
        //Using POJO
        GetCourses_POJO getCourse = response.as(GetCourses_POJO.class);
        System.out.println(getCourse.getInstructor());
        System.out.println(getCourse.getLinkedIn());
        System.out.println(getCourse.getExpertise());
        System.out.println(getCourse.getUrl());

        int size = getCourse.getCourses().getApi().size();
        String price;
        for(int i=0;i<size;i++){
            String title = getCourse.getCourses().getApi().get(i).getCourseTitle();
            if(title.equalsIgnoreCase("SoapUI Webservices testing")) {
                System.out.println(title);
                price = getCourse.getCourses().getApi().get(i).getPrice();
                System.out.println(price);
            }

        }
        //Assignment

        //print all course title from web Automation

       List<CoursesDetails> web =  getCourse.getCourses().getWebAutomation();
        for(int i=0;i<web.size();i++){
            System.out.println(web.get(i).getCourseTitle());
        }
    }
}
