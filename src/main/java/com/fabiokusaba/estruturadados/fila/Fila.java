package com.fabiokusaba.estruturadados.fila;

import com.fabiokusaba.estruturadados.base.EstruturaEstatica;

// FIFO (First In First Out) o primeiro a entrar é o primeiro a sair
public class Fila<T> extends EstruturaEstatica<T> {
    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elemento) {
        // O algoritmo básico seria:
//        this.elementos[this.tamanho] = elemento;
//        this.tamanho++;

        // Só que ainda tem o problema da questão da capacidade que vimos nas aulas de vetores, pelo vetor ser uma
        // estrutura estática ele tem capacidade finita e é por isso que nas aulas de vetores a gente desenvolveu o
        // metodo 'aumentaCapacidade' que vai verificar o tamanho com a capacidade real do nosso vetor, se atingiu essa
        // capacidade ele dobra a capacidade e transfere todos os elementos que estão no nosso vetor para esse novo
        // vetor com mais capacidade
        // Então, aqui antes de enfileirar a gente poderia chamar o 'aumentaCapacidade' para poder aumentar a capacidade
        // desse vetor e garantir ou como estamos adicionando o elemento no final nós já temos o metodo aqui na
        // 'EstruturaEstatica' que cuida disso que é o metodo protegido 'adiciona'
        // Então, se você quiser reutilizar código a gente pode simplesmente fazer a chamada desse metodo aqui
        this.adiciona(elemento);

        // Ou caso a gente queira simplificar esse algoritmo aqui
//        this.elementos[this.tamanho++] = elemento;
    }

    // Retornando o primeiro elemento da nossa fila
    public T espiar() {
        // Se você quiser ter um pouco mais de precaução o que a gente pode fazer é:
        if (this.estaVazia()) {
            return null;
        }

        return this.elementos[0];
    }

    // Removendo um elemento da primeira posição do vetor
    public T desenfileira() {
        final int POS = 0;

        // Primeiro vou perguntar se a fila está vazia
        if (this.estaVazia()) {
            return null;
        }

        T elementoASerRemovido = this.elementos[POS];

        this.remove(POS);

        return elementoASerRemovido;
    }
}
