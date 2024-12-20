package PayPay;

import complexPayload.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;

public class PayPayInterview {

    @Test
    public void payload(){
        String jsonResponse = "[{\"userId\": 1, \"Id\": 1, \"title\": \"saumya\", \"age\": \"hello\"}]";

        // Parse the JSON response
        JsonPath jsonPath = new JsonPath(jsonResponse);

        // Extract userId and Id
        List<Integer> userIds = jsonPath.getList("userId");
        List<Integer> ids = jsonPath.getList("Id");
        // Print values
        System.out.println("UserIds: " + userIds);
        System.out.println("Ids: " + ids);
    }
}
