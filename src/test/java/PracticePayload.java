import complexPayload.Payload;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class PracticePayload {

    public static void main(String[] args){
        AuthenticationScheme auth = new BasicAuthScheme();

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("").setAuth(auth)
                .setContentType(ContentType.JSON)
                .setBody("").build();
        JsonPath js = new JsonPath(Payload.complexJsonAnuj());
        int size = js.get("store.book.size()");
        String author = null;
        String category = null;
        String price = null;

        for(int i=0;i<size;i++){
            String title = js.getString("store.book["+i+"].title");
            if(title.equalsIgnoreCase("SwordofHonour")){
                author = js.getString("store.book["+i+"].author");
                category = js.getString("store.book["+i+"].category");
                price = js.getString("store.book["+i+"].price");

                System.out.println(author);
                System.out.println(category);
                System.out.println(price);

            }


        }
    }
}
