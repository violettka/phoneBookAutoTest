package tests.basicAPITests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import utils.FunctionalAPITest;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class RegistrationAPITests extends FunctionalAPITest {

    CloseableHttpClient client;


    private String regToken = "812471f9-7d85-4f60-8551-d6dd56390136";



    HttpPost postRequest;
    URL object = new URL(registrationAPIUrl);
    HttpResponse response;
    HttpGet getRequest;


    public RegistrationAPITests() throws IOException {
    }


    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
        postRequest = new HttpPost(registrationAPIUrl);
        postRequest.addHeader("Content-Type", "application/json");
    }

//    @After
//    public void getResponse(){
//
//    }

    @Test
    public void testRegNewUser () throws IOException{

        String json = "{\"email\":\"" + newRandomUser + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(200, response.getStatusLine().getStatusCode());
        LOGGER_API.info("Test passed");
    }

    @Test
    public void testConfirmUser() throws IOException {
//        ----- please enter regToken value manually from your E-mail -----

        getRequest = new HttpGet(registrationAPIUrl + "/activation/" + regToken);
        response = client.execute(getRequest);
        assertEquals(200, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegExistedUser () throws IOException{
        String json = "{\"email\":\"" + userExisted + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(400, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegWrongUserNoAt () throws IOException{
        String json = "{\"email\":\"" + "nmmujt.gmail.com" + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegWrongUserAsString () throws IOException{
        String json = "{\"email\":\"" + "nmmujtgmailcom" + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegWrongUserNoPoint () throws IOException{
        String json = "{\"email\":\"" + "nmmujt@gmailcom" + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegWrongUserBadDom () throws IOException{
        String json = "{\"email\":\"" + "nmmujt@gmail.c" + "\"" + "," + "\"password\":\"" + newRandomPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegTooShortPass () throws IOException{
        String json = "{\"email\":\"" + newRandomUser + "\"" + "," + "\"password\":\"" + shortPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegTooLongPass () throws IOException{
        String json = "{\"email\":\"" + newRandomUser + "\"" + "," + "\"password\":\"" + longPass + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }

    @Test
    public void testRegBodyWrong () throws IOException{
        String json = "{\"email\":\"" + newRandomUser;
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());

    }


}
