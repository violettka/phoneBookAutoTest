package pages;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


import  com.jayway.restassured.RestAssured;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;



public class Requests {
    @Test
    public  String retrieveToken(String apiKey, String projectId) {
        String body = "{\n" +
                "  \"email\" : \"sergiitaran82@gmail.com\",\n" +
                "  \"password\" : \"phone.boock.test\"\n" +
                "}";
        Response response =
                given()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post("http://localhost:8080/api/user/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        System.out.println("Response " + response.header("Access-Token"));
        //log.info("Retrieve token response: {}", response.asString() );
        return response.header("Access-Token");
    }
}
