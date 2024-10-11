package com.alura.conversordemonedas.modelos;

import java.util.HashMap;

public class Moneda {
    private String base_code;
    private String time_last_update_utc;
    private HashMap<String, Double> conversion_rates;
}
