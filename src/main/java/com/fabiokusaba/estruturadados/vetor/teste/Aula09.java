package com.fabiokusaba.estruturadados.vetor.teste;

import com.fabiokusaba.estruturadados.vetor.Vetor;

public class Aula09 {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(3);

        vetor.adiciona("B");
        vetor.adiciona("G");
        vetor.adiciona("D");
        vetor.adiciona("E");
        vetor.adiciona("F");

        System.out.println(vetor);

        vetor.remove(1);

        System.out.println(vetor);

        // Suponha que a gente queira remover o elemento 'E' só que a gente não sabe em que posição no vetor ele está
        System.out.println("Remover o elemento E");

        // Então, aqui nós podemos pegar a posição através do metodo busca
        int pos = vetor.busca("E");

        // Verificamos se a posição é maior que -1 para garantir que esse elemento que estamos buscando existe no nosso
        // vetor
        if (pos > - 1) {
            // A gente faz então a remoção desse elemento através do metodo remove
            vetor.remove(pos);
        } else {
            System.out.println("Elemento não existe no vetor");
        }

        System.out.println(vetor);
    }
}
