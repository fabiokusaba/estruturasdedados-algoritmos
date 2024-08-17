package com.fabiokusaba.estruturadados.vetor.teste;

import java.util.ArrayList;

// A maioria das Collections que é como nós chamamos as estruturas de dados prontas do Java pertencem a esse pacote
// 'java.util'
public class Aula12 {
    public static void main(String[] args) {
        // O Java permite que a gente faça como opção de construtor a gente já pode passar como valores iniciais pra
        // nossa classe então se você quiser já passar elementos iniciais pode, você pode instânciar sem nada só
        // criando mesmo a classe ou você pode passar também uma capacidade inicial
        // Tanto faz você utilizar a capacidade inicial ou construtor vazio porque essa classe ArrayList ela também
        // cresce a medida que for necessário
        ArrayList<String> arrayList = new ArrayList<String>();

        // Adicionar um elemento nesse array
        arrayList.add("A");
        arrayList.add("C");
        System.out.println(arrayList);

        // Adicionar um elemento numa posição específica
        arrayList.add(1, "B");
        System.out.println(arrayList);

        // Buscando um elemento no array
        boolean existe = arrayList.contains("A");
        if (existe) {
            System.out.println("Elemento existe no array");
        } else {
            System.out.println("Elemento nao existe no array");
        }

        // Descobrindo o índice de um elemento do array
        int pos = arrayList.indexOf("D");
        if (pos > - 1) {
            System.out.println("Elemento existe no array na pos " + pos);
        } else {
            System.out.println("Elemento nao existe no array na pos " + pos);
        }

        // O busca por posição no ArrayList é através do metodo 'get', se você passar uma posição que não existe no
        // array ele lançará uma exceção 'IndexOutOfBoundsException'
        System.out.println(arrayList.get(2));

        // Para remover um elemento nós temos duas opções: nós temos a opção passando o índice e nós temos o 'remove'
        // passando o objeto
        arrayList.remove(0);
        arrayList.remove("B");
        System.out.println(arrayList);

        // O tamanho no ArrayList é através do 'size'
        System.out.println(arrayList.size());
    }
}
