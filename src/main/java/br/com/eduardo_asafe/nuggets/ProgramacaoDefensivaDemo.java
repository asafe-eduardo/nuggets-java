package br.com.eduardo_asafe.nuggets;

import java.util.*;
import java.util.stream.Collectors;

public class ProgramacaoDefensivaDemo {

    // ---------- POJOs compartilhados ----------
    static class Cliente {
        private final String nome;
        private final Endereco endereco;
        public Cliente(String nome, Endereco endereco) { this.nome = nome; this.endereco = endereco; }
        public String getNome() { return nome; }
        public Endereco getEndereco() { return endereco; }
    }

    static class Endereco {
        private final String cidade;
        private Endereco(String cidade) { this.cidade = cidade; }
        public static Endereco vazio() { return new Endereco("N/D"); }
        public static Endereco of(String cidade) { return new Endereco(cidade); }
        public String getCidade() { return cidade; }
    }

    static class Item {
        private final Double preco;
        public Item(Double preco) { this.preco = preco; }
        public Double getPreco() { return preco; }
    }

    static class Pedido {
        private final Cliente cliente; // pode ser nulo
        public Pedido(Cliente cliente) { this.cliente = cliente; }
        public Cliente getCliente() { return cliente; }
    }

    // ---------- 1) SEM Optional (defensivo tradicional) ----------
    public static String nomeMaiusculoSeguroSemOptional(Cliente c) {
        if (c == null) return "DESCONHECIDO";
        String nome = c.getNome();
        if (nome == null || nome.isBlank()) return "DESCONHECIDO";
        return nome.toUpperCase(Locale.ROOT);
    }

    public static double somaPrecosSeguroSemOptional(List<Item> itens) {
        if (itens == null || itens.isEmpty()) return 0.0;
        double total = 0.0;
        for (Item it : itens) {
            if (it == null) continue;
            Double preco = it.getPreco();
            if (preco != null) total += preco;
        }
        return total;
    }

    public static Endereco enderecoOuPadraoSemOptional(Cliente c) {
        if (c == null) return Endereco.vazio();
        Endereco e = c.getEndereco();
        return (e != null) ? e : Endereco.vazio();
    }

    // ---------- 2) COM Optional ----------  Java 8+
    public static String nomeMaiusculoSeguroComOptional(Cliente c) {
        return Optional.ofNullable(c)
                .map(Cliente::getNome)
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .map(s -> s.toUpperCase(Locale.ROOT))
                .orElse("DESCONHECIDO");
    }

    public static String cidadeDoClienteComOptional(Cliente c) {
        return Optional.ofNullable(c)
                .map(Cliente::getEndereco)
                .map(Endereco::getCidade)
                .filter(s -> !s.isBlank())
                .orElse("Cidade não informada");
    }

    public static double somaPrecosSeguroComOptional(List<Item> itens) {
        return Optional.ofNullable(itens).orElseGet(List::of).stream()
                .filter(Objects::nonNull)
                .map(Item::getPreco)
                .filter(Objects::nonNull)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    // ---------- 3) Exemplo que PODE GERAR ERRO (NPE intencional) ----------
    public static void antiExemploQuePodeGerarNPE() {
        Pedido p = new Pedido(null); // cliente == null

        try {
            // Linha problemática: encadeia chamadas em referência possivelmente nula
            String upper = p.getCliente().getNome().toUpperCase(Locale.ROOT);
            System.out.println("Anti-exemplo (NÃO era esperado ver isto): " + upper);
        } catch (NullPointerException npe) {
            System.out.println("⚠️ Capturado NullPointerException no anti-exemplo: " + npe.getMessage());
        }

        // Duas formas corretas (para comparação):

        // a) Checagem defensiva
        Cliente cli = p.getCliente();
        String upperSeguro1 = (cli != null && cli.getNome() != null)
                ? cli.getNome().toUpperCase(Locale.ROOT)
                : "DESCONHECIDO";
        System.out.println("Forma segura (if): " + upperSeguro1);

        // b) Com Optional
        String upperSeguro2 = Optional.ofNullable(p)
                .map(Pedido::getCliente)
                .map(Cliente::getNome)
                .map(s -> s.toUpperCase(Locale.ROOT))
                .orElse("DESCONHECIDO");
        System.out.println("Forma segura (Optional): " + upperSeguro2);
    }

    // ---------- MAIN de demonstração ----------
    public static void main(String[] args) {
        Cliente cOk = new Cliente("  Ana  ", Endereco.of("Brasília"));
        Cliente cNulo = null;
        Cliente cSemNome = new Cliente(null, Endereco.of("São Paulo"));

        List<Item> itens = Arrays.asList(new Item(10.0), new Item(null), null, new Item(5.5));

        // Sem Optional
        System.out.println("[Sem Optional] nome: " + nomeMaiusculoSeguroSemOptional(cOk));
        System.out.println("[Sem Optional] nome (nulo): " + nomeMaiusculoSeguroSemOptional(cNulo));
        System.out.println("[Sem Optional] soma preços: " + somaPrecosSeguroSemOptional(itens));
        System.out.println("[Sem Optional] endereço: " + enderecoOuPadraoSemOptional(cNulo).getCidade());

        // Com Optional
        System.out.println("[Com Optional] nome: " + nomeMaiusculoSeguroComOptional(cOk));
        System.out.println("[Com Optional] nome (sem nome): " + nomeMaiusculoSeguroComOptional(cSemNome));
        System.out.println("[Com Optional] cidade: " + cidadeDoClienteComOptional(cOk));
        System.out.println("[Com Optional] soma preços: " + somaPrecosSeguroComOptional(itens));

        // Anti-exemplo que pode gerar erro (NPE intencional, mas capturado)
        antiExemploQuePodeGerarNPE();

        // Extra: mostra a lista de preços válidos só para visualizar o filtro defensivo
        String precosValidos = Optional.ofNullable(itens).orElseGet(List::of).stream()
                .filter(Objects::nonNull)
                .map(Item::getPreco)
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Preços considerados: [" + precosValidos + "]");
    }
}
