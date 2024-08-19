package com.fabiokusaba.estruturadados.fila.labs;

import com.fabiokusaba.estruturadados.fila.Fila;

import java.util.Random;

public class Exer04 {
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();

        for (int i = 0; i < 10; i++) {
            fila.enfileira(i);
        }

        Random aleatorio = new Random();
        int num = 0;
        while (num == 0) {
            num = aleatorio.nextInt(10);
        }

        System.out.println("Número = " + num);

        while (fila.tamanho() > 1) {
            for (int i = 0; i < num; i++) {
                // Nós vamos desenfileirar uma pessoa, a partir do momento que uma pessoa passa a bola pra frente a
                // gente desenfileira essa pessoa, só que pra dar ideia de fila circular a gente vai enfileirar essa
                // pessoa novamente, basicamente vai sair do início e vai voltar para o final
                fila.enfileira(fila.desenfileira());
            }

            System.out.println("Eliminado = " + fila.desenfileira());
        }

        System.out.println("Ganhador: " + fila.desenfileira());
    }
}
