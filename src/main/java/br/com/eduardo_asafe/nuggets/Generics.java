package br.com.eduardo_asafe.nuggets;

import java.util.ArrayList;
import java.util.List;

// Classe genérica
class Caixa<T> {

    private T valor;

    public void guardar(T valor) {
        this.valor = valor;
    }

    public T obter() {
        return valor;
    }
}

public class Generics {
    public static void main(String[] args) {

        // Generic com String
        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.guardar("Java Ninja");

        String texto = caixaTexto.obter();
        System.out.println(texto);

        // Generic com Integer
        Caixa<Integer> caixaNumero = new Caixa<>();
        caixaNumero.guardar(2026);

        Integer numero = caixaNumero.obter();
        System.out.println(numero);

        // Generic em coleções
        List<String> tecnologias = new ArrayList<>();

        tecnologias.add("Java");
        tecnologias.add("Spring");
        tecnologias.add("Kafka");

        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }
    }
}
