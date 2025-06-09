package br.com.eduardo_asafe.nuggets;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap_006 {

    public static void main(String[] args) {
        Map<String, Integer> mapNaoOrdenado = Map.of("Z", 1, "C", 10, "B", 99, "H", 38);

        TreeMap<String, Integer> mapOrdenado = new TreeMap<>(mapNaoOrdenado);

        System.out.println("MAP NAO ORDENADO" + mapNaoOrdenado);
        System.out.println("==========================================");
        System.out.println("MAP ORDENADO" + mapOrdenado);

    }
}
