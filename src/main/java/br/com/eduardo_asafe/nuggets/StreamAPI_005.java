package br.com.eduardo_asafe.nuggets;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI_005 {

    @RequiredArgsConstructor
    @Getter
    @ToString
    static class CarroDTO {
        private final String cor;
        private final Long preco;
        private final String marca;

    }



    public static void main(String[] args) {
        List<CarroDTO> data = List.of(
                new CarroDTO("Vermelho", 80L, "Fiat"),
                new CarroDTO("Amarelo", 500L, "Camaro"),
                new CarroDTO("Cinza", 150L, "Volvo"),
                new CarroDTO("Prata", 60L, "Astra"),
                new CarroDTO("Preto", 220L, "Audi")
        );

        List<String> marcas = data.stream()
                .peek(System.out::println) // spy
                .map(carroDTO -> carroDTO.getMarca()) // transform
                .filter("Astra"::equalsIgnoreCase) // filter
                .collect(Collectors.toList()); //forEach

        System.out.println(marcas);


    }
}
