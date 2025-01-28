package January2025;

import complexPayload.Payload;
import io.restassured.path.json.JsonPath;

import java.util.List;

public class ExtractResponse {
    public static void main(String[] args){
        String response = Payload.payPayInterview();
        JsonPath json = new JsonPath(response);
        int data = json.get("[0].userId");
        List<Integer> userIds = json.getList("userId", Integer.class);
        System.out.println(data);
        System.out.println(userIds);

    }
}
