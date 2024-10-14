package com.alura.conversordemonedas;

import com.alura.conversordemonedas.modelos.GetData;
import com.alura.conversordemonedas.modelos.Moneda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //inicializamos la clase Scanner
        Scanner lectura = new Scanner(System.in);
        //inicializamos la clase GetData
        GetData peticion = new GetData();

        //variables del menu
        String busqueda = "1";
        Double monto = 0.0;
        String nuevaConversion = "";
        List<String> opcionesMenu = new ArrayList<>();
        opcionesMenu.add("1");
        opcionesMenu.add("2");
        opcionesMenu.add("3");
        opcionesMenu.add("4");
        opcionesMenu.add("5");
        opcionesMenu.add("6");
        opcionesMenu.add("0");


        System.out.println("**********************************************************");
        System.out.println("Bienvenido al conversor de monedas SystemOUTPrint-3000");
        System.out.println("**********************************************************");
        //Loop del menu si la elección es distinta de "0"
        while(!busqueda.equals("0")){
            if (monto == 0.0) {
                System.out.println("Ingrese el monto que desea convertir");
                try {
                    monto = Double.valueOf(lectura.nextLine());
                    if (monto <= 0.0) {
                        System.out.println("Ingrese sólo valores numéricos positivos");
                        monto = Double.valueOf(lectura.nextLine());
                    }
                } catch (NumberFormatException e){
                    System.out.println("Ingrese sólo valores numéricos positivos");
                    monto = Double.valueOf(lectura.nextLine());
                    if (monto <= 0.0) {
                        System.out.println("Ingrese sólo valores numéricos positivos");
                        monto = Double.valueOf(lectura.nextLine());
                    }
                }
            }
            System.out.println("**********************************************************");
            System.out.println("Seleccione la conversión que desea realizar o 0 para salir");
            System.out.println("1 - Dólar =>> Peso argentino");
            System.out.println("2 - Peso argentino =>> Dólar");
            System.out.println("3 - Dólar =>> Real brasileño");
            System.out.println("4 - Real brasileño =>> Dólar");
            System.out.println("5 - Dólar =>> Peso colombiano");
            System.out.println("6 - Peso colombiano =>> Dólar");
            System.out.println("0 - Salir");
            System.out.println("**********************************************************");
            busqueda = lectura.nextLine();
            while(!opcionesMenu.contains(busqueda)){
                System.out.println("----------------------------------------------------------");
                System.out.println("- Seleccione una de las opciones de la lista");
                System.out.println("----------------------------------------------------------");
                System.out.println("1 - Dólar =>> Peso argentino");
                System.out.println("2 - Peso argentino =>> Dólar");
                System.out.println("3 - Dólar =>> Real brasileño");
                System.out.println("4 - Real brasileño =>> Dólar");
                System.out.println("5 - Dólar =>> Peso colombiano");
                System.out.println("6 - Peso colombiano =>> Dólar");
                System.out.println("0 - Salir");
                System.out.println("----------------------------------------------------------");
                busqueda = lectura.nextLine();
            }

            switch (busqueda){
                case "1":
                    peticion.httpRequest("USD", "ARS", monto);
                    break;
                case "2":
                    peticion.httpRequest("ARS", "USD", monto);
                    break;
                case "3":
                    peticion.httpRequest("USD", "BRL", monto);
                    break;
                case "4":
                    peticion.httpRequest("BRL", "USD", monto);
                    break;
                case "5":
                    peticion.httpRequest("USD", "COP", monto);
                    break;
                case "6":
                    peticion.httpRequest("COP", "USD", monto);
                    break;
                case "0":
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Muchas gracias por usar el conversor de monedas SystemOUTPrint-3000");
                    System.out.println("-------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("- Seleccione una de las opciones de la lista");
                    System.out.println("----------------------------------------------------------");
            }
            while(!nuevaConversion.equals("1") || !nuevaConversion.equals("2")){
                System.out.println("**********************************************************");
                System.out.println("Desea realizar otra conversión? \n1- SI \n2- NO");
                System.out.println("**********************************************************");
                nuevaConversion = lectura.nextLine();
                if(nuevaConversion.equals("1")){
                    monto = 0.0;
                    nuevaConversion = "";
                    break;
                } else if (nuevaConversion.equals("2")) {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Muchas gracias por usar el conversor de monedas SystemOUTPrint-3000");
                    System.out.println("-------------------------------------------------------------------");
                    busqueda = "0";
                    break;
                } else {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("- Seleccione una de las opciones de la lista");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("**********************************************************");
                    System.out.println("Desea realizar otra conversión? \n1- SI \n2- NO");
                    System.out.println("**********************************************************");
                    nuevaConversion = lectura.nextLine();
                }
            }

        }
    }
}
