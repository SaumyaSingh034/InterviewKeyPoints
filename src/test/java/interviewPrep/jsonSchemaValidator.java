package interviewPrep;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class jsonSchemaValidator {

    @Test
    public void jsonSchema(){
    given().when().post().then().
            body(JsonSchemaValidator.matchesJsonSchemaInClasspath("user-schema.json"));

    Response response = given().when().get();
    File file = new File("pathoffile");

    }
}
