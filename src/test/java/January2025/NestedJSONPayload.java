package January2025;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class NestedJSONPayload {
    public static void main(String[] args){
        HashMap<String, String> req = new HashMap<>();
        req.put("name","workspace");
        req.put("id","X1234");
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("workspace", req);

        given().baseUri("data").body(requestBody)
                .when().post()
                .then().statusCode(201);

    }
}
