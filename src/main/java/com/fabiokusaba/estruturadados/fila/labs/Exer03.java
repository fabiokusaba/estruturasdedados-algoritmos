package com.fabiokusaba.estruturadados.fila.labs;

import com.fabiokusaba.estruturadados.fila.FilaComPrioridade;

public class Exer03 {
    public static final int VERDE = 2;
    public static final int AMARELO = 1;
    public static final int VERMELHO = 0;

    public static void main(String[] args) {
        FilaComPrioridade<Pessoa> fila = new FilaComPrioridade<>();

        fila.enfileira(new Pessoa("1", VERDE));
        fila.enfileira(new Pessoa("2", AMARELO));
        fila.enfileira(new Pessoa("3", VERMELHO));
        fila.enfileira(new Pessoa("4", VERDE));
        fila.enfileira(new Pessoa("5", VERDE));
        fila.enfileira(new Pessoa("6", VERMELHO));

        // Depois de enfileirar as pessoas vamos começar o atendimento
        PSAtendimento atendimento = new PSAtendimento(fila);

        // Novos pacientes chegando ao PS
        PSNovosPacientes pacientes = new PSNovosPacientes(fila);

        // Para poder iniciar vou criar uma Thread e essa Thread vai receber uma instância da classe Runnable que nesse
        // caso vai ser o 'atendimento'
        Thread t1 = new Thread(atendimento);

        Thread t2 = new Thread(pacientes);

        // E aí sim podemos pedir o 'start'
        t1.start();

        t2.start();
    }
}
