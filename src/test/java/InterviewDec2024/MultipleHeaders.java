package InterviewDec2024;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MultipleHeaders {
    @Test
    public void multipleHeaders(){
        given().header("header1","value1","value2"
        ,"value3","value4")
                .when().get("")
                .then()
                .statusCode(200);
    }
}
