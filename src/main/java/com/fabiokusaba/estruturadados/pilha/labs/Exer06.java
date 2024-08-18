package com.fabiokusaba.estruturadados.pilha.labs;

import com.fabiokusaba.estruturadados.pilha.Pilha;

public class Exer06 {
    public static void main(String[] args) {
        imprimeResultado("A + B");
        imprimeResultado("A + B + (C - D)");
        imprimeResultado("{[()]}[](){()}");
        imprimeResultado("{[(]}[](){()}");
        imprimeResultado("A + B + C - D)");
    }

    final static String ABRE = "([{";
    final static String FECHA = ")]}";

    public static void imprimeResultado(String expressao) {
        System.out.println(expressao + " está balanceado? " + verificaSimbolosBalanceados(expressao));
    }

    public static boolean verificaSimbolosBalanceados(String expressao) {
        // Vamos criar a pilha e aqui vai ser a mesma coisa que fizemos no exercício 05, estamos recebendo uma expressao
        // que é do tipo 'String' e vamos analisar caracter por caracter, por isso a nossa pilha vai ser da classe
        // 'Character', como aqui dentro desse operador de diamante '<>' só podemos utilizar classes Java a gente não
        // pode colocar o tipo primitivo 'char' aqui, então pra isso a gente utiliza a classe wrapper 'Character' que
        // representa um caracter ('char')
        Pilha<Character> pilha = new Pilha<>();

        // Como a gente vai iterar cada caracter você pode fazer isso através de um 'for' ou você pode fazer isso
        // através de um 'while'
        int index = 0;
        char simbolo, topo;

        while (index < expressao.length()) {
            // Obtendo um caracter de um determinado índice
            simbolo = expressao.charAt(index);

            // A gente precisa verificar se esse simbolo é uma abertura de chaves, parênteses ou colchetes
            // O que nós vamos fazer? Nós vamos empilhar na nossa pilha toda vez que for uma abertura de parênteses,
            // chaves ou colchetes, quando for um outro caracter a gente vai ignorar, quando for um caracter de
            // fechamento de parênteses, chaves ou colchetes nós vamos comparar se o que está no topo da pilha é o
            // caracter que abriu, ou seja, é o símbolo respectivo de abertura que a gente estiver utilizando, se sim
            // então a expressão está balanceada, se não a gente sabe que a expressão não está balanceada
            if (ABRE.indexOf(simbolo) > - 1) {
                // Se for um caracter que abre a gente vai empilhar o nosso símbolo
                pilha.empilha(simbolo);
            } else if (FECHA.indexOf(simbolo) > - 1) {
                // Se o caracter for um caracter de fechamento a primeira coisa que a gente precisa fazer é desempilhar
                // então vou verificar se a pilha está vazia, caso a pilha esteja vazia significa que a nossa expressão
                // está desbalanceada
                if (pilha.estaVazia()) {
                    return false;
                } else {
                    // Se a pilha não estiver vazia, então nós vamos desempilhar
                    topo = pilha.desempilha();

                    // Agora nós vamos verificar se o índice do 'FECHA' já que o 'topo' aqui, na verdade, é um caracter
                    // de abertura, se o índice desse símbolo que a gente desempilhou se encontra na mesma posição do
                    // símbolo que a gente acabou de ler do 'FECHA'
                    // Aqui nós podemos negar, então se o índice que estou abrindo o símbolo for diferente do símbolo
                    // que fecha significa que a minha expressão está desbalanceada
                    // Toda vez que eu retornar um 'false' aqui o nosso algoritmo vai parar a execução, ou seja, se eu
                    // já encontrei um símbolo desbalanceado não tem o porque eu continuar com a execução do meu código
                    if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)) {
                        return false;
                    }
                }
            }

            // Se for qualquer outro caracter a gente simplesmente ignora e vai para a próxima posição
            // Vou acrescentar +1 ao 'index' para a gente conseguir ir iterando cada caracter da nossa expressão
            index++;
        }

        return true;
    }
}
