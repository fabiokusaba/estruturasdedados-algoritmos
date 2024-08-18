package com.fabiokusaba.estruturadados.pilha.labs;

import java.util.Stack;

public class Exer07 {
    public static void main(String[] args) {
        imprimeResultado(2);
        imprimeResultado(4);
        imprimeResultado(10);
        imprimeResultado(25);
        imprimeResultado(10035);

        imprimeResultadoQualquerBase(25, 16);
        imprimeResultadoQualquerBase(10035, 8);
        imprimeResultadoQualquerBase(10035, 16);
    }

    public static void imprimeResultado(int numero) {
        System.out.println(numero + " em binário é: " + decimalBinario(numero));
    }

    public static void imprimeResultadoQualquerBase(int numero, int base) {
        System.out.println(numero + " na base " + base + " é: " + decimalQualquerBase(numero, base));
    }

    public static String decimalBinario(int numero) {
        Stack<Integer> pilha = new Stack<>();
        String numBinario = "";
        int resto;

        // Enquanto o número que a gente passou for maior que 0 a gente vai começar a fazer as divisões
        while (numero > 0) {
            resto = numero % 2;

            // Nisso, nós vamos empilhar o resto
            pilha.push(resto);

            // Depois, vamos dividir o nosso número por 2
            numero /= 2; // numero = numero / 2
        }

        // Agora, enquanto a pilha não estiver vazia a gente vai começar a desempilhar
        while (!pilha.isEmpty()) {
            // Então, nós vamos desempilhar e adicionar diretamente na nossa String
            numBinario += pilha.pop();
        }

        return numBinario;
    }

    public static String decimalQualquerBase(int numero, int base) {
        if (base > 16) {
            throw new IllegalArgumentException();
        }
        Stack<Integer> pilha = new Stack<>();
        String numBase = "";
        int resto;
        String bases = "0123456789ABCDEF";

        while (numero > 0) {
            resto = numero % base;

            pilha.push(resto);

            numero /= base;
        }

        while (!pilha.isEmpty()) {
            numBase += bases.charAt(pilha.pop());
        }

        return numBase;
    }
}
