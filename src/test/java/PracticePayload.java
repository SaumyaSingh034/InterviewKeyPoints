import complexPayload.Payload;
import io.restassured.path.json.JsonPath;

public class PracticePayload {

    public static void main(String[] args){
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
