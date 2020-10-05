package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;

public class FunctionalAPITest {

    protected final static Logger LOGGER_API = LogManager.getLogger(FunctionalAPITest.class.getName());

    public static JSONObject getJsonFromResponse(HttpResponse response) throws IOException {  // for getting error/success message from body.
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        if (responseString.equals("")) return new JSONObject().put("!---Response string---", "---is empty---!");
        if (responseString.startsWith("[{")) return new JSONObject().put("!---Response string---", "---is Array---!");
        return new JSONObject(responseString);

    }
}
