package br.com.eduardo_asafe.nuggets;



class Teste extends Object {

    private String teste;

    public Teste(String teste) {
        this.teste = teste;
    }

    @Override
    public String toString() {
        return "valor=" + this.teste;
    }
}

class Teste2 extends Object {
    private String teste;

    public Teste2(String teste) {
        this.teste = teste;
    }
}

public class ToString_011 {

    public static void main(String[] args) {
        System.out.println(new Teste("valor1"));
        System.out.println(new Teste2("valor2"));
    }
}
