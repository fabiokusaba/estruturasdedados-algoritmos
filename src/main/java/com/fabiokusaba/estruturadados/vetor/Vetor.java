package com.fabiokusaba.estruturadados.vetor;

import java.util.Arrays;

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

    // Metodo responsável por adicionar um elemento no vetor
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

    // No nosso metodo de busca a gente quer obter um elemento de uma determinada posição, então aqui no retorno do
    // nosso metodo precisa ser o tipo de um elemento do nosso vetor que a gente declarou originalmente como String
    public String busca(int posicao) {
        // Aqui no nosso metodo de busca precisamos fazer um tratamento um pouco melhor para garantir que na hora que o
        // usuário utilizar não vai dar uma exceção a gente só quer liberar uma exceção quando realmente for preciso
        // As posições que existem dentro desse vetor que tem elementos é que a posição precisa ser maior igual a zero
        // já que o nosso índice começa a partir do zero e a posição ela também tem que ser menor que o tamanho e essas
        // são as posições que existem no nosso vetor, se a gente negar toda essa expressão a gente tem o range de todas
        // as posições que não podem ser acessadas
        // Quando a posição não poder ser acessada podemos lançar uma Exception
        // A IllegalArgumentException é uma exceção especial no Java para tipos de argumentos que são inválidos
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        // Se cair dentro de uma posição que existe no nosso vetor a gente retorna o elemento desejado
        return this.elementos[posicao];
    }

    // Implementar um metodo para descobrir/verificar se um determinado elemento existe no vetor
    // Quando a gente quer verificar se um elemento existe ou não dentro de uma determinada coleção a gente pode
    // retornar um booleano pra identificar se aquele elemento existe ou não
    // Porém, existe uma maneira um pouquinho mais elegante da gente fazer isso aqui ao invés de retornar true ou false
    // que é retornando a própria posição do vetor
    public int busca(String elemento) {
        // Nesse caso vamos fazer um algoritmo de busca e o algoritmo de busca mais simples que existe é o algoritmo
        // chamado busca sequencial, o que acontece nesse algoritmo? A gente vai posição em posição do nosso vetor e a
        // gente vai verificar se aquele elemento é o elemento que a gente está procurando
        for (int i = 0; i < this.tamanho; i++) {
            // Lembrando que como a String é um objeto a gente não pode utilizar o comparador de igualdade '==' no Java
            // a gente precisa utilizar o metodo 'equals', como é String a gente tem duas opções: a gente tem o metodo
            // 'equals' e o metodo 'equalsIgnoreCase', o 'equalsIgnoreCase' não vai levar em consideração se a letra é
            // maiúscula ou minúscula
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    // Metodo responsável por retornar o tamanho do nosso vetor
    public int tamanho() {
        return this.tamanho;
    }

    // O Java possui uma classe utilitária chamada Arrays que serve para a gente poder trabalhar com coleções de objetos
    // como, por exemplo, vetores. Essa classe Arrays possui o metodo 'toString' onde nós podemos passar um vetor de
    // elementos e ela retorna todos os elementos do Array
    @Override
    public String toString() {
        // O que a gente precisa fazer aqui é iterar por todos os elementos do nosso vetor e adicionar na nossa String
        // Para deixar o nosso código mais eficiente vamos fazer a concatenação dos nossos elementos utilizando a classe
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(this.elementos[i]);
            sb.append(", ");
        }

        if (this.tamanho > 0) {
            sb.append(this.elementos[this.tamanho - 1]);
        }

        sb.append("]");
        return sb.toString();
    }
}
