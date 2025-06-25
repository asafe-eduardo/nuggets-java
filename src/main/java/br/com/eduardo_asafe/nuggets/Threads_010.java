package br.com.eduardo_asafe.nuggets;

public class Threads_010 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicio da execução");

        Thread thread1 = new Thread(() -> System.out.println("Uma nova thread1"));

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Uma nova thread2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread1.join();
        System.out.println("Fim da execução");
        thread2.start();

    }
}
