package com.fabiokusaba.estruturadados.fila.labs;

import com.fabiokusaba.estruturadados.fila.FilaComPrioridade;

public class PSAtendimento implements Runnable {
    private FilaComPrioridade<Pessoa> fila;

    public PSAtendimento(FilaComPrioridade<Pessoa> fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        // A cada x segundos nós vamos atender uma pessoa
        // Então, enquanto essa fila aqui não estiver vazia nós vamos executar a nossa lógica
        while (!fila.estaVazia()) {
            try {
                System.out.println(fila.desenfileira() + " atendida.");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Depois que todas as pessoas forem atendidas
        System.out.println("Atendimento concluído.");
    }
}
