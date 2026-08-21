package br.com.eduardo_asafe.nuggets;

abstract class Animal {
    public abstract void emitirSom();
}

class Dog extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au Au!");
    }

    public void buscarBola() {
        System.out.println("Buscando a bola...");
    }
}

class Cat extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    public void arranharSofa() {
        System.out.println("Arranhando o sofá...");
    }
}

public class InstanceOfExample {

    public static void main(String[] args) {
        Animal animal = new Dog();

        // instanceof tradicional
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.buscarBola();
        }

        // Pattern Matching (Java 16+)
        if (animal instanceof Dog dog) {
            dog.emitirSom();
            dog.buscarBola();
        }

        if (animal instanceof Cat cat) {
            cat.arranharSofa();
        } else {
            System.out.println("O animal não é um gato.");
        }

        // null sempre retorna false
        Animal animalNulo = null;

        if (animalNulo instanceof Dog) {
            System.out.println("Nunca será executado.");
        } else {
            System.out.println("instanceof retornou false para null.");
        }
    }
}