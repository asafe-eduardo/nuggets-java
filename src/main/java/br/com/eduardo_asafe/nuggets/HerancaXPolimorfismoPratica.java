package br.com.eduardo_asafe.nuggets;


/*

    ===============================================
    ======== HERANÇA ===============
    ===============================================

 */
class Automovel {

    protected String estritamentePrivado;

    void acelerar(){
        System.out.println("Acelerou de 0 a 40km !!");
    }
}

class Veiculo {

}

class Carro extends Automovel {

    @Override
    void acelerar(){
        System.out.println("desacelerou!!");
    }

    void abrirPortaMalas(){
        estritamentePrivado = "";
        System.out.println("Abriu o porta malas!!!");
    }
}

class teste {

    public static void main(String... args){
        new Carro().acelerar();
        new Carro().abrirPortaMalas();
        System.out.println(new Carro().toString());
    }
}

/*

    ===============================================
    ======== POLIMORFISMO ===============
    ===============================================

 */

class Pagamento {
    void pagar(double valor) {

    }
}

class Pix extends Pagamento {
    public void pagar(double valor){
        System.out.println("Pagou com pix " + valor);
    }
}

class Cartao extends Pagamento {
    public void pagar(double valor){
        System.out.println("Pagou com cartao " + valor);
    }
}

class PagamentoService {
    void pagamento(Pagamento pagamento, double valor){
        pagamento.pagar(valor);
    }
}

class HerancaXPolimorfismoPratica {
}
