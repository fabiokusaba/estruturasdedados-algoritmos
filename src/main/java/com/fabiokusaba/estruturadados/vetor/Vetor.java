package com.fabiokusaba.estruturadados.vetor;

// Um vetor (ou array) é a estrutura de dados mais simples que existe. Um vetor armazena uma sequência de valores onde
// todos são do mesmo tipo
public class Vetor {

    // Internamente nós vamos utilizar um vetor do Java e podemos declarar do tipo que quisermos
    // Criamos um atributo 'elementos' que vai representar todos os elementos do nosso vetor
    private String[] elementos;

    // Vamos criar aqui um construtor e o nosso construtor vamos passar a capacidade de elementos que queremos criar
    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
    }
}
