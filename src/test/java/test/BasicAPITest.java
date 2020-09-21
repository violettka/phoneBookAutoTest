package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;

public class BasicAPITest {
    CloseableHttpClient client;
    String baseURL = "http://localhost:8080/api/";
    HttpGet getRequest;  //request to server on url with user name
    String email = "qatest.taran01@gmail.com";
    String user = "";
    String password = "qatest01";
    HttpResponse response;  //answer from server
    String auth;
    HttpPost postRequest;
    HttpDelete deleteRequest;
    String token = "";

    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
    }

}
