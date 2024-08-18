package com.fabiokusaba.estruturadados.pilha.labs;

import com.fabiokusaba.estruturadados.pilha.Pilha;

public class Exer05 {
    public static void main(String[] args) {
        imprimeResultado("ADA");

        imprimeResultado("ABCD");

        imprimeResultado("ABCCBA");

        imprimeResultado("Maria");
    }

    public static void imprimeResultado(String palavra) {
        System.out.println(palavra + " é palíndromo? " + testaPalindromo(palavra));
    }

    public static boolean testaPalindromo(String palavra) {
        // Primeiro criamos a nossa pilha de caracteres
        Pilha<Character> pilha = new Pilha<Character>();

        // O que nós vamos fazer agora? Pegar cada caractere dessa palavra, uma String no Java é um array de caracteres
        // então a gente consegue acessar cada caracter através de um metodo
        for (int i = 0; i < palavra.length(); i++) {
            // Com o metodo 'charAt' eu consigo obter um determinado caracter da palavra de uma determinada posição
            pilha.empilha(palavra.charAt(i));
        }

        // Depois, nós vamos começar a desempilhar para isso vamos criar uma variável do tipo String chamada
        // 'palavraInversa' que vai receber como valor inicial vazio para a genter começar a adicionar cada caracter
        // criando a nossa palavra inversa
        String palavraInversa = "";

        while (!pilha.estaVazia()) {
            palavraInversa += pilha.desempilha();
        }

        // No final, a gente vai comparar se a palavra for igual a palavra inversa significa que são palíndromos
        if (palavraInversa.equalsIgnoreCase(palavra)) {
            return true;
        }

        return false;
    }
}
