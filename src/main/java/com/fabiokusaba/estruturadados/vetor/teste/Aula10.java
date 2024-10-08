package com.fabiokusaba.estruturadados.vetor.teste;

import com.fabiokusaba.estruturadados.vetor.VetorObjetos;

public class Aula10 {
    public static void main(String[] args) {
        VetorObjetos vetor = new VetorObjetos(3);

        Contato c1 = new Contato("Contato 1", "1234-4567", "contato1@email.com");
        Contato c2 = new Contato("Contato 2", "2345-6789", "contato2@email.com");
        Contato c3 = new Contato("Contato 3", "3456-7890", "contato3@email.com");

        Contato c4 = new Contato("Contato 3", "3456-7890", "contato3@email.com");

        vetor.adiciona(c1);
        vetor.adiciona(c2);
        vetor.adiciona(c3);

        // Isso aqui é um auto boxing, esse processo de você passar um tipo primitivo e ele ser transformado em um
        // objeto se chama auto boxing no Java
//        vetor.adiciona(3);
//        vetor.adiciona(4);
//        vetor.adiciona(5);

        System.out.println("Tamanho = " + vetor.tamanho());

        int pos = vetor.busca(c4);
        if (pos > -1) {
            System.out.println("Elemento existe no vetor");
        } else {
            System.out.println("Elemento não existe no vetor");
        }

        System.out.println(vetor);
    }
}
