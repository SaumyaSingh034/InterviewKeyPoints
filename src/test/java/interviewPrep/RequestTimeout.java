package interviewPrep;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import org.testng.annotations.Test;

public class RequestTimeout {

    @Test
    public void setUpRequestTimeOut(){
        RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.socket.timeout",3000));
    }
}
