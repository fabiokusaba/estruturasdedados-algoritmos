package com.fabiokusaba.estruturadados.lista.teste;

import java.util.LinkedList;

import com.fabiokusaba.estruturadados.lista.ListaEncadeada;

public class ListaEncadeadaTeste {
    public static void main(String[] args) {
        // testesIniciais();
        // adicionaInicio();
        // adicionaPosicao();
        // removeInicio();
        // removeFinal();
        // removePosicao();
        testeLinkedList();
    }

    public static void testeLinkedList() {
        LinkedList<Integer> lista = new LinkedList<>();

        // Adicionar ao final da lista
        lista.add(1);

        // Adicionando um primeiro elemento
        lista.addFirst(0);

        // Adicionando um último elemento
        lista.addLast(3);

        // Busca para ver se existe o elemento ou não e o Java utiliza o metodo 'contains' para verificar se existe
        // ou não
        System.out.println(lista.contains(1));

        // Além disso o 'add' é sobrecarregado então a gente também tem a opção de passar uma posição e o elemento
        lista.add(2, 2);

        // Imprimindo a nossa lista
        System.out.println(lista);

        // Além disso, a gente pode também remover existe o metodo para remover todos os elementos 'removeAll' para você
        // limpar a lista que seria equivalente ao nosso 'limpa', esse metodo 'remove' que vai remover o primeiro elemento
        // da lista
        lista.remove();
        System.out.println(lista);
        
        // A gente pode remover da posição 0 que nesse caso vai ser o elemento 1
        lista.remove(0);

        // A gente pode 'removeFirst' para remover o primeiro elemento da lista
        lista.removeFirst();

        // A gente também pode fazer aqui um 'removeLast' para remover o último elemento da lista
        lista.removeLast();

        System.out.println(lista);
    }

    public static void removePosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);
        lista.adiciona(5);

        System.out.println("Elemento removido: " + lista.remove(4));
        System.out.println("Lista: " + lista);
    }

    public static void removeFinal() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // lista.removeFinal();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        System.out.println("Elemento removido: " + lista.removeFinal());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeFinal());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeFinal());
        System.out.println("Lista: " + lista);
    }

    public static void removeInicio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        // lista.removeInicio();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);
    }

    public static void adicionaPosicao() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        // lista.adiciona(-1, 1);
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(4); // 1 2 4

        // lista.adiciona(5, 0);

        lista.adiciona(0, 0); // 0 1 2 4
        lista.adiciona(4, 5); // 0 1 2 4 5
        lista.adiciona(2, 3); // 0 1 2 3 4 5

        System.out.println(lista);
    }

    public static void adicionaInicio() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionaInicio(3);
        lista.adicionaInicio(2);
        lista.adicionaInicio(1); // 1 2 3

        System.out.println(lista);
    }

    public static void testesIniciais() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adiciona(2);
        System.out.println(lista);

        lista.adiciona(3);
        System.out.println(lista);

        // lista.limpa();
        // System.out.println(lista);

        // Busca por elemento
        System.out.println("****** busca por elemento");
        System.out.println(lista.busca(0));
        System.out.println(lista.busca(1));
        System.out.println(lista.busca(2));
        System.out.println(lista.busca(3));

        // Busca por posição
        System.out.println("****** busca por posição");
        System.out.println(lista.buscaPorPosicao(0));
        System.out.println(lista.buscaPorPosicao(1));
        System.out.println(lista.buscaPorPosicao(2));
        // System.out.println(lista.buscaPorPosicao(-1));
        // System.out.println(lista.buscaPorPosicao(4));
    }
}
