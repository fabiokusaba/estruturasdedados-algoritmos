package com.fabiokusaba.estruturadados.pilha.teste;

import com.fabiokusaba.estruturadados.pilha.Pilha;

import java.util.Stack;

public class Aula18 {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<Integer>();

        Stack<Integer> stack = new Stack<Integer>();

        // Utilizando a API nativa do Java Stack
        // Verificando se a pilha está vazia
        System.out.println(stack.isEmpty());

        // Empilhando elementos
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.isEmpty());

        // Tamanho da pilha
        System.out.println(stack.size());

        // Metodo toString
        System.out.println(stack);

        // Espiando elemento da pilha
        System.out.println(stack.peek());

        // Removendo elemento da pilha
        System.out.println(stack.pop());

        System.out.println(stack);
    }
}
