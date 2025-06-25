package br.com.eduardo_asafe.nuggets;


enum Semana {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO
}
public class SwitchEnhaced_009 {

    public static void main(String[] args) {
        Semana dia = Semana.DOMINGO;

        // SWITCH TRADICIONAL
//        switch (dia) {
//            case SEGUNDA:
//            case SEXTA:
//            case DOMINGO:
//                System.out.println(6);
//                break;
//            case TERCA:
//                System.out.println(7);
//                break;
//            case QUINTA:
//            case SABADO:
//                System.out.println(8);
//                break;
//            case QUARTA:
//                System.out.println(9);
//                break;
//        }

        // SWITCH TRADICIONAL  JDK 14+
        switch (dia) {
            case SEGUNDA, SEXTA, DOMINGO -> System.out.println(6);
            case TERCA -> System.out.println(7);
            case QUINTA, SABADO -> System.out.println(8);
            case QUARTA -> System.out.println(9);
        }



    }
}
