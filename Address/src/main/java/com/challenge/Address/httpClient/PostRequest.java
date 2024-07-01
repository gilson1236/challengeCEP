package com.challenge.Address.httpClient;

import com.challenge.Address.dto.CepDTO;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PostRequest {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder().build();

        Scanner scanner = new Scanner(System.in);
        String cepCode, state, city, neighborhood, street, service, url;

        System.out.println("Entre com os dados referente a um cep...");
        System.out.println("Digite um cep que vc deseja inserir: (apenas números)");
        cepCode = scanner.nextLine();
        System.out.println("Agora digite uma UF cep que vc deseja:");
        state = scanner.nextLine();
        System.out.println("Agora digite uma cidade:");
        city = scanner.nextLine();
        System.out.println("Agora digite uma vizinhança vc deseja:");
        neighborhood = scanner.nextLine();
        System.out.println("Agora digite uma rua que vc deseja:");
        street = scanner.nextLine();
        System.out.println("E finalmente digite o serviço postal que você deseja:");
        service = scanner.nextLine();

        url = "http://localhost:8080/api/cep/v1";

        URI uri = URI.create(url);

        CepDTO cepDTO = new CepDTO(cepCode, state, city, neighborhood, street, service);

        // Transformando o objeto criado em formato json
        Gson gson = new Gson();
        //String json = gson.toJson(cepDTO);


        // Criando o corpo da solicitação POST
        HttpRequest httpRequest = getHttpRequest(uri, gson, cepDTO);

        try {
            // Enviando a solicitação
                HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Obtendo a resposta da requisição
                int statusCode = response.statusCode();
                String responseBody = response.body();

            // Exibindo a resposta final
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
            System.out.println(toJson(gson, cepDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String toJson(Gson gson, CepDTO cep){
        return gson.toJson(cep);
    }

    private static HttpRequest getHttpRequest(URI uri, Gson gson, CepDTO cep){
        return HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(toJson(gson, cep)))
                .build();
    }
}
