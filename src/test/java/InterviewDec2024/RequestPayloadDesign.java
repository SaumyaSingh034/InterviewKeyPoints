package InterviewDec2024;

import complexPayload.Payload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestPayloadDesign {
    @Test
    public void testPayload(){
        String response = Payload.complexJsonAnuj();
        JsonPath js = new JsonPath(response);
        int size = js.get("store.book.size()");
        System.out.println(size);
        for(int i=0;i<size;i++){
            String bookName = js.get("store.book["+i+"].title");
            if(bookName.equalsIgnoreCase("MobyDick")){
                System.out.println((String) js.get("store.book["+i+"].category"));
                System.out.println((String) js.get("store.book["+i+"].author"));
                System.out.println((String) js.get("store.book["+i+"].title"));
                System.out.println((String) js.get("store.book["+i+"].isbn"));
                System.out.println((float) js.get("store.book["+i+"].price"));
            }
        }


    }

    @Test
    public void apiChaining(ITestContext context){
        int bookingId = given().header("Content-Type","applicastion/json").auth().oauth2("")
                .body("")
                .when().post("").then()
                .extract().path("bookingId");
        context.setAttribute("bookingID",bookingId);

       // context.getAttribute("bookingID");
    }
}
