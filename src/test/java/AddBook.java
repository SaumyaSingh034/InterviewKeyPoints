import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.RequestPayload;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddBook {

    @Test
    public void addBook(){
        RestAssured.baseURI = "http://216.10.245.166";

        Response response  = given()
                .header("Content-Type","application/json")
               // .header("authorization","Bearer Token---")
                .body(RequestPayload.addBookRequestPayload("isbnQQ","88777"))
                .when()
                .post("Library/Addbook.php")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("Msg", equalTo("successfully added"))
                .extract().response();

        JsonPath json = new JsonPath(response.toString());
        String id = response.jsonPath().get("ID");
        System.out.println(id);

    }


    @DataProvider(name="TestData")
    public Object[][] setUpData(){
        return new Object[][]{
                {"isbn1","88888888"},
                {"isbn2","54324299344"},
                {"isbn3","95554444"},
        };
    }
    @Test(dataProvider = "TestData")
    public void parameterAddBook(String isbn, String aisle){
        RestAssured.baseURI = "http://216.10.245.166";

        Response response  = given()
                .header("Content-Type","application/json")
                // .header("authorization","Bearer Token---")
                .body(RequestPayload.addBookRequestPayload(isbn, aisle))
                .when()
                .post("Library/Addbook.php")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("Msg", equalTo("successfully added"))
                .extract().response();

        String id = response.jsonPath().get("ID");
        given().header("Content-Type","application/json")
                .body(RequestPayload.deletRequestPayload(id))
                .when()
                .post(":/Library/DeleteBook.php")
                .then()
                .statusCode(200)
                .body("msg", equalTo("book is successfully deleted"));

    }


}
