package com.fabiokusaba.estruturadados.pilha.labs;

import java.util.Stack;

public class Exer04 {
    public static void main(String[] args) {
        // A classe Stack do Java ela não é uma estrutura estática, por baixo dos panos a classe Stack não utiliza a
        // classe ArrayList, por exemplo, eles não utilizam um array para guardar as informações
        // A classe Stack, na verdade, ela utiliza para representar os elementos a classe LinkedList que é a classe
        // Lista Ligada ou Lista Encadeada, ou seja, no Java a classe Stack é uma pilha dinâmica e é por isso que a
        // classe Stack no Java não precisa de uma capacidade porque ela pode ter quantos elementos forem necessários
        Stack<Livro> pilha = new Stack<Livro>();

        Livro livro1 = new Livro();
        livro1.setNome("Livro 1");
        livro1.setAutor("Autor 1");
        livro1.setAnoLancamento(2016);
        livro1.setIsbn("isbnlivro1");

        Livro livro2 = new Livro();
        livro2.setNome("Livro 2");
        livro2.setAutor("Autor 2");
        livro2.setAnoLancamento(2017);
        livro2.setIsbn("isbnlivro2");

        Livro livro3 = new Livro();
        livro3.setNome("Livro 3");
        livro3.setAutor("Autor 3");
        livro3.setAnoLancamento(2018);
        livro3.setIsbn("isbnlivro3");

        Livro livro4 = new Livro();
        livro4.setNome("Livro 4");
        livro4.setAutor("Autor 4");
        livro4.setAnoLancamento(2019);
        livro4.setIsbn("isbnlivro4");

        System.out.println("Pilha de livros criada, pilha está vazia? " + pilha.isEmpty());

        System.out.println("Empilhando livros na pilha:");

        pilha.push(livro1);
        pilha.push(livro2);
        pilha.push(livro3);
        pilha.push(livro4);

        System.out.println(pilha.size() + " livros foram empilhados:");
        System.out.println(pilha);

        System.out.println("Pilha de livros criada, pilha está vazia? " + pilha.isEmpty());

        System.out.println("Espiando o topo da filha: " + pilha.peek());

        System.out.println("Desempilhando livros da pilha:");

        while (!pilha.isEmpty()) {
            System.out.println("Desempilhando livro: " + pilha.pop());
        }

        System.out.println("Todos os livros foram desempilhados, pilha vazia: " + pilha.isEmpty());
    }
}
