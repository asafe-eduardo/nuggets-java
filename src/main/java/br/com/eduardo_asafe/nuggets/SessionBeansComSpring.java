package br.com.eduardo_asafe.nuggets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Spring’s Inversion of Control (IoC) container.
 * Containers gerenciaveis pela aplicação
 */

public class SessionBeansComSpring {

    /*

        @Service e @Component por padrão Singleton (aplicaveis a classe)
        mas, pode ser aplicados a scope

     */

    @Bean //Aplicaveis a métodos
    @Scope("request")
    public String requestScope(){
        return "RequestScope";
    }

    @Bean
    @Scope("session")
    public String sessionScope(){
        return "SessionScope";
    }

    @Bean //Duas linhas que podem ser substituidas por @Component
    @Scope("singleton")
    public String singletonScope(){
        return "SingletonScope";
    }

    public static void main(String[] args) {

    }
}


