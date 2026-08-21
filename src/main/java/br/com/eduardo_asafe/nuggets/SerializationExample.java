package br.com.eduardo_asafe.nuggets;

import java.io.*;

// A interface Serializable é apenas uma "marker interface":
// ela não possui métodos para implementar.
class UsuarioSerialized implements Serializable {

    // Identificador da versão da classe
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;

    // Campos transient não são serializados
    private transient String senha;

    public UsuarioSerialized(String nome, int idade, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", senha='" + senha + '\'' +
                '}';
    }
}

public class SerializationExample {

    public static void main(String[] args) {
        UsuarioSerialized usuario = new UsuarioSerialized("Eduardo", 28, "123456");

        // SERIALIZAÇÃO
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.ser"))) {
            out.writeObject(usuario);
            System.out.println("Objeto serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DESSERIALIZAÇÃO
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.ser"))) {
            UsuarioSerialized usuarioRecuperado = (UsuarioSerialized) in.readObject();
            System.out.println("Objeto desserializado:");
            System.out.println(usuarioRecuperado);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}