package com.fabiokusaba.estruturadados.fila.teste;

import java.util.LinkedList;
import java.util.Queue;

public class Aula23 {
    public static void main(String[] args) {
        // A classe que utilizamos para representar uma fila no Java é a classe Queue, só que aqui temos um problema se
        // a gente for tentar instânciar essa classe veremos que não é possível o por que disso? É porque a classe
        // Queue não existe no Java o que existe é a interface Queue
        // Nós podemos instânciar qualquer classe que implemente uma interface (conceito de polimorfismo) e os metodos
        // que estarão disponíveis para a gente utilizar naquela classe são os metodos que foram declarados naquela
        // interface
        // Aqui no Java como não existe uma classe fila propriamente dita nós podemos utilizar qualquer uma das classes
        // que implementam a classe Queue e uma das classes que implementa a classe Queue no Java é a classe LinkedList
        // A classe LinkedList é a classe que representa a lista encadeada
        Queue<Integer> fila = new LinkedList<>();

        fila.add(1); // enqueue -> enfileirar
        fila.add(2);

        System.out.println(fila); // toString

        System.out.println(fila.peek()); // espiar

        System.out.println(fila.remove()); // dequeue -> desenfileirar -> remover da primeira posição

        System.out.println(fila);
    }
}
