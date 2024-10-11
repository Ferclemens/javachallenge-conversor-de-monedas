package com.alura.conversordemonedas.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetData {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public GetData() {
    }

    public void httpRequest(String tipoMoneda) {
        String URL = "https://v6.exchangerate-api.com/v6/5773049a97300cadc8ddc5e7/latest/" + tipoMoneda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(response.body());
            //Moneda moneda = gson.fromJson(json, Moneda.class);
            //System.out.println(moneda.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
