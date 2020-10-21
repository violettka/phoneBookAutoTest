package tests.basicGUITests.steps;

import cucumber.api.java8.En;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONException;
import tests.basicGUITests.utils.APITestsHelper;

import java.io.IOException;

import static tests.basicGUITests.utils.Constants.contactAPIURL;
import static tests.basicGUITests.utils.Constants.loginAPIUrl;

public class CommonAPISteps extends APITestsHelper implements En {
    private HttpPost postRequest;
    private CloseableHttpResponse response;

    public CommonAPISteps() {
        //common step to build the client and receive token
        // instance variable token exists in APITestsHelper class
        Given("I have access token", () -> {
            client = buildClient();
            postRequest = new HttpPost(loginAPIUrl);
            try {
                postRequest.setEntity(new StringEntity(createUser(), ContentType.APPLICATION_JSON));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                response = client.execute(postRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                token = response.getHeader("Access-Token");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
        });

        // common step to create a contact before working with it.
        // contact data assigned to the existingContact instance variable
        Given("I have existing contact", () -> {
            try {
                existingContact = createRandomContact();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            postRequest = new HttpPost(contactAPIURL);
            postRequest.addHeader(token);
            postRequest.setEntity(new StringEntity(existingContact.toString(), ContentType.APPLICATION_JSON));
            try {
                response = client.execute(postRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
