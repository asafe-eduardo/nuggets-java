package br.com.eduardo_asafe.nuggets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bigdecimal_002 {

    public static void main(String[] args) {

        /**
         * COMO REPRESENTAR R$ 1.500.232,38 * PI
         */
        Long dinheirolong = 1523238L * 3;
        Double dinheiroDouble = 1523238D * 3.14;
        BigDecimal dinheiroBigdecimal = BigDecimal.valueOf(1523238L).multiply(new BigDecimal("3.14")).setScale(1, RoundingMode.HALF_UP);

        System.out.println("=============== LONG =====================");
        System.out.println(dinheirolong);
        System.out.println("=============== DOUBLE ==================");
        System.out.println(dinheiroDouble);
        System.out.println("=============== BIG DECIMAL ==================");
        System.out.println(dinheiroBigdecimal);

    }

}
