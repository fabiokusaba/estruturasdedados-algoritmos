package com.fabiokusaba.estruturadados.vetor;

// Um vetor (ou array) é a estrutura de dados mais simples que existe. Um vetor armazena uma sequência de valores onde
// todos são do mesmo tipo
public class Vetor {

    // Internamente nós vamos utilizar um vetor do Java e podemos declarar do tipo que quisermos
    // Criamos um atributo 'elementos' que vai representar todos os elementos do nosso vetor
    private String[] elementos;

    // Atributo que vai controlar o tamanho real do nosso vetor
    private int tamanho;

    // Vamos criar aqui um construtor e o nosso construtor vamos passar a capacidade de elementos que queremos criar
    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    // Adicionando um elemento no final do vetor
//    public void adiciona(String elemento) {
//        // Como é que a gente faz para poder adicionar um elemento no vetor? O modo mais simples que tem pra gente poder
//        // verificar se a gente pode adicionar um elemento no vetor ou não é verificar quais são os elementos que estão
//        // nulos, por padrão quando a gente instância um vetor de String no Java todos os elementos terão o valor null
//        // que é o valor inicial de uma String no Java
//        // O que a gente pode fazer é iterar o vetor, ou seja, passar por todos os elementos e verificar se esse vetor
//        // tem uma posição nula, se a posição for nula significa que está disponível pra gente poder usar e aí então a
//        // gente adiciona o nosso elemento nessa posição do vetor
//        for (int i = 0; i < this.elementos.length; i++) {
//            if (this.elementos[i] == null) {
//                this.elementos[i] = elemento;
//                // A gente quer que o nosso código pare de ser executado na primeira posição que ele encontrar nula
//                // nesse caso a gente vai utilizar o 'break' para poder frear o loop do for
//                break;
//            }
//        }
//    }

//    public void adiciona(String elemento) throws Exception {
//        // Precisamos antes fazer uma verificação se o tamanho é menor que a capacidade do vetor de elementos
//        if (this.tamanho < this.elementos.length) {
//            // O que a gente precisa fazer aqui basicamente é já que a gente está guardando qual foi a última posição que a
//            // gente guardou um elemento, então podemos fazer:
//            this.elementos[this.tamanho] = elemento;
//
//            // Depois que a gente adicionou o elemento no nosso vetor a gente incrementa 1 no seu valor também
//            this.tamanho++;
//        } else {
//            throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos");
//        }
//    }

    public boolean adiciona(String elemento) {
        // Precisamos antes fazer uma verificação se o tamanho é menor que a capacidade do vetor de elementos
        if (this.tamanho < this.elementos.length) {
            // O que a gente precisa fazer aqui basicamente é já que a gente está guardando qual foi a última posição que a
            // gente guardou um elemento, então podemos fazer:
            this.elementos[this.tamanho] = elemento;

            // Depois que a gente adicionou o elemento no nosso vetor a gente incrementa 1 no seu valor também
            this.tamanho++;

            return true;
        }
        return false;
    }
}
