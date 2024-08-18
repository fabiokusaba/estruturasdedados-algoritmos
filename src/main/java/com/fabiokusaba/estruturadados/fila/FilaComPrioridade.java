package com.fabiokusaba.estruturadados.fila;

public class FilaComPrioridade<T> extends Fila<T> {
    // A forma de definirmos a prioridade na nossa fila é sobrescrevendo o metodo 'enfileira' que herdamos da nossa
    // classe mãe 'Fila' porque aqui estamos simplesmente adicionando no final do vetor
    @Override
    public void enfileira(T elemento) {
        // Nós podemos percorrer todos os elementos que nós temos na nossa fila e comparar um a um e aí sim adicionar
        // esse elemento na posição correta e para poder parar o algoritmo colocaríamos um 'break'
//        for (int i = 0; i < this.elementos.length; i++) {
//            if (elemento < this.elementos[i]) {
//                this.adiciona(i, elemento);
//                break;
//            }
//        }

        // Nós vamos utilizar o metodo compareTo para fazer a comparação
        Comparable<T> chave = (Comparable<T>) elemento; // Fazendo o casting da classe

        // Esse for só vai funcionar se já tiver elementos na nossa fila, o que a gente vai fazer aqui? Como essa
        // variável 'i' está declarada e só tem escopo nesse for eu vou trazer ela aqui para fora
        int i;

        // Depois disso, vou vir denovo em todos os elementos
        for (i = 0; i < this.tamanho; i++) {
            // E vou fazer a comparação, e como a gente vai fazer a comparação? Se a 'chave' que é o elemento que
            // estamos querendo adicionar comparado ao outro elemento, ou seja, é o elemento que está dentro da nossa
            // fila já for menor que 0, ou seja, for um elemento com uma prioridade menor ou maior dependendo de como a
            // gente vai interpretar é que nós adicionamos esse elemento
            if (chave.compareTo(this.elementos[i]) < 0) {
                // Parando o algoritmo
                break;
            }
        }

        // E o que eu vou fazer? Vou chamar o metodo 'adiciona' numa determinada posição que é a posição 'i' o elemento
        // que eu quero adicionar
        this.adiciona(i, elemento);
    }
}
