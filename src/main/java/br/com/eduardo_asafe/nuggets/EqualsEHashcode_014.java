package br.com.eduardo_asafe.nuggets;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
class Carro {
    private String cor;
    private Long preco;

    /**
     *
     * 1. Compare se as instancias são iguais. (endereço de memoria lógico)
     * 2. Compare se são da mesma tipo.
     * 3. Compare se os atributos são iguais.
     *
     * Reflexivo, Simetrico, Transitivo, Consistente.
     *
     *
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // reflexivoq
        if (o == null || getClass() != o.getClass()) return false; // não-nulo e do mesmo tipo
        Carro carro = (Carro) o;
        return Objects.equals(cor, carro.cor) &&
                Objects.equals(preco, carro.preco); // comparação de atributos
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor, preco); // consistente com equals
    }
}

public class EqualsEHashcode_014 {

    public static void main(String[] args) {
        Carro carro1 = new Carro("Vermelho", 200000L);
        Carro carro2 = new Carro("Preto", 1200000L);
        Carro carro3 = new Carro("Vermelho", 200000L);
        Carro carro4 = carro1;

        System.out.println("CARRO é igual a classe Object? " + carro1.equals(new Object()));
        System.out.println("CARRO é igual a classe String? " + carro1.equals(new String()));
        System.out.println("Carro vermelho é igual a Carro preto? " + carro1.equals(carro2));
        System.out.println("Carro vermelho é igual a Carro Vermelho? " + carro1.equals(carro3));
        System.out.println("Carro vermelho é igual a mesma instancia " + carro1.equals(carro4));

    }

}
