package tests.basicGUITests.utils;

import com.github.javafaker.Faker;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class APITestsHelper {
    protected static Header token;
    protected static CloseableHttpClient client;
    protected static JSONObject existingContact;
    private Faker faker = new Faker();

    protected APITestsHelper() {
    }

    //build the client
    protected CloseableHttpClient buildClient() {
        return HttpClientBuilder.create().build();
    }

    //create user using hard-coded credentials
    protected String createUser() throws JSONException {
        return new JSONObject()
                .put("email", "test111@gmail.com")
                .put("password", "12345678").toString();
    }

    //create random contact using Faker
    protected JSONObject createRandomContact() throws JSONException {
        return new JSONObject()
                .put("id", faker.random().nextInt(100))
                .put("firstName", faker.name().firstName())
                .put("lastName", faker.name().lastName())
                .put("decription", faker.shakespeare().asYouLikeItQuote());
    }

    //get response entity
    protected String getResponseEntity(HttpResponse response) throws IOException, ParseException {
        HttpEntity entity = ((CloseableHttpResponse) response).getEntity();
        return EntityUtils.toString(entity, "UTF-8");
    }
}
