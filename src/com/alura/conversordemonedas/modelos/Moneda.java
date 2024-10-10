package com.alura.conversordemonedas.modelos;

public class Moneda {
    private String nombre;
    private float precio;
    private String lastUpdate;

    public Moneda(String nombre, float precio, String lastUpdate) {
        this.nombre = nombre;
        this.precio = precio;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
