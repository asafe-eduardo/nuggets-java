package br.com.eduardo_asafe.nuggets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Data
class Produto {
    private int id;
    private String title;
    private double price;
}

@Data
class RetornoRequest {
    private List<Produto> products;
    private long total;
    private int skip;
    private int limit;
}

public class RestTemplate_013 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // código compilavel na versão JDK 11+
        // https://dummyjson.com/products?limit=10&skip=10&select=title,price

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products?limit=10&skip=10&select=title,price"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            RetornoRequest retornoRequest = mapper.readValue(response.body(), RetornoRequest.class);
            retornoRequest.getProducts().forEach(System.out::println);
        } else {
            System.err.println("Erro na requisição: " + response.statusCode());
        }
    }
}
