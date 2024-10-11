package com.alura.conversordemonedas.calculos;

public class Conversion {
    private Double tasa;
    private Double resultadoConversion;

    public Conversion() {
    }
    public Double convertirMoneda(Double tasa, Double monto){
        Double resultado = monto * tasa;
        return resultado;
    }
    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }

    public Double getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(Double resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }
}
