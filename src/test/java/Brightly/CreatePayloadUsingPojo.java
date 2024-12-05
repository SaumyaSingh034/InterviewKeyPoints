package Brightly;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePayloadUsingPojo {
    Details details;
    AddressDetails add;

    @Test
    public void pojoCreation(){
        details = new Details();
        add = new AddressDetails();
        add.setCity("Varanasi");
        add.setZip("221007");
        details.setId(4);
        details.setName("Saumya");
        details.setAddress(add);

        Response response = given().contentType(ContentType.JSON).log().all()
                .body(details)
                .when()
                .post("")
                .then()
                .statusCode(200)
                .extract().response();
        Details d = response.as(Details.class);
        System.out.println(d.getAddress());
    }



}
