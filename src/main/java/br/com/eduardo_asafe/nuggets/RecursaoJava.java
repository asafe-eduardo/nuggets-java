package br.com.eduardo_asafe.nuggets;

public class RecursaoJava {

    static int fatorial(int n) {
        if (n == 1) return 1;
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        int f = fatorial(5); //5 * 4 * 3 * 2 * 1
        System.out.println(f);
    }

}
