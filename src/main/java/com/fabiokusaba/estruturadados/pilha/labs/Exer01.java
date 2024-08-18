package com.fabiokusaba.estruturadados.pilha.labs;

import com.fabiokusaba.estruturadados.pilha.Pilha;

import java.util.Scanner;

public class Exer01 {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<Integer>();
        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.println("Entre com um número:");
            int num = scan.nextInt();

            // Se o número for par a gente empilha
            if (num % 2 == 0) {
                System.out.println("Empilhando o número " + num);
                pilha.empilha(num);
            } else {
                // Se o número for ímpar a gente desempilha
                Integer desempilhado = pilha.desempilha();

                // Lá no nosso metodo 'desempilha' a gente já verifica se a pilha está vazia, se a pilha está vazia a
                // gente retorna 'null', então precisamos colocar uma mensagem que o exercício pediu
                if (desempilhado == null) {
                    System.out.println("Pilha está vazia");
                } else {
                    // Se não a gente mostra o número
                    System.out.println("Número ímpar, desempilhando um elemento da pilha: " + desempilhado);
                }
            }
        }

        // Depois que a gente sair desse 'for' a gente vai desempilhar todos os números
        System.out.println("Todos os números foram lidos, desempilhando números da pilha");

        while (!pilha.estaVazia()) {
            System.out.println("Desempilhando um elemento da pilha: " + pilha.desempilha());
        }

        System.out.println("Todos os elementos foram desempilhados");
    }
}
