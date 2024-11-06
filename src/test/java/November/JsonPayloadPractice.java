package November;

import complexPayload.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPayloadPractice {

    @Test
    public void validateJson(){
        String response = Payload.payloadForPractice();
        JsonPath js = new JsonPath(response);
        int size = js.get("company.employee.size()");
        for(int i = 0;i<size;i++){
            int id = js.get("company.employee["+i+"].id");
           String name =  js.get("company.employee["+i+"].name");
            String role = js.get("company.employee["+i+"].role");
            System.out.println(id+"  -->  "+name+"  --> "+role);
        }
    }
}
