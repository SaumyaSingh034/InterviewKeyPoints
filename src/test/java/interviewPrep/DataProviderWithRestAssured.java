package interviewPrep;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DataProviderWithRestAssured {

    @Test(dataProvider = "testData")
    public void test(String name, String prof){
        given().header("Content-type","application/json")
                .body(requestBody(name, prof))
                .when()
                .post("/users")
                .then()
                .statusCode(200).extract()
                .response();

    }

    public static String requestBody(String name, String profession){
        return "{\"name\":\""+name+"\",\"profession\":\""+profession+"\"}";
    }

    @DataProvider(name="testData")
    public Object[][] testDataSetup(){
        return new Object[][] {
                {"saumya", "TAE"},
                {"suraj", "SAP Developer"},
                {"shubam", "Developer"},
                {"astha", "HR"}
        };
    }
}
