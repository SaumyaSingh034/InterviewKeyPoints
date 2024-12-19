package Brightly;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateJsonSchema {

    @Test
    public void validateJson(){
        given().auth().basic("username","password")
                .header("api-key","value")
                .contentType(ContentType.JSON)
                .body("hello body")
                .when()
                .post("")
                .then()
                .assertThat()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchema("jsonSchemafile"));
    }
}
