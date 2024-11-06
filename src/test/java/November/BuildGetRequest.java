package November;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BuildGetRequest {

    RequestSpecification requestSpecification;

    @BeforeTest
    public void buildRequestSpec(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://fakerestapi.azurewebsites.net/")
                .setContentType(ContentType.JSON)
                .build();

    }

    @Test
    public void getCall(){
        Response response = given().spec(requestSpecification).log()
                .all()
                .when()
                .get("/api/v1/Activities")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
    }
}
