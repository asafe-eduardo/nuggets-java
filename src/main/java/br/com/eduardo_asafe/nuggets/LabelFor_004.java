package br.com.eduardo_asafe.nuggets;

public class LabelFor_004 {

    public static void main(String[] args) {

        OUTER: for (int i = 0; i < 10; ++i) {
            System.out.println("OUTER FOR: " + i);
            INNER: for(int n = 0; n < 10; ++n){
                System.out.println("INNER FOR dentro do OUTER FOR: " + n);
                if(i == 5){
                    //break OUTER;
                    break;
                }
            }
        }

    }

}
