package com.alura.conversordemonedas.modelos;

import com.alura.conversordemonedas.calculos.Conversion;
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
    //Petición con 3 argumentos:
    //codigoBase es el código de moneda base que se quiere convertir (String)
    //codigoSecundario es el código de la tasa a usar para convertir la moneda base (String)
    //monto es la cantidad de dinero a convertir (Double)
    //Ej: code: "USD", rate: "ARS" ->> convertimos de dolares a pesos argentinos.
    public void httpRequest(String codigoBase, String codigoSecundario, Double monto) {
        String URL = "https://v6.exchangerate-api.com/v6/5773049a97300cadc8ddc5e7/latest/" + codigoBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            //System.out.println(response.body());
            Moneda moneda = gson.fromJson(json, Moneda.class);
            Conversion convertir = new Conversion();
            //System.out.println(moneda.toString());
            Double tasa = moneda.getRate(codigoSecundario);
            Double resultado = convertir.convertirMoneda(tasa, monto);
            System.out.println(String.format("la conversión de $USD %f a Pesos argentinos es = $ARS %f", monto, resultado));
            System.out.println("Tasa de conversión = " + tasa);
            System.out.println("última actualización = " + moneda.getTime_last_update_utc());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
