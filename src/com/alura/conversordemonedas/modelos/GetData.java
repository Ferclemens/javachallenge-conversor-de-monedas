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
import java.text.DecimalFormat;

public class GetData {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    //Incializamos el formateador para dos decimales
    DecimalFormat df = new DecimalFormat("#.00");
    public GetData() {
    }
    //Petición con 3 argumentos:
    //codigoBase es el código de moneda base que se quiere convertir (String)
    //codigoSecundario es el código de la tasa a usar para convertir la moneda base (String)
    //monto es la cantidad de dinero a convertir (Double)
    //Ej: codigoBase: "USD", codigoSecundario: "ARS", monto: 10 ->> convertimos 10 dolares a pesos argentinos.
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
            //Formatos para imprimir
            String resultadoFormateado = df.format(resultado);
            String montoFormateado = df.format(monto);
            String fechaFormateada = moneda.getTime_last_update_utc().substring(5, 16);
            //Imprimir resultados
            System.out.println("----------------------------------------------------------");
            System.out.println(String.format("- la conversión de $%s %s a $%s es = $%s %s",codigoBase, montoFormateado, codigoSecundario, codigoSecundario,resultadoFormateado));
            System.out.println(String.format("- Tasa de conversión %s = $ %s",codigoSecundario,tasa));
            System.out.println("- última actualización = " + fechaFormateada);
            System.out.println("----------------------------------------------------------");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
