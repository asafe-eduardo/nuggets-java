package br.com.eduardo_asafe.nuggets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SomaTask extends RecursiveTask<Integer> {
    private int[] numeros;
    private int inicio;
    private int fim;

    SomaTask(int[] numeros, int inicio, int fim) {
        this.numeros = numeros;
        this.inicio = inicio;
        this.fim = fim;
    }

    protected Integer compute() {
        if (fim - inicio <= 2) {
            int soma = 0;
            for (int i = inicio; i < fim; i++) {
                soma += numeros[i];
            }
            return soma;
        }

        int meio = (inicio + fim) / 2;

        SomaTask esquerda = new SomaTask(numeros, inicio, meio);
        SomaTask direita = new SomaTask(numeros, meio, fim);

        esquerda.fork();

        return direita.compute() + esquerda.join();
    }
}

public class ForkJoinVsExecutorService {
    public static void main(String[] args) {

        // Exemplo prático executorservice.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            System.out.println("Processando relatório");
        });

        executor.submit(() -> {
            System.out.println("Enviando e-mail");
        });

        executor.shutdown();

        // ForkJoin
        ForkJoinPool pool = new ForkJoinPool();

        int[] numeros = {1, 2, 3, 4, 5, 6};

        int resultado = pool.invoke(
                new SomaTask(numeros, 0, numeros.length)
        );

        System.out.println(resultado);

    }
}
