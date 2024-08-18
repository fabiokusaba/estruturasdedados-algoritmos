package com.fabiokusaba.estruturadados.vetor.teste;

import com.fabiokusaba.estruturadados.vetor.Lista;

public class Aula11 {
    public static void main(String[] args) {
//        VetorObjetos vetor = new VetorObjetos(2);

        // Com o nosso 'VetorObjetos' que vimos na aula passada nós conseguimos adicionar dois tipos diferentes, ou seja
        // nós temos um elemento do tipo inteiro e nós temos um elemento do tipo String no nosso vetor
        // Como vimos a definição de um vetor em aula passada: um vetor armazena uma sequência de valores onde todos são
        // do mesmo tipo
//        vetor.adiciona(1);
//        vetor.adiciona("Elemento do tipo string");

        Lista<Contato> vetor = new Lista<Contato>(1);

        Contato c1 = new Contato("Contato 1", "1234-4567", "contato1@email.com");
        Contato c2 = new Contato("Contato 2", "2345-6789", "contato2@email.com");
        Contato c3 = new Contato("Contato 3", "3456-7890", "contato3@email.com");

        vetor.adiciona(c1);
        vetor.adiciona(c2);
        vetor.adiciona(c3);
    }
}
