package br.com.eduardo_asafe.nuggets;

import java.util.HashMap;
import java.util.Map;

public class ChaveEValor {
    public static void main(String[] args) {
        Map<String, Integer> estoque = new HashMap<String, Integer>();
        estoque.put("Notebook", 10);
        estoque.put("Mouse", 50);

        System.out.println(estoque.get("Notebook"));

        estoque.put("Notebook", 20);
        System.out.println(estoque.get("Notebook"));

    }
}
