package InterviewDec2024;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BuildRequestBody {

    @Test
    public void sendData(String dynamicId){
        Map<String, String> workplace = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        workplace.put("name","workspace");
        workplace.put("id",dynamicId);
        body.put("workspace",workplace);
        System.out.println(body);

        given().log().all().body(body)
                .when()
                .post("");

    }
}
