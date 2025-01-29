package InterviewDec2024;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DownloadAFile {

    @Test
    public void downloadFile(){
      byte[] dataFile =   given().pathParam("data","value")
                .queryParam("data","vavs")
                .when()
                .get()
                .then().extract().asByteArray();
    }
}
