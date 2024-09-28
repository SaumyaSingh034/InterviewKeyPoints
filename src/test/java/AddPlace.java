import POJO.CreateAddress_POJO;
import POJO.Location;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddPlace {


    @Test
    public void createAddPlace(){
        RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();
        CreateAddress_POJO createAddressPojo = new CreateAddress_POJO();
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        createAddressPojo.setAddress("9,sidelayout,cohen09 New Delhi");
        createAddressPojo.setAccuracy(50);
        createAddressPojo.setLanguage("English-EN");
        createAddressPojo.setName("Saumya Automation");
        createAddressPojo.setPhone_number("(+91)9838933937");
        createAddressPojo.setWebsite("http://google.com");
        List<String> a = new ArrayList<>();
        a.add("shopping");
        a.add("travleeing");
        a.add("studing");
        a.add("coding");
        createAddressPojo.setTypes(a);
        createAddressPojo.setLocation(l);
        ResponseSpecification responseSpecification=  new ResponseSpecBuilder().expectStatusCode(200).build();
        Response response = given()
                .spec(request)
                .body(createAddressPojo).log().all()
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .statusCode(200).log().all()
                .extract()
                .response();

        System.out.println(response.asString());
    }
}
