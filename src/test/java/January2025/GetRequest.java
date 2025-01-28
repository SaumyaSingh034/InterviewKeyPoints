package January2025;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class GetRequest {
    public static void main(String[] args){
        given().contentType(ContentType.JSON).baseUri("")
                .header("data","").queryParam("")
                .when().get()
                .then().statusCode(200).extract().response();
    }
}
