package com.fabiokusaba.estruturadados.pilha.labs;

import java.util.Stack;

public class Exer08 {
    public static void main(String[] args) {
        Stack<Integer> orignal = new Stack<>();
        Stack<Integer> destino = new Stack<>();
        Stack<Integer> auxiliar = new Stack<>();

        orignal.push(3);
        orignal.push(2);
        orignal.push(1);

        torreDeHanoi(orignal.size(), orignal, destino, auxiliar);
    }

    public static void torreDeHanoi(int n, Stack<Integer> original, Stack<Integer> destino, Stack<Integer> auxiliar) {
        // Esse algoritmo é um algoritmo recursivo, ou seja, ele vai chamar a si mesmo
        // Basicamente em algoritmos recursivos a gente precisa de um ponto de parada, o nosso ponto de parada é o 'n'
        // vai ser menor que 0, então enquanto o 'n' for maior que 0 o algoritmo vai continuar sendo executado
        if (n > 0) {
            // E pra ser um algoritmo recursivo ele precisa chamar a si mesmo, só que quando a gente movimenta o
            // primeiro disco a gente vai sempre chamar aqui com:
            torreDeHanoi(n - 1, original, auxiliar, destino);

            // E aí sim a gente vai fazer a movimentação que é o que? A pilha de destino vou fazer o 'push' da pilha
            // original, ou seja, o 'original.pop' já que vou estar pegando um disco para a outra pilha
            destino.push(original.pop());

            System.out.println("------");
            System.out.println("Original: " + original);
            System.out.println("Destino: " + destino);
            System.out.println("Auxiliar: " + auxiliar);

            // Depois disso nós vamos chamar o algoritmo novamente só que novamente passando o 'n - 1'
            torreDeHanoi(n - 1, auxiliar, destino, original);
        }
    }
}
