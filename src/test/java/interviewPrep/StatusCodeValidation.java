package interviewPrep;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeValidation {

    @Test
    public void statusCodeValidation(){

        RestAssured.baseURI = "hello";
        given().header("Content-Type","application/json")
                .when()
                .get(" ")
                .then()
                .statusCode(200);
    }
}
