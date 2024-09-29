import POJO.LoginCredentialsPOJO;
import POJO.LoginResponseCredentials;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ECommerce_EndtoEnd {
    LoginCredentialsPOJO login = new LoginCredentialsPOJO();
    LoginResponseCredentials loginResponseCredentials;
    String token;
    String userId;
    String productId;

    @Test(priority = 0)
    public void getAccessToken(){
        RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        login.setUserEmail("automationTest9811@gmail.com");
        login.setUserPassword("IamQueen@000");

        Response response = given().spec(requestSpec).log().all()
                .body(login)
                .when()
                .post("/api/ecom/auth/login")
                .then().log().all()
                .extract()
                .response();

        loginResponseCredentials =  response.as(LoginResponseCredentials.class);
        token = loginResponseCredentials.getToken();
        userId = loginResponseCredentials.getUserId();


    }

    @Test(priority = 1)
    public void createProduct(){
        RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization", token)
               .build();

        Response response = given().spec(requestSpec)
                .param("productName","Laptop")
                .param("productAddedBy", userId)
                .param("productCategory", "fashion")
                .param("productSubCategory", "shirts").
                param("productPrice", "11500")
                .param("productDescription", "Lenova").
                param("productFor", "men")
                .multiPart("productImage", new File("/Users/saumya.singh/IdeaProjects/RestAssuredInterviewKeyPoints/src/main/resources/Free Elegant Naming Ceremony Invitation Template.png"))
                .log().all().when()
                .post("/api/ecom/product/add-product")
                .then().log().all()
                .statusCode(201)
                .extract().response();

        productId = response.jsonPath().get("productId");

    }
    @Test(priority = 2)
    public void placeOrder(){

    }
}
