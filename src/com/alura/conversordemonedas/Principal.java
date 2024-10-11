package com.alura.conversordemonedas;

import com.alura.conversordemonedas.modelos.GetData;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //inicializamos la clase Scanner
        Scanner lectura = new Scanner(System.in);
        //inicializamos la clase GetData
        GetData peticion = new GetData();
    String busqueda = "1";
    //Loop del menu si la elección es distinta de "0"
    while(!busqueda.equals("0")){
        System.out.println("***********************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("***********************************");
        System.out.println("Seleccione la conversión que desea realizar");
        System.out.println("1 - Dólar =>> Peso argentino");
        System.out.println("2 - Peso argentino =>> Dólar");
        System.out.println("3 - Dólar =>> Real brasileño");
        System.out.println("4 - Real brasileño =>> Dólar");
        System.out.println("5 - Dólar =>> Peso colombiano");
        System.out.println("6 - Peso colombiano =>> Dólar");
        System.out.println("0 - Salir");
        System.out.println("***********************************");
        busqueda = lectura.nextLine();

        switch (busqueda){
            case "1":
                peticion.httpRequest("USD");

                break;
        }

    }
    }
}
