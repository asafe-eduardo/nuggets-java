package br.com.eduardo_asafe.nuggets;

import java.time.LocalDate;

// Estoria de usuario: "Queremos um sistema que empreste livros"
/*
    Após algumas conversas fica definidos
    1. Livro é nome, autor, um objeto fisico.
    2. Emprestimo é um evento. (Um acordo entre biblioteca e a pessoa em um ponto de tempo)

*/

// ===================== Exemplo: sem conceito SOLID
/*
class Livro {
    String titulo;
    String autor;
    String prateleira;
    LocalDate dataInicioEmprestimo; ⚠️ Problema conceitual.
    LocalDate dataFimEmprestimo; ⚠️ Problema conceitual.
    Long EmprestadorId; ⚠️ Problema conceitual.
}

class Emprestador {
    Long id;
    String name;
    String enderedo;
}

┌──────────────────────────────┐
│            Livro             │
├──────────────────────────────┤
│ titulo : String              │
│ autor : String               │
│ prateleira : String          │
│──────────────────────────────│
│ ⚠️ dataInicioEmprestimo      │
│ ⚠️ dataFimEmprestimo         │
│ ⚠️ emprestadorId             │
└──────────────────────────────┘
              │
              │ acoplamento incorreto
              │
              ▼
┌──────────────────────────────┐
│         Emprestador          │
├──────────────────────────────┤
│ id : Long                    │
│ name : String                │
│ endereco : String            │
└──────────────────────────────┘

*/

// ===================== Exemplo: COM CONCEITO SOLID

/*

┌──────────────────────────────┐
│            Livro             │
├──────────────────────────────┤
│ titulo : String              │
│ autor : String               │
│ prateleira : String          │
└──────────────────────────────┘


┌──────────────────────────────┐
│         Emprestador          │
├──────────────────────────────┤
│ nome : String                │
│ endereco : String            │
└──────────────────────────────┘


┌──────────────────────────────┐
│          Emprestimo          │
├──────────────────────────────┤
│ dataInicio : LocalDate       │
│ dataFim : LocalDate          │
│ dataRetorno : LocalDate      │
│ livro : Livro                │
│ emprestador : Emprestador    │
└──────────────────────────────┘

                 ┌───────────────┐
                 │ Emprestador   │
                 └───────┬───────┘
                         │
                         │ 1
                         │
                         │
                         N
                 ┌───────┴───────┐
                 │  Emprestimo   │
                 └───────┬───────┘
                         │
                         │ N
                         │
                         │
                         1
                    ┌────┴────┐
                    │  Livro  │
                    └─────────┘


 */

class Livro {
    String titulo;
    String autor;
    String prateleira;
}

class Emprestimo {
    LocalDate dataInicio;
    LocalDate dataFim;
    LocalDate dataRetorno;
    Livro livro;
    Emprestador emprestador;
}

class Emprestador {
    String nome;
    String endereco;
}

// Este modelo responde corretamente:
/*

Quantos vezes o livro foi empresatado ano passado?
Quais livros estão atrasados no momento?
Qual Emprestador tem emprestimos ativos?

Principios SOLIDs aplicados:
Única Responsabilidade (Motivo de seprar Livro e Emprestimo separadamente)

*/



public class PrincipiosSolid {
}
