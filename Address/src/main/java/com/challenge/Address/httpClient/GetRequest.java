package com.challenge.Address.httpClient;

import com.challenge.Address.exceptions.RecordNotFoundException;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class GetRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String codigoCep, uri;

        System.out.println("Digite um cep que vc deseja pesquisar: (apenas números)");

        codigoCep = scanner.next();
        uri = "http://localhost:8080/api/cep/v1/" + codigoCep;

        try {

            HttpRequest request = getHttpRequest(uri);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String formattedJson = prettyPrintJsonUsing(response.body());

            if (formattedJson != null) {
                System.out.println(response.statusCode());
            }
            System.out.println(response.statusCode());
            System.out.println(formattedJson);

        } catch(JsonSyntaxException jsonSyntaxException){
            throw new RecordNotFoundException("Registro não Encontrado!");
        } catch(Exception e){
            e.printStackTrace();
        }

}

    private static HttpRequest getHttpRequest(String uri){
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();
    }

    private static String prettyPrintJsonUsing(String jsonUgglyFormatted) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(jsonUgglyFormatted);
        return gson.toJson(jsonElement);
    }

}
