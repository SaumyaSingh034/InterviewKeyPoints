package InterviewDec2024;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BuildRequestSpec {
    Map<String, String> headersData = new HashMap<>();
    RequestSpecification spec;
    RequestSpecification specRest;
    @BeforeMethod
    public void builder(){
         spec = new RequestSpecBuilder()
                .setBaseUri("").setContentType("application/json")
                .setBody("").addHeaders(headersData).build();

         specRest = given().baseUri("")
                .body("").headers(headersData);

    }

    @Test
    public void buildRequest(){
        Response response = given().spec(spec).when().get();
        response.jsonPath().get("data.book.size()");
        response.path("userName[0].name");
        given().spec(specRest).when().get();
    }
}
