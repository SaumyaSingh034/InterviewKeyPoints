import complexPayload.Payload;
import io.restassured.path.json.JsonPath;

public class PayloadVerification {

    public static void main(String[] args){
        JsonPath js = new JsonPath(Payload.complexJsonAnuj());
        int size = js.get("store.book.size()");
        String title;
        String isbn;
        for(int i=0;i<size;i++){
            title = js.get("store.book["+i+"].title");
            if(title.equalsIgnoreCase("MobyDick")){
                isbn = js.get("store.book["+i+"].isbn");
                System.out.println(isbn);
            }
        }

        int ex  = js.getInt("expensive");
        System.out.println(ex);
    }
}
