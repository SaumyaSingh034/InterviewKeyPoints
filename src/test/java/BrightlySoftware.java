import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BrightlySoftware {

    @Test
    public void setRequestSpecification(){
        RequestSpecification rs = new RequestSpecBuilder().setBaseUri("baseUri").setContentType(ContentType.JSON).build();

        given().spec(rs).when()
                .get("endpoint")
                .then()
                .statusCode(200);

    }
}
