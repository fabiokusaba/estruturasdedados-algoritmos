package com.fabiokusaba.estruturadados.vetor.labs;

import com.fabiokusaba.estruturadados.vetor.Lista;

import java.util.ArrayList;

public class Exer02 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>(5);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        // O metodo 'lastIndexOf' do ArrayList retorna o índice da última ocorrência do elemento especificado na lista
        // ou então retorna -1 se essa lista não contém o elemento
        System.out.println(arrayList.lastIndexOf("A"));

        Lista<String> lista = new Lista<String>(5);
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("A");

        System.out.println(lista.ultimoIndice("A"));
    }
}
