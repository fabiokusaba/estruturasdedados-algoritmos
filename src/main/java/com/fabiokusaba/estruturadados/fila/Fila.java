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
}
