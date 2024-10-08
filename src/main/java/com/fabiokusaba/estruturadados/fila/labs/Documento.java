package com.fabiokusaba.estruturadados.fila.labs;

public class Documento {
    private String nome;
    private int numFolhas;

    public Documento() {
    }

    public Documento(String nome, int numFolhas) {
        this.nome = nome;
        this.numFolhas = numFolhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumFolhas() {
        return numFolhas;
    }

    public void setNumFolhas(int numFolhas) {
        this.numFolhas = numFolhas;
    }
}
