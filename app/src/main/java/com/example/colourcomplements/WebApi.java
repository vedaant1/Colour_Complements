package com.example.colourcomplements;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebApi {

    private static HttpURLConnection connection;

    public static String getComplement(int r, int g, int b) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("http://thecolorapi.com/scheme?rgb=rgb("+r+","+g+","+b+")&mode=complement&count=1");
            connection = (HttpURLConnection) url.openConnection();

            //Request setup method
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status != 200) {
                return String.valueOf(-1);
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
                return parse(responseContent.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }

    public static String parse(String responseBody) throws JSONException {
        JSONObject object = new JSONObject(responseBody);
        JSONObject hex = object.getJSONObject("hex");
        String hexValue = hex.getString("value");
        return hexValue;
    }
}
