package br.com.eduardo_asafe.nuggets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


public class StreamAPI_Live {

    @RequiredArgsConstructor
    @Getter
    static class CarroDTO {
        private final String cor;
        private final Long preco;
        private final String marca;
        private final String modelo;

        @Override
        public String toString() {
            return "CarroDTO{" +
                    "cor='" + cor + '\'' +
                    ", preco=" + preco +
                    ", marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    '}';
        }
    }

    @RequiredArgsConstructor
    @Getter
    static class EsportivoDTO {
        private final String cor;
        private final Long preco;
        private final String marca;
        private final String modelo;

        @Override
        public String toString() {
            return "EsportivoDTO{" +
                    "cor='" + cor + '\'' +
                    ", preco=" + preco +
                    ", marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    '}';
        }
    }

    /**
     *                                                       STREAM - Visão geral
     *
     *
     * SOURCE - FONTE DE DADOS (Apenas uma)
     * PIPELINE - Operações intermediarias (várias)
     * TERMINAL - Collectors (apenas uma)
     *
     *
     */

    public static void main(String[] args) {
        List<CarroDTO> data = List.of(
                new CarroDTO("Vermelho", 84_000L, "Fiat", "Uno"),
                new CarroDTO("Amarelo", 560_000L, "Chevrolet", "Camaro"),
                new CarroDTO("Cinza", 150_000L, "Volvo", "Xc60"),
                new CarroDTO("Prata", 40_000L, "Chevrolet", "Astra"),
                new CarroDTO("Preto", 330_000L, "Audi", "a4"),
                new CarroDTO("Preto", 400_000L, "BYD", "Song"),
                new CarroDTO("Cinza", 1_800_000L, "Tesla", "Truck"),
                new CarroDTO("Branco", 300_000L, "Chevrolet", "S10"),
                new CarroDTO("Preto", 430_000L, "VW", "Golf TI"),
                new CarroDTO("Preto", 200_000L, "Toyota", "Corolla")
        );

        CarroDTO bmw = new CarroDTO("Azul", 645_000L, "BMW", "X4");
        CarroDTO civic = new CarroDTO("Branco", 265_000L, "Honda", "Civic");

        System.out.println(data.size());

        // Fonte de dados imútavel
        // A operação só será executada após a invocação da operação terminal

        Optional<CarroDTO> carroBYD = data
                .stream() // FONTE DADOS
                .filter(dto -> "BYD".equalsIgnoreCase(dto.getMarca()) && "Song".equalsIgnoreCase(dto.getModelo())) // OPERAÇÔES INTERMERDIARIAS
                .findAny(); // OPERAÇÂO TERMINAL

        carroBYD.ifPresent(System.out::println);

        // Criando streams a partir do "zero"
        Stream<CarroDTO> carrosEx1 = Arrays.stream(new CarroDTO[]{bmw, civic});
        Stream<CarroDTO> carrosEx2 = Stream.of(bmw, civic);

        // Quantos carros estão acima de 100 mil reais?
        long qtdCarrosAcima100k = data
                .stream()
                .mapToLong(CarroDTO::getPreco)
                .filter(valor -> valor > 100_000L)
                .count();
        System.out.println(qtdCarrosAcima100k);

        // Converta para mim os valores dos carros para dolar
        double cotacaoDolar =  5.52;

        DoubleStream valoresEmDolar = data.stream().mapToDouble(carro -> carro.getPreco() / cotacaoDolar);
        System.out.println(valoresEmDolar.sum());

        // Filtre todos os carros pela cor preta
        List<CarroDTO> carrosPretos = data
                .stream()
                .filter(carro -> "PRETO".equalsIgnoreCase(carro.getCor()))
                .collect(Collectors.toList());

        carrosPretos.forEach(System.out::println);

        // Printe apenas os nomes dos carros
        List<String> nomesCarros = data.stream()
                .map(carroDTO -> carroDTO.getModelo())
                .collect(Collectors.toList());
        System.out.println(nomesCarros);

        // transformando para outros tipos
        List<EsportivoDTO> esportivoDTOS= data.stream()
                .filter(carroDTO -> carroDTO.getModelo().equalsIgnoreCase("a4") || carroDTO.getModelo().equalsIgnoreCase("camaro"))
                .map(dto -> new EsportivoDTO(dto.getCor(), dto.getPreco(), dto.getMarca(), dto.getModelo()))
                .collect(Collectors.toList());

        System.out.println(esportivoDTOS);

        // ordernar - moderna
        List<CarroDTO> dataOrdenada = data.stream()
                //.sorted(Comparator.comparing(CarroDTO::getPreco))
                .sorted(Comparator.comparing(CarroDTO::getPreco).reversed())
                .collect(Collectors.toList());
        System.out.println(dataOrdenada);

        // ordernar - classica
        List<CarroDTO> dataOrdenadaClasica = data.stream()
                //.sorted(Comparator.comparing(CarroDTO::getPreco))
                .sorted(new Comparator<CarroDTO>() {
                    @Override
                    public int compare(CarroDTO o1, CarroDTO o2) {
                        return o1.getPreco().compareTo(o2.getPreco());
                    }
                })
                .collect(Collectors.toList());
        System.out.println(dataOrdenadaClasica);

        // Limitações
        System.out.println(data.stream().limit(2).collect(Collectors.toList()));
        System.out.println(data.stream().skip(8).collect(Collectors.toList()));

        // Debugging
        System.out.println("\n\n\n\n");
        System.out.println("INICIO DEBUGGING");
        List<EsportivoDTO> esportivoDebugging = data.stream()
                .limit(2)
                .peek(System.out::println)
                .filter(carroDTO -> "Camaro".equalsIgnoreCase(carroDTO.getModelo()))
                .map(dto -> new EsportivoDTO(dto.getCor(), dto.getPreco(), dto.getMarca(), dto.getModelo()))
                .peek(System.out::println)
                .toList();
        System.out.println("FIM DEBUGGING");
        System.out.println(esportivoDebugging);
        System.out.println("\n\n\n\n");

        // OPERAÇÕES TERMINAIS

        // Iterando pela lista
        data.forEach(System.out::println);

        // count
        System.out.println(data.stream().count());

        //operação terminal pelo máximo
        System.out.println(data.stream().collect(Collectors.maxBy(Comparator.comparing(CarroDTO::getPreco))));

        // Existe um fiat uno na minha listagem?
        System.out.println(data.stream().anyMatch(carroDTO -> "Uno".equalsIgnoreCase(carroDTO.getModelo())));

        // Todos os carros da minha listagem são vermelhos?
        System.out.println(data.stream().allMatch(carroDTO -> "Vermelho".equalsIgnoreCase(carroDTO.getCor())));

        // Traga apenas o fiat uno
        System.out.println(data.stream().filter(dto -> "a4".equalsIgnoreCase(dto.getModelo())).findFirst());

        // Traga qualquer carro da cor vermelha
        System.out.println(data.stream().filter(dto -> "Preto".equalsIgnoreCase(dto.getCor())).findAny());


    }
}
