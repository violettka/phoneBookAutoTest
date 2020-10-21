package tests.basicGUITests.steps;


import cucumber.api.java8.En;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONException;
import tests.basicGUITests.utils.APITestsHelper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static tests.basicGUITests.utils.Constants.contactAPIURL;

public class ContactAPISteps extends APITestsHelper implements En {

    private HttpResponse response;
    private HttpPost postRequest;
    private HttpGet getRequest;

    public ContactAPISteps() {

        When("I make POST request for the endpoint 'contact'", () -> {
            postRequest = new HttpPost(contactAPIURL);
            postRequest.addHeader(token);
            try {
                postRequest.setEntity(new StringEntity(createRandomContact().toString(), ContentType.APPLICATION_JSON));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                response = client.execute(postRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Then("I see status code {}", (Integer code) -> {
            Integer statusCode = response.getCode();
            assertEquals(code, statusCode);
        });

        When("I make GET request for the endpoint 'contact'", () -> {
            getRequest = new HttpGet(contactAPIURL);
            getRequest.addHeader(token);
            try {
                response = client.execute(getRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
