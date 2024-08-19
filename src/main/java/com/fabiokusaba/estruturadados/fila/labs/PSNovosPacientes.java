package com.fabiokusaba.estruturadados.fila.labs;

import com.fabiokusaba.estruturadados.fila.FilaComPrioridade;

import java.util.Random;

public class PSNovosPacientes implements Runnable {
    private FilaComPrioridade<Pessoa> fila;
    private int cont = 7;
    private Random prioridade = new Random();

    public PSNovosPacientes(FilaComPrioridade<Pessoa> fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        // Pra gente poder limitar a quantidade de pessoas que vão ser adicionadas na fila vou colocar aqui um for
        for (int i = 0; i < 8; i++) {
            try {
                // A cada 8s a gente vai colocar uma pessoa nova
                Thread.sleep(8000);

                Pessoa p = new Pessoa("" + cont, prioridade.nextInt(3));
                fila.enfileira(p);
                cont++;

                System.out.println(p + " enfileirada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
