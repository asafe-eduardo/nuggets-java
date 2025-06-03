package br.com.eduardo_asafe.nuggets;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Lombok_003 {
    private String textoLombok;
    private Long numero;

    public static void main(String[] args) {
        new Lombok_003().getTextoLombok();
    }

    public String getTextoLombok() {
        return textoLombok;
    }

    public void setTextoLombok(String textoLombok) {
        this.textoLombok = textoLombok;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
