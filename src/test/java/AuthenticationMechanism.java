import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationMechanism {

    @Test
    public void basicAuth(){
        given().auth().basic("userName","password")
                .body("String")
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}
