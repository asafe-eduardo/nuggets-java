package br.com.eduardo_asafe.nuggets;

public class StringPool {

    public static void main(String[] args) {
        String s1 = "Hello"; // string pool
        
        String s2 = "Hi"; // string pool
        String s3 = new String( "Hi"); // fora do pool
        String s4 = s3.intern(); //  string pool

    }
}
