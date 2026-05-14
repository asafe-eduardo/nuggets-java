package br.com.eduardo_asafe.nuggets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class close_resources {

    public static void main(String[] args) {

        Path path = Path.of("./lorem_ipsum_100_linhas.txt");

        // Recursos que implementa interface CLoseable/AutoCloseable
        //try catch finally
        BufferedWriter writer = null;

        try {
            writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            writer.write("TESTE EDU");
            writer.newLine();
            writer.write("Escrevendo mais uma linha...");
        } catch (IOException e) {
            System.err.println("Erro no processamento do arquivo: " + e.getMessage());
        } finally {
            // fechamento manual (obrigatório neste modelo)
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("Writer fechado com sucesso.");
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o writer: " + e.getMessage());
                }
            }
        }

        // try-with-resources
        try (BufferedWriter writer2 =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            writer2.write("TESTE EDU");
            writer2.newLine();
            writer2.write("Escrevendo mais uma linha...");

        } catch (IOException e) {
            System.err.println("Erro no processamento do arquivo: " + e.getMessage());
        }


    }
}
