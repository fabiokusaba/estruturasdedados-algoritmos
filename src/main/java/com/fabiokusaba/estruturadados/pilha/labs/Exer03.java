package com.fabiokusaba.estruturadados.pilha.labs;

import com.fabiokusaba.estruturadados.pilha.Pilha;

public class Exer03 {
    public static void main(String[] args) {
        Pilha<Livro> pilha = new Pilha<>(20);

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

        System.out.println("Pilha de livros criada, pilha está vazia? " + pilha.estaVazia());

        System.out.println("Empilhando livros na pilha:");

        pilha.empilha(livro1);
        pilha.empilha(livro2);
        pilha.empilha(livro3);
        pilha.empilha(livro4);

        System.out.println(pilha.tamanho() + " livros foram empilhados:");
        System.out.println(pilha);

        System.out.println("Pilha de livros criada, pilha está vazia? " + pilha.estaVazia());

        System.out.println("Espiando o topo da filha: " + pilha.topo());

        System.out.println("Desempilhando livros da pilha:");

        while (!pilha.estaVazia()) {
            System.out.println("Desempilhando livro: " + pilha.desempilha());
        }

        System.out.println("Todos os livros foram desempilhados, pilha vazia: " + pilha.estaVazia());
    }
}
