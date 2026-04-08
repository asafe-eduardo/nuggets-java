package br.com.eduardo_asafe.nuggets;

class Usuario {

    // Atributos finais
    private final String nome;
    private final String email;
    private final int idade;
    private final String telefone;

    // Construtor privado
    private Usuario(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
        this.idade = builder.idade;
        this.telefone = builder.telefone;
    }

    // Getters (sem setters)
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getIdade() { return idade; }
    public String getTelefone() { return telefone; }

    //Builder
    public static class Builder {

        // Campos obrigatórios
        private final String nome;
        private final String email;

        // Campos opcionais
        private int idade;
        private String telefone;

        // Construtor com obrigatórios
        public Builder(String nome, String email) {
            if (nome == null || email == null) {
                throw new IllegalArgumentException("Nome e email são obrigatórios");
            }
            this.nome = nome;
            this.email = email;
        }

        // Métodos fluentes
        public Builder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        // Build final
        public Usuario build() {
            return new Usuario(this);
        }
    }
}

public class Builder_017 {

    public static void main(String... args) {
        Usuario usuario = new Usuario.Builder("Eduardo", "edu@email.com")
                .idade(28)
                .build();

        System.out.println(usuario.getNome());
    }

}
