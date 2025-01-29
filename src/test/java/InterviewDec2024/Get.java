package InterviewDec2024;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get {

    @Test
    public void getCall(){
        RestAssured.baseURI = "baseuri";
        Response response = given().header("Content-Type","application/json")
                .when().get("get uri");
    }


    @Test
    public void getLogError(){
        given().header("","")
                .when().get(" ")
                .then().log().ifError().assertThat().statusCode(200);
    }
}
