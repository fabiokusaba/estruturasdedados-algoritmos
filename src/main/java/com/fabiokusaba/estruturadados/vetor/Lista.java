package com.fabiokusaba.estruturadados.vetor;

import java.lang.reflect.Array;

// A partir do Java 5 foi introduzido a funcionalidade de Generics para trabalharmos com tipos genéricos, ou seja, de
// qualquer tipo de classe ou objeto no Java o mesmo princípio também é aplicado na classe ArrayList que é a estrutura
// de dados nativa do Java
// Nós vamos utilizar um recurso do Java chamado Generics onde nós podemos na declaração da nossa 'Lista' passar qual
// que é o tipo de classe que a gente quer que esse vetor trabalhe, ou seja, vai ser um tipo só de inteiro, vai ser um
// tipo só de String, vai ser um vetor só de Contato, com que classe nós vamos trabalhar com esse vetor e para isso nós
// vamos passar dentro da simbologia do Generics que é o '<>' (operador "diamond" (diamante)) passando aqui dentro 'T'
// que significa o class type
public class Lista<T> {
    private T[] elementos;
    private int tamanho;

    // A solução trazida no livro Effective Java para podermos instânciar um vetor de tipo genérico é criarmos o vetor
    // do tipo Object e aqui a gente faz o casting para o tipo que a gente precisa fazer que é o tipo que foi declarado
    // aqui
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Reflection no Java é uma API que deixa você acessar dinâmicamente as classes que você tem no seu projeto, os
    // atributos que você tem no seu projeto e você pode manipular essa informação
    // Para você poder instânciar um vetor passando o tipo dinâmicamente no Java é preciso passar o tipo também como
    // parâmetro do nosso construtor
    public Lista(int capacidade, Class<T> tipoClasse) {
        // E aqui utilizando reflection:
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(T elemento, int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();

        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            // A mesma coisa que fizemos lá em cima, continua instânciando um vetor de objeto, porén faz o casting pra
            // classe
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];

            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }

            this.elementos = elementosNovos;
        }
    }

    public T busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        return this.elementos[posicao];
    }

    public int busca(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void  remove(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
    }

    // Metodo responsável por retornar o tamanho do nosso vetor
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(this.elementos[i]);
            sb.append(", ");
        }

        if (this.tamanho > 0) {
            sb.append(this.elementos[this.tamanho - 1]);
        }

        sb.append("]");
        return sb.toString();
    }
}
