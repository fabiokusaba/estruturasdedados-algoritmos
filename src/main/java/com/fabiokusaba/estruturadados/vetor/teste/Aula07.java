package com.fabiokusaba.estruturadados.vetor.teste;

import com.fabiokusaba.estruturadados.vetor.Vetor;

public class Aula07 {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(10);

        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("E");
        vetor.adiciona("F");
        vetor.adiciona("G");

        System.out.println(vetor);

        vetor.adiciona("A", 0);

        System.out.println(vetor);

        vetor.adiciona("D", 3);

        System.out.println(vetor);
    }
}
