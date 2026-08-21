package br.com.eduardo_asafe.nuggets;

public class ClassNotFoundXNoClassDefFoundMain {

    public static void main(String[] args) {

        //Diferenças: java.lang.ClassNotFoundException X NoClassDefFoundError

        // java.lang.ClassNotFoundException
        // se o driver do MySQL não estiver no classpath
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // "Você pediu para a JVM procurar uma classe pelo nome... mas ela não encontrou."

        // NoClassDefFoundError
        // Seu código compilou normalmente.
        Emprestimo emprestimo = new Emprestimo();

        // Durante a compilação a classe Emprestimo existia.
        //Mas, em produção: NoClassDefFoundError
        // "A JVM esperava que essa classe estivesse disponível porque ela existia quando você compilou o projeto."

    }
}
