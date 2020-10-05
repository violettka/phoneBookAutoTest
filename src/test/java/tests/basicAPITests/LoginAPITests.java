package tests.basicAPITests;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import utils.FunctionalAPITest;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class LoginAPITests extends FunctionalAPITest {

    CloseableHttpClient client;


    HttpPost postRequest;
    URL object = new URL(loginAPIUrl);
    HttpResponse response;
    HttpGet getRequest;


    public LoginAPITests() throws IOException {
    }

    private String getLoginToken(){
        String token = response.getFirstHeader("Access-Token").getValue();
        System.out.println("token = " + token);
        return token;
    }

    private void userAuthorization(String token) throws IOException {
        getRequest = new HttpGet(basicUrl);
        getRequest.setHeader("access-token", token);
        response = client.execute(getRequest);
    }

    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
        postRequest = new HttpPost(loginAPIUrl);
        postRequest.addHeader("Content-Type", "application/json");
    }

    @Test
    public void testLoginConfirmedUser() throws IOException {
        String json = "{\"email\":\"" + userExisted + "\"" + "," + "\"password\":\"" + passwordExisted + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(200, response.getStatusLine().getStatusCode());
        userAuthorization(getLoginToken());
        client.close();
        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void testLoginUnconfirmedUser() throws IOException {
        String json = "{\"email\":\"" + newRandomUser + "\"" + "," + "\"password\":\"" + passwordExisted + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(401, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testLoginUnknownUser() throws IOException {
        String json = "{\"email\":\"" + userExisted + "\"" + "," + "\"password\":\"" + "sdsdsd" + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(401, response.getStatusLine().getStatusCode());

    }


}
