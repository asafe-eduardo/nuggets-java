package br.com.eduardo_asafe.nuggets;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

// A anotação @Service diz para o Container IoC do springboot que ele deve ser gerenciavel
@Service
public class CiclodeVidaBeanSpringboot {

    public CiclodeVidaBeanSpringboot(JwtFilterExample jwtFilterExample){
        // 2º da fila
    }

    // O que é ciclo de vida?
    // Cria → Injeta dependencias → inicializa → usa → destroe

    // ==== Cria (inicialização da aplicação) ====
    // ==== Chama o construtor do objeto ====
    // ==== Injeta dependencias ====
    // ==== Inicialização do objeto (@PostConstruct) ====
    // ==== Bean pronto para uso na aplicação (Singleton) ====
    // ==== Destroe (aplicação finalizada) ====



    @PostConstruct
    public void init() {
        System.out.println("Conectado ao banco de dados");
    }


    public void enviarEmail(){
        System.out.println("Sending email...");
    }
}
