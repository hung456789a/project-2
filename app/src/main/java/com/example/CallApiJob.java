package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallApiJob {
    public static void main(String[] args) {
        try {
            String urlString = "https://api.open-meteo.com/v1/forecast?latitude=10.76&longitude=106.66&current_weather=true";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            System.out.println("Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println("Response Body:");
                System.out.println(response.toString());
            } else {
                System.out.println("GET request failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
