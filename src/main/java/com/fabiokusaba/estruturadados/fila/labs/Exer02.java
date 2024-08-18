package com.fabiokusaba.estruturadados.fila.labs;

import com.fabiokusaba.estruturadados.fila.Fila;

public class Exer02 {
    public static void main(String[] args) {
        Fila<String> regular = new Fila<>();
        Fila<String> prioridade = new Fila<>();

        // Para não termos números mágicos no nosso programa nós criamos uma constante para indicar esse valor
        final int MAX_PRIORIDADE = 3;

        regular.enfileira("Pessoa 1");
        regular.enfileira("Pessoa 1");
        regular.enfileira("Pessoa 3");

        prioridade.enfileira("Pessoa 1P");
        prioridade.enfileira("Pessoa 2P");
        prioridade.enfileira("Pessoa 3P");
        prioridade.enfileira("Pessoa 4P");
        prioridade.enfileira("Pessoa 5P");

        regular.enfileira("Pessoa 4");
        regular.enfileira("Pessoa 5");
        regular.enfileira("Pessoa 6");
        regular.enfileira("Pessoa 7");
        regular.enfileira("Pessoa 8");

        // Tendo pessoas em uma fila ou outra nós vamos atender essas pessoas
        while (!regular.estaVazia() || !prioridade.estaVazia()) {

            // O problema pede para a gente ter no máximo 3 pessoas com prioridade atendida pra depois a gente
            // desenfileirar uma pessoa da fila regular, então vamos colocar um contador
            int cont = 0;

            // Enquanto a fila de prioridade não estiver vazia e o nosso contador for menor que 'MAX_PRIORIDADE' nós
            // vamos atender a pessoa
            while (!prioridade.estaVazia() && cont < MAX_PRIORIDADE) {
                atendePessoa(prioridade);

                // Aqui não podemos esquecer de incrementar o nosso contador
                cont++;
            }

            // Se 3 pessoas da fila com prioridade foram atendidas nós vamos pegar pessoas da fila regular
            if (!regular.estaVazia()) {
                atendePessoa(regular);
            }

            // Depois que a gente atendeu uma pessoa da fila regular a gente vai verificar novamente se a fila de
            // prioridades está vazia
            if (prioridade.estaVazia()) {
                // Se a fila estiver vazia podemos atender todos da fila regular, se não vai voltar para o início e vai
                // começar a atender pessoas da fila de prioridade novamente
                if (!regular.estaVazia()) {
                    atendePessoa(regular);
                }
            }
        }
    }

    public static void atendePessoa(Fila<String> fila) {
        String pessoaAtendida = fila.desenfileira();
        System.out.println(pessoaAtendida + " foi atendida.");
    }
}
