package pl.gregrad.isslocator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JsonConnector {
    public static JsonObject jsonConnector(String jUrl) throws IOException {
        JsonObject jsonObject = new JsonObject();
        try {
            URL url = new URL(jUrl);
            URLConnection req = url.openConnection();
            req.connect();

            JsonParser json = new JsonParser();
            JsonElement jElement = json.parse(new InputStreamReader((InputStream) req.getContent()));
            JsonObject jObj = jElement.getAsJsonObject();
            jsonObject = jObj;
        } catch (MalformedURLException mue) {
            System.out.println("Błędny adres url");
            mue.printStackTrace();
        }
        return jsonObject;
    }

}
