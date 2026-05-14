package br.com.eduardo_asafe.youtube;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teste {

    public static void main(String[] args) {
//        File file = new File("/home/asafe/Estudos/youtube-resources/lorem_ipsum_100_linhas.txt");
//
//        try(FileReader fileReader = new FileReader(file)){
//            int ch = 0;
//            while((ch = fileReader.read()) != -1){ // Lendo até chegar no chracter final (EOF)
//                System.out.print((char) ch);
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Não foi possivel fazer abertura do arquivo");
//        } catch (IOException e) {
//            System.err.println("Erro no processamento do arquivo");
//        }

//        File file = new File("/home/asafe/Estudos/youtube-resources/lorem_ipsum_100_linhas.txt");
//        try(BufferedReader inputFile = new BufferedReader(new FileReader(file));
//            BufferedWriter outputFile = new BufferedWriter(new FileWriter("/home/asafe/Estudos/youtube-resources/lorem_ipsum_100_linhas_2.txt"))
//        ){
//            int ch = 0;
//            while((ch = inputFile.read()) != -1){ // Lendo até chegar no chracter final (EOF)
//                outputFile.write((char) ch);
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Não foi possivel fazer abertura do arquivo");
//        } catch (IOException e) {
//            System.err.println("Erro no processamento do arquivo");
//        }

//        Path path = Paths.get("/home/asafe/Estudos/youtube-resources/lorem_ipsum_300MB.txt");
//
//        try {
//            Files.readAllLines(path).forEach(r -> {
//                System.out.println(r);
//                System.out.println("teste");
//            });
//        } catch (IOException e) {
//            System.err.println("Erro no processamento do arquivo");
//        }
/*
        Path path = Paths.get("/home/asafe/Estudos/youtube-resources/lorem_ipsum_100_linhas_2.txt");
        try {
            Files.writeString(path, "TESTE EDU", StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro no processamento do arquivo");
        }
*/















        // 1. Complexidade computacional Big O.
        // mede: tempo e memoria conforme os dados crescem
        int n=10;
        for(int i = 0; i<n;i++){ // se dobrar entrada, dobra o tempo
            System.out.println(i);
        }

        // 2. Complexidade de dominio.
        // lógicas que podem até rodar rápido mas, ngm entende.
        // Custo cognitivo
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;

        // 3. Complexidade ciclomática
        // quantos caminhos o código pode seguir
        int x = 1;
        int y = 1;
        if(x > 0){
            if(y > 0) {
                // caminho 1
            } else {
                // caminho 2
            }
        } else {
            // caminho 3
        }

        //4. complexidade de halstead
        // Mede esforço mental para entender o código
        int preco = 30;
        int quantidade = 20;
        double taxa = 1.15;
        double desconto = 0.15;

        double total = preco * quantidade + taxa - desconto;

        // 5. complexidade linguistica
        // codigo também é linguagem

        // exemplo ruim
        //int x = calcular(y, z);

        // mais inteligivel
        //int valorTotal = calcularPrecoComDesconto(produto, cliente);


    }
}
