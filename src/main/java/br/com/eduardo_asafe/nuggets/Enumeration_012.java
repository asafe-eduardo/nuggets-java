package br.com.eduardo_asafe.nuggets;

public enum Enumeration_012 {
    Pendente,
    Processando,
    Enviado,
    Entregue
}

enum exemplo_02 {
    Pendente(1, "STATUS PENDENTE"),
    Processando(2, "STATUS PROCESSANDO"),
    Enviado(3, "STATUS ENVIADO"),
    Entregue(4, "STATUS ENTREGUE");

    exemplo_02(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    private final int id;
    private final String descricao;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}