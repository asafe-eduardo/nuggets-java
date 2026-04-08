package br.com.eduardo_asafe.nuggets;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

        // SEM TIMEZONE
        System.out.print("\n\n");
        System.out.print("LOCAL DATE TIME: ");
        DateTimeFormatter ft1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(LocalDateTime.now().format(ft1));


        // ZONEDDATETIME
        System.out.print("\n\n");
        System.out.print("ZONED DATE TIME: ");
        ZonedDateTime americaSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println(americaSaoPaulo.format(ft1));

    }
}
