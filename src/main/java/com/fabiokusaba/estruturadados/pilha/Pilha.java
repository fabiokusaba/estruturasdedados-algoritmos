package com.fabiokusaba.estruturadados.pilha;

import com.fabiokusaba.estruturadados.base.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {
    public Pilha() {
        super();
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    // A pilha tem um comportamento especial chamado de LIFO (Last In First Out), ou seja, o último a entrar é o
    // primeiro a sair
    // Quando a gente vai adicionar um elemento numa pilha a gente vai sempre empilhar, ou seja, adicionar esses
    // elementos ao final da pilha, ou seja, no topo da pilha
    public void empilha(T elemento) {
        // Pra gente poder empilhar um elemento, pra gente poder adicionar um elemento a gente aprendeu que lá no nosso
        // metodo 'adiciona' o que a gente fez? A gente verificou o tamanho, mas antes disso a gente aumentou a
        // capacidade, então a gente pode aumentar a capacidade
//        this.aumentaCapacidade();

        // E agora a gente pode fazer:
//        this.elementos[tamanho] = elemento;
//        tamanho++;

        // Perceba que estávamos repetindo código, então o que podemos fazer é chamar o super, desta forma estamos
        // fazendo reuso de código para um código que já existe aqui
        super.adiciona(elemento);
    }

    public T topo() {
        // Se a pilha estiver vazia isso vai gerar uma exceção e a gente não quer que isso aconteça, então primeiro a
        // gente precisa verificar se a pilha está vazia
        if (this.estaVazia()) {
            // Se a pilha estiver vazia a gente pode retornar nulo porque não tem nada a ser visto no topo da pilha
            return null;
        }

        // Se ela não estiver vazia a gente precisa retornar o elemento
        // Então, o que a gente precisa fazer? A gente sabe que o topo da pilha é 'tamanho - 1', então poderíamos fazer
        // o seguinte:
        return this.elementos[tamanho - 1];
    }
}
