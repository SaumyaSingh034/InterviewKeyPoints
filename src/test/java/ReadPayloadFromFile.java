import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ReadPayloadFromFile {

    public static String readPayloadFrile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/payload.json")));
    }

    @Test
    public void postCall() throws IOException {
        given().log().all().body(readPayloadFrile()).post()
                .then()
                .statusCode(200);
    }
}
