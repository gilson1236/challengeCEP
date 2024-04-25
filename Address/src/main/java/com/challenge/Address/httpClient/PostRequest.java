package com.challenge.Address.httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest {
    public static final String URL_POST = "http://localhost:8080/api/cep/v1";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder().build();

        // Construindo a URI da API REST

        URI uri = URI.create(URL_POST);

        // Criando o corpo da solicitação POST

        String requestBody = "{\"cep\": \"54440570\", \"state\": \"PE\", \"city\": \"Jaboatão\", " +
                "\"neighborhood\": \"Candeias\", \"street\": \"Avenida Ulisses Montarroyos\", \"service\": \"correios-alt\" }";

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

        /*
        // cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        System.out.println(request.bodyPublisher());

         */
    }
}
