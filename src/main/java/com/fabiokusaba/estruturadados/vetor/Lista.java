package com.fabiokusaba.estruturadados.vetor;

import java.lang.reflect.Array;

// A partir do Java 5 foi introduzido a funcionalidade de Generics para trabalharmos com tipos genéricos, ou seja, de
// qualquer tipo de classe ou objeto no Java o mesmo princípio também é aplicado na classe ArrayList que é a estrutura
// de dados nativa do Java
// Nós vamos utilizar um recurso do Java chamado Generics onde nós podemos na declaração da nossa 'Lista' passar qual
// que é o tipo de classe que a gente quer que esse vetor trabalhe, ou seja, vai ser um tipo só de inteiro, vai ser um
// tipo só de String, vai ser um vetor só de Contato, com que classe nós vamos trabalhar com esse vetor e para isso nós
// vamos passar dentro da simbologia do Generics que é o '<>' (operador "diamond" (diamante)) passando aqui dentro 'T'
// que significa o class type
public class Lista<T> {
    private T[] elementos;
    private int tamanho;

    // A solução trazida no livro Effective Java para podermos instânciar um vetor de tipo genérico é criarmos o vetor
    // do tipo Object e aqui a gente faz o casting para o tipo que a gente precisa fazer que é o tipo que foi declarado
    // aqui
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Reflection no Java é uma API que deixa você acessar dinâmicamente as classes que você tem no seu projeto, os
    // atributos que você tem no seu projeto e você pode manipular essa informação
    // Para você poder instânciar um vetor passando o tipo dinâmicamente no Java é preciso passar o tipo também como
    // parâmetro do nosso construtor
    public Lista(int capacidade, Class<T> tipoClasse) {
        // E aqui utilizando reflection:
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(T elemento, int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();

        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            // A mesma coisa que fizemos lá em cima, continua instânciando um vetor de objeto, porén faz o casting pra
            // classe
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];

            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }

            this.elementos = elementosNovos;
        }
    }

    // A gente está criando um novo metodo reutilizando uma lógica que já existe para caso o usuário precise com outro
    // nome, porém que já faz a mesma coisa de um metodo existente na nossa classe
    public T obtem(int posicao) {
        return this.busca(posicao);
    }

    public T busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        return this.elementos[posicao];
    }

    public int busca(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public int ultimoIndice(T elemento) {
        // Existem diferentes maneiras da gente poder fazer essa lógica, a primeira delas seria:
//        int ultimaPos = -1;
//        for (int i = 0; i < this.tamanho; i++) {
//            if (this.elementos[i].equals(elemento)) {
//                ultimaPos = i;
//            }
//        }

        // Uma maneira da gente fazer isso aqui muito mais rápido ao invés de iterar esse array do início dele até o
        // final é fazer justamente o contrário começar a iteração do final até chegar a posição 0, assim a gente teria
        // essa mesma lógica e a primeira vez que ele encontrar o elemento a gente já pode retornar o índice já que a
        // gente vai estar iterando de trás pra frente e não de frente para trás como a gente fez no metodo 'busca'
        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        // Se não existir o elemento vou retornar -1
        return -1;
    }

    public boolean contem(T elemento) {
//        int pos = busca(elemento);
//        if (pos > -1) {
//            return true;
//        }
//        return false;

        return busca(elemento) > -1;
    }

    public void  remove(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
    }

    // Uma forma bem simples da gente sobrecarregar o nosso metodo modificando aqui o tipo de parâmetro que ele utiliza
    public void remove(T elemento) {
        // A gente pode utilizar o metodo 'busca' para poder ver se o elemento existe dentro do vetor
        int pos = this.busca(elemento);

        // E se caso ele existe a gente pode fazer a remoção passando então o índice para esse metodo 'remove'
        if (pos > -1) {
            this.remove(pos);
        }
    }

    public void limpar() {
        // Existem três maneiras que a gente pode fazer isso: a primeira delas seria instânciar o elemento e assim
        // a gente teria um novo vetor, nesse caso como o vetor de elementos está fazendo referência para um novo objeto
        // os elementos que estavam no outro vetor e todas as referências vão ficar livres para que o coletor de lixo
        // do Java possa varrer a memória e possa limpar todos aqueles objetos da memória
//        this.elementos = (T[]) new Object[this.elementos.length];

        // A opção número 2 seria fazer o que? A gente poderia resetar o 'tamanho' para 0 e todos os elementos que já
        // tiverem dentro do nosso array ficariam ali como uma espécie de lixo
//        this.tamanho = 0;

        // E uma terceira opção envolve também em colocar o 'tamanho' igual a 0 só que envolveria a gente atribuir o
        // valor nulo para todas as posições do elemento, dessa forma a gente também vai perder a referência de todos os
        // valores que estão dentro do array e caso forem objetos os mesmos ficam disponíveis pro coletor de lixo do
        // Java
        // Dependendo do tamanho do vetor que você tiver essa pode ser a melhor opção porque a gente está também
        // liberando várias referências na memória pro coletor de lixo do Java
        for (int i = 0; i < this.tamanho; i++) {
            this.elementos[i] = null;
        }
        this.tamanho = 0;
    }

    // Metodo responsável por retornar o tamanho do nosso vetor
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
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
