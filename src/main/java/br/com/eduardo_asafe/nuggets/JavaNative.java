package br.com.eduardo_asafe.nuggets;

public class JavaNative {
    static {
        System.loadLibrary("nativemath"); // carrega .so/.dll
    }

    public native int soma(int a, int b);

    public static void main(String[] args) {
        System.out.println(new JavaNative().soma(2, 3));
    }
}
