package br.com.eduardo_asafe.nuggets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamAPI_Live_Roteiro {

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
                new CarroDTO("Branc0", 300_000L, "Chevrolet", "S10"),
                new CarroDTO("Preto", 430_000L, "VW", "Golf TI"),
                new CarroDTO("Preto", 200_000L, "Toyota", "Corolla")
        );

        CarroDTO bmw = new CarroDTO("Azul", 645_000L, "BMW", "X4");
        CarroDTO civic = new CarroDTO("Branco", 265_000L, "Honda", "Civic");


        //Primeiro verificando tamanho da lista
        System.out.println(data.size());

        // Exemplo básico
        // Fonte de dados imútavel
        // A operação só será executado após a invocação de uma operação terminal
        // Horn operator ou lambda operator (->)
        // Method references ::

        Optional<CarroDTO> byd = data // fonte de dados
                .stream() // convertendo para api stream
                .filter(c -> "BYD".equalsIgnoreCase(c.getMarca()) && "Song".equalsIgnoreCase(c.getModelo())) // pipeline
                .findAny(); // terminal

        byd.ifPresent(System.out::println);

        // Criando Streams a partir do "zero"
        Stream<CarroDTO> carrosEx1 = Arrays.stream(new CarroDTO[]{bmw, civic});
        Stream<CarroDTO> carrosEx2 = Stream.of(bmw, civic);

        // Streams para números mais otimizados para operações matematicas
        // mapToLong - LongStream
        // mapToInt - IntStream
        // mapToDouble - DoubleStream

        // Quantos carros existem acima de 100k?
        long quantosCarrosAcimaDe100Mil = data.stream()
                .mapToLong(CarroDTO::getPreco)
                .filter(valor -> valor > 100_000L)
                .count();

        System.out.println(quantosCarrosAcimaDe100Mil);

        // Converta para mim os valores dos carros para dolar
        double cotacaoDolar = 5.41;

        DoubleStream valoresEmDolar = data.stream().mapToDouble(carro -> carro.getPreco() / cotacaoDolar);

        System.out.println(valoresEmDolar.sum());

        // Media de preço dos carros
        OptionalDouble mediaCarrosPremium = data.stream()
                .mapToDouble(CarroDTO::getPreco)
                .average();

        mediaCarrosPremium.ifPresent(System.out::println);

        // Filtragem e Transformações

        //Apenas carros pretos (Filtragem)
        List<CarroDTO> carrosPretos = data.stream().filter(carro -> "PRETO".equalsIgnoreCase(carro.getCor())).collect(Collectors.toList());
        carrosPretos.forEach(System.out::println);

        //Apenas nomes dos carros
        List<String> nomes = data.stream().map(carroDTO -> carroDTO.getModelo()).collect(Collectors.toList());
        System.out.println(nomes);

        //Transformando para outro tipo
        List<EsportivoDTO> esportivos = data.stream()
                .filter(carro -> "Camaro".equalsIgnoreCase(carro.getModelo()) || "a4".equalsIgnoreCase(carro.getModelo())) //pipe
                // .filter(carro -> "a4".equalsIgnoreCase(carro.getModelo())) //pipe (poderia encadear assim também mais cuidado com E lógico)
                .map(carroDTO -> new EsportivoDTO(carroDTO.getCor(), carroDTO.getPreco(), carroDTO.getMarca(), carroDTO.getModelo())) //pipe
                .toList();
        esportivos.forEach(System.out::println);

        // Atuando com listas de listas

        // Trabalhando com lista de listas
        List<CarroDTO> listaFlatted = data.stream()
                .map(carroDTO -> Stream.of(carroDTO))
                .flatMap(carroDTOStream -> carroDTOStream) // remova essa linha e teste o output no system.out
                .collect(Collectors.toList());
        System.out.println(listaFlatted);

        // Ordenação - default do menor para maior
        List<CarroDTO> carrosOrdenadosPorPreco = data.stream()
                .sorted(Comparator.comparing(CarroDTO::getPreco))
                //.sorted(Comparator.comparing(CarroDTO::getPreco).reversed())
                .collect(Collectors.toList());
        System.out.println(carrosOrdenadosPorPreco);

        // Ordenação - clássica
        List<CarroDTO> carrosOrdenadosPorPrecoManual = data.stream()
                .sorted(new Comparator<CarroDTO>() {
                    @Override
                    public int compare(CarroDTO c1, CarroDTO c2) {
                        return c1.getPreco().compareTo(c2.getPreco());
                    }
                })
                // .sorted((c1, c2) -> c1.getPreco().compareTo(c2.getPreco())) - versão moderna
                .collect(Collectors.toList());
        System.out.println(carrosOrdenadosPorPrecoManual);

        // Limitações
        System.out.println(data.stream().limit(2).collect(Collectors.toList()));
        System.out.println(data.stream().skip(8).collect(Collectors.toList()));


        // Debbuging
        System.out.print("\n\n\n\n\n");
        System.out.println("INICIO DO DEBBUGING");
        List<EsportivoDTO> esportivosDebbugado = data.stream()
                .limit(2)
                .peek(System.out::println)
                .filter(carro -> "Camaro".equalsIgnoreCase(carro.getModelo())) //pipe
                .map(carroDTO -> new EsportivoDTO(carroDTO.getCor(), carroDTO.getPreco(), carroDTO.getMarca(), carroDTO.getModelo())) //pipe
                .peek(System.out::println)
                .toList();
        System.out.println("\n\n\n\n SAIDA DO STREAM:");
        esportivosDebbugado.forEach(System.out::println);
        System.out.println("\n\n");

        // OPERAÇÔES TERMINAIS

        // iterando pela lista
        data.forEach(System.out::println);

        // Contando
        System.out.println(data.stream().count());

        //operação terminal por máximo
        System.out.println(data.stream().collect(Collectors.maxBy(Comparator.comparing(CarroDTO::getPreco))));

        //Na minha lista tem um uno?
        System.out.println(data.stream().anyMatch(carroDTO -> "Uno".equalsIgnoreCase(carroDTO.getModelo())));

        //Todos os meus carros são vermelhos?
        System.out.println(data.stream().allMatch(carroDTO -> "Vermelho".equalsIgnoreCase(carroDTO.getCor())));

        //Traga o fiat uno
        System.out.println(data.stream().filter(carroDTO -> "Uno".equalsIgnoreCase(carroDTO.getModelo())).findFirst());

        //Traga qualquer carro vermelho
        System.out.println(data.stream().filter(carroDTO -> "Vermelho".equalsIgnoreCase(carroDTO.getCor())).findAny());


        System.out.println("\n\n\n\n\n NOVO TÓPICO DE INTERFACES");

        // INTERFACES FUNCIONAIS

        // Function - função de transformação - map, toMap, groupingBy
        Function<CarroDTO, String> extrairMarca = c -> c.getMarca();
        System.out.println(data.stream()
                .map(extrairMarca)
                .collect(Collectors.toList()));

        // BiFunction - função de transformação com 2 argumentos - Map.compute e Map.merge
        BiFunction<String, String, String> juntarMarcaModelo = (marca, modelo) -> marca + " " + modelo;
        System.out.println(data.stream()
                .map(c -> juntarMarcaModelo.apply(c.getMarca(), c.modelo))
                .collect(Collectors.toList()));

        // UnaryOperator - função de transformação - normalizações
        UnaryOperator<String> normalizarCor = cor -> cor.trim().toUpperCase();
        System.out.println(data.stream()
                .map(c -> normalizarCor.apply(c.getCor()))
                .collect(Collectors.toList()));

        // Predicate - condição boolean - filter, removerIf, anymatch
        Predicate<CarroDTO> filtroCarroBrancoPredicated = c -> "cinza".equalsIgnoreCase(c.getCor());
        System.out.println(data.stream().filter(filtroCarroBrancoPredicated).collect(Collectors.toList()));
        System.out.println(data.stream().filter(filtroCarroBrancoPredicated.negate()).collect(Collectors.toList()));

        // Consumer - ação de consumo sem retorno - forEach, callbacks
        Consumer<CarroDTO> imprimir = c -> System.out.println(c.getMarca() + " " + c.getModelo() + " -> " + c.getPreco());
        data.stream().forEach(imprimir);

        // Suplier - criar um valor sem argumento
        Supplier<CarroDTO> carroDefault = () -> new CarroDTO("Preto", 0L, "N/A", "N/A");

        CarroDTO subaru = data.stream()
                .filter(c -> "subaru".equalsIgnoreCase(c.getMarca()))
                .findFirst()
                .orElseGet(carroDefault);
        System.out.println(subaru);


        // OPERAÇÔES TERMINAIS v2
        System.out.println("\n\n\n\n OPERAÇÔES TERMINAIS V2");

        // reduce - operação terminal que "reduz" a um único valor - a ideia e acumular os valores em único elemento
        // assinatura T reduce(T identity, BinaryOperator<T> accumulator)
        // identity: valor neutro (elemento identidade) para a operação.
        // accumulator: combina o acumulado com o próximo elemento.
        long total = data.stream()
                .map(CarroDTO::getPreco)              // Stream<Long>
                .reduce(0L, (a, b) -> a + b);         // identity=0L, accumulator=soma
        System.out.println(total);

        String texto = data.stream()
                .map(c -> c.getMarca() + "-" + c.getModelo())
                .reduce("", (acc, s) -> acc + s + "; ");
        System.out.println(texto);

        //reduce - operações terminais que "reduz" - combina resultados parciais
        String resultado = data.stream()
                .reduce(new StringBuilder(),
                        (sb, carro) -> sb.append(carro.getMarca())
                                .append(" ")
                                .append(carro.getModelo())
                                .append(" | "),
                        (sb1, sb2) -> sb1.append(sb2))
                .toString();
        System.out.println(resultado);

        // Reduce X Collect
        // reduce é utilizado para valores imutaveis e operçaões matematicas
        // collectors e para acumulação de estruturas mutáveis e agrupamentos


        //collect - operação terminal que transforma uma stream em uma estrutura final
        Set<CarroDTO> dataSet = data.stream().collect(Collectors.toSet());

        // groupingBy - agrupando por marca - transforma em chave valor
        Map<String, List<CarroDTO>> porMarca = data.stream()
                .collect(Collectors.groupingBy(CarroDTO::getMarca));
        System.out.println(porMarca);

        // groupingBy - agrupando por marca - contando carros
        Map<String, Long> qtdPorMarca = data.stream()
                .collect(Collectors.groupingBy(
                        CarroDTO::getMarca,
                        Collectors.counting()
                ));
        System.out.println(qtdPorMarca);

        // Collectors.joining - concatenando strings
        System.out.println(data.stream()
                .map(CarroDTO::getModelo)
                .collect(Collectors.joining(", "))); //sufixo ','

        // collectors - summing - somando valores
        long totalComSumming = data.stream().collect(Collectors.summingLong(CarroDTO::getPreco));
        System.out.println(totalComSumming);

        // collectors - summarizing - relatorios geral de dados
        Map<String, LongSummaryStatistics> statsPorMarca = data.stream()
                .collect(Collectors.groupingBy(
                        CarroDTO::getMarca,
                        Collectors.summarizingLong(CarroDTO::getPreco)
                ));
        System.out.println(statsPorMarca);



    }
}
