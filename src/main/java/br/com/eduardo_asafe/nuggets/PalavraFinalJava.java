package br.com.eduardo_asafe.nuggets;

import java.util.ArrayList;
import java.util.List;

public class PalavraFinalJava {
    public static void main(String[] args) {

        // 1. FINAL EM VARIÁVEL
        final int maxUsers = 100;

        System.out.println(maxUsers);

        // Não compila:
        maxUsers = 200;


        // 2. FINAL COM OBJETOS
        final List<String> users = new ArrayList<>();

        users.add("Eduardo");
        users.add("Maria");

        // O objeto continua podendo ser alterado
        System.out.println(users);

        // Mas a referência não pode mudar:
        users = new ArrayList<>();
    }
}


// 3. FINAL EM MÉTODO
class PaymentService {

    public final void processPayment() {
        System.out.println("Pagamento processado");
    }
}

class PixPaymentService extends PaymentService {

    // Não compila:

    @Override
    public void processPayment() {
        System.out.println("PIX processado");
    }

}


// 4. FINAL EM CLASSE

final class SecurityToken {

    public String generate() {
        return "TOKEN-123";
    }
}

// Não compila:
class CustomToken extends SecurityToken {

}

