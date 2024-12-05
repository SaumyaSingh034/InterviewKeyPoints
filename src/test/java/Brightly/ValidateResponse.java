package Brightly;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse {

    @Test
    public void buildResponse(){
        given().auth().basic("username","password")
                .header("api-key","value")
                .contentType(ContentType.JSON)
                .body("hello body")
                .when()
                .post("")
                .then()
                .assertThat()
                .statusCode(201)
                .body("key",equalTo("value"))
                .body("nested.key.id", equalTo("value"));
    }
}
