package br.com.eduardo_asafe.nuggets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Datas_localdate_012 {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        System.out.println("PADRÃO: ");
        System.out.println(hoje);

        // Java 8+
        System.out.println("");
        System.out.println("");
        //Sempre prestar atenção ao timezone e localidade
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        System.out.println("Em pt-BR: ");
        System.out.println(hoje.format(dateTimeFormatter));

    }
}
