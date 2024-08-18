package com.fabiokusaba.estruturadados.vetor;

import com.fabiokusaba.estruturadados.base.EstruturaEstatica;

public class Lista2<T> extends EstruturaEstatica<T> {
    // Quando não temos parâmetros no construtor podemos chamar o construtor da super classe
    public Lista2() {
        super();
    }

    public Lista2(int capacidade) {
        super(capacidade);
    }

    public boolean adiciona(T elemento) {
        return super.adiciona(elemento);
    }

    public boolean adiciona(int posicao, T elemento) {
        return super.adiciona(posicao, elemento);
    }
}
