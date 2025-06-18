package br.com.eduardo_asafe.nuggets;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
class Jogador implements Comparable<Jogador> {
    private final String nome;
    private final Integer camisa;
    private final String posicao;

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", camisa=" + camisa +
                ", posicao='" + posicao + '\'' +
                '}';
    }

    @Override
    public int compareTo(Jogador o) {
        if("GOL".equalsIgnoreCase(o.posicao)){
            return -1;
        } else if("ZA".equalsIgnoreCase(o.posicao)){
            return -1;
        } else if("ME".equalsIgnoreCase(o.posicao)){
            return 0;
        } else if("AT".equalsIgnoreCase(o.posicao)){
            return 1;
        }
        return -1;
    }
}

class JogadorCamisaComparator implements Comparator<Jogador> {

    @Override
    public int compare(Jogador o1, Jogador o2) {
        return Integer.compare(o1.getCamisa(), o2.getCamisa());
    }
}
public class Comparable_008 {

    public static void main(String[] args) {
        Jogador neymar = new Jogador("Neymar", 10, "AT");
        Jogador alisson = new Jogador("Alisson", 1, "GOL");
        Jogador alexsandro = new Jogador("Alexsandro", 2, "ZA");
        Jogador vini = new Jogador("Vini JR", 11, "AT");
        Jogador bruno = new Jogador("Bruno Guimarães", 6, "ME");

        List<Jogador> lista = Arrays.asList(neymar, alisson, alexsandro, vini, bruno);

        // ===========================  COMPARABLE ===============================

        Collections.sort(lista);
        System.out.println(lista);

        // ===========================  COMPARATOR ===============================
        JogadorCamisaComparator comparator = new JogadorCamisaComparator();
        Collections.sort(lista, comparator);
        System.out.println("");
        System.out.println(lista);

    }
}
