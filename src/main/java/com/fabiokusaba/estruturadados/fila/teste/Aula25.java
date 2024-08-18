package com.fabiokusaba.estruturadados.fila.teste;

import com.fabiokusaba.estruturadados.fila.Paciente;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Aula25 {
    public static void main(String[] args) {
        // O Java também tem uma classe que representa uma fila com prioridade que é a classe 'PriorityQueue'
        // Porém, em alguns casos pode ser que você não tenha esse metodo 'compareTo' aqui e se a gente for olhar o
        // construtor da 'PriorityQueue' vocês vão ver que ele é sobrecarregado e podemos passar um 'Comparator' aqui
        // Então, existem duas maneiras que a gente pode utilizar: podemos utilizar o 'compareTo' da própria classe
        // 'Paciente' já que ela implementa o 'Comparable' ou então eu posso passar também o meu 'Comparator' através de
        // uma classe anônima do Java diretamente para o construtor da minha fila com prioridades
        Queue<Paciente> filaComPrioridade = new PriorityQueue<>(new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                // Uma forma da gente fazer isso daqui um pouco mais elegante porque esse código é o mesmo que estava
                // no metodo 'compareTo' da nossa classe 'Paciente', o 'getPrioridade' é um inteiro já que declaramos
                // ele como um inteiro, com inteiro a gente pode comparar utilizando o operador de comparação do Java
                // '>, <' porém caso vocês queiram fazer isso aqui de maneira mais simplificada nós podemos fazer: o
                // metodo 'compare' ou o metodo 'compareTo' eles só existem para tipos de objetos do Java e nós vimos
                // que podemos transformar um tipo primitivo do Java em um tipo classe que são as chamadas classes
                // Wrappers
                return Integer.valueOf(p1.getPrioridade()).compareTo(p2.getPrioridade());
            }
        });

        filaComPrioridade.add(new Paciente("A", 2));
        filaComPrioridade.add(new Paciente("B", 1));

        System.out.println(filaComPrioridade);
    }
}
