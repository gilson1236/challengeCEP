package com.challenge.Address.httpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        try{

            HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/api/cep/v1/54440570"))
                .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String formattedJson = prettyPrintJsonUsing(response.body());

            System.out.println(response.statusCode());
            System.out.println(formattedJson);

        }catch(Exception e){
            e.printStackTrace();
        }

}

    private static String prettyPrintJsonUsing(String jsonUgglyFormatted) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(jsonUgglyFormatted);
        return gson.toJson(jsonElement);
    }

}
