package br.com.eduardo_asafe.nuggets;

public class TiricaNome {

    public static void main(String[] args) {
        Menino menino = new Menino();
        menino.nome = "José";
        menino.gostouNome = true;

        if (!menino.gostouNome) {
            throw new VaiApanharException();
        } else {
            System.out.println("Zé sim mamãe");
            System.out.println("Zé sim mamãe");
            System.out.println("Meu nome é " + menino.nome + ", Zé");
            System.out.println("Nome lindo, Zé, gostei mamae");
        }
    }
}

class Menino {
    String nome;
    boolean gostouNome;
}

class VaiApanharException extends RuntimeException {

    public VaiApanharException() {
        super("Você não gostou do nome? Vai apanhar!");
    }
}
