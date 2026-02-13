package br.com.eduardo_asafe.nuggets;

public class OrdemPrecedencia {
    public static void main(String[] args) {
        int c = 20 / 5 * 2;       // (20/5)=4; 4*2=8
        int d = 20 / (5 * 2);     // (5*2)=10; 20/10=2

        System.out.println("   20 / 5 * 2 = " + c);
        System.out.println("   20 / (5 * 2) = " + d);


    }
}
