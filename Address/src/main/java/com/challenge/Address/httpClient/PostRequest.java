package com.challenge.Address.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PostRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder().build();

        String url;

        url = "http://localhost:8080/api/cep/v1";

        URI uri = URI.create(url);

        // Criando o corpo da solicitação POST
        String requestBody = "{\"cep\": \"51030420\", \"state\": \"PE\", \"city\": \"Recife\", " +
                "\"neighborhood\": \"Boa Viagem\", \"street\": \"Rua Capitão Zuzinha\", \"service\": \"correios-alt\" }";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            // Enviando a solicitação
                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Obtendo a resposta
                int statusCode = response.statusCode();
                String responseBody = response.body();

            // Exibindo a resposta
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
