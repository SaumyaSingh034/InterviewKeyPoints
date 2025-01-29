package November;

import CreatePoJoComplex.GetCourses;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import complexPayload.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonPayloadComplex {

    @Test
    public void validateJson(){
        Gson gson = new Gson();
        GetCourses courses = new GetCourses();

    }
}
