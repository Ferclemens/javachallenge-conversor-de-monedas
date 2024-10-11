package com.alura.conversordemonedas.modelos;

import java.util.HashMap;

public class Moneda {
    private String base_code;
    private String time_last_update_utc;
    private HashMap<String, Double> conversion_rates;

    public Moneda() {
    }
    //función para obtener la tasa de conversión (double) según el código de moneda pasado como argumento.
    public Double getRate(String code){
        Double rate = conversion_rates.get(code);
        return rate;
    }
    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public HashMap<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(HashMap<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "base_code='" + base_code + '\'' +
                ", time_last_update_utc='" + time_last_update_utc + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
