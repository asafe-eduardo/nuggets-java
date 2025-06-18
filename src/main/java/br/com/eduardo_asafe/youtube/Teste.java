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

        Path path = Paths.get("/home/asafe/Estudos/youtube-resources/lorem_ipsum_100_linhas_2.txt");
        try {
            Files.writeString(path, "TESTE EDU", StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Erro no processamento do arquivo");
        }


    }
}
