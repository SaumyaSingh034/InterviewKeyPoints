import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.RequestPayload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CreateDifferentSetOfRequestPayload {

    @Test(dataProvider = "testDataSet")
    public void createRequestBodywithString(String isbn, String aisle){
        RestAssured.baseURI="https://rahulshettyacademy.com/";

        Response response = given().header("Content-Type","application/json")
                        .queryParam("key","qaclick123")
                .body(RequestPayload.addBookRequestPayload(isbn, aisle))
                .when().post("Library/Addbook.php")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
    }

    @Test
    public void createRequestPayloadUsingFile() throws IOException {
        given().header("Content-Type","application/json")
                        .queryParam("key", "qaclick123")
                                .body(new String(Files.readAllBytes(Paths.get("src/main/resources/payload.json"))))
                .log().all().when()
                        .post("");
    }


    @DataProvider(name="testDataSet")
    public Object[][] dataSetUp(){
        return new Object[][] {
                {"saumya","87987797"},
                {"ytttuys","898388"}
        };
    }
}
