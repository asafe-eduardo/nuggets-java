package br.com.eduardo_asafe.nuggets;


class Pai {

}
class Filho extends Pai {

}
public class MetodosSobrecarregadosENull_009 {

    public static void teste(Object teste){
        System.out.println("Caiu em Object!");
    }

    public static void teste(Pai teste){
        System.out.println("Caiu em Pai!");
    }

    public static void teste(String teste){
        System.out.println("Caiu em String!");
    }

    public static void teste(Long teste){
        System.out.println("Caiu em Long!");
    }

    public static void teste(Integer teste){
        System.out.println("Caiu em Integer!");
    }

    public static void teste(int teste){
        System.out.println("Caiu no primitivo int!");
    }

    public static void teste(char teste){
        System.out.println("Caiu no primitivo char!");
    }

    public static void teste(Double teste){
        System.out.println("Caiu em Double!");
    }


    public static void main(String[] args) {
        short x = 1;

        // Objeto
        teste(new Object());
        // Teste
        teste("teste");
        // Long
        teste(1L);
        // Short (a) - Compila? (b) - Erro em Execução? (c) - printa Long? (d) - Printa Integer? (f) - Printa char?
        teste(x);
        // Double
        teste(1D);
        // Null (a) - Compila? (b) - Erro em Execução? (c) - printa null?
        //teste(null);

        // Classe filho (a)- Compila? (b) - Erro em Execução? (c) - caiu em object (d) - caiu em pai
        Filho teste = null;
        teste(teste);


        /**
         *
         * | Byte
         * 	|-> Short
         * 	| -> Character
         * 		| -> Integer
         * 			| -> Long
         * 				| -> Float
         * 					| -> Double
         * 						| -> Object
         */

    }

}
