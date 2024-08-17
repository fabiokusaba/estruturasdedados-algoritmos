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
        this.aumentaCapacidade();

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

    // Adicionando elemento em qualquer posição do vetor aqui nós vamos fazer um overloading, ou seja, vamos
    // sobrecarregar o metodo 'adiciona' passando como parâmetros o 'elemento' e a 'posição' que queremos adicionar
    public boolean adiciona(String elemento, int posicao) {
        // Primeira coisa que a gente precisa fazer é verificar se a posição que o usuário está passando para esse
        // metodo é uma posição válida
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        this.aumentaCapacidade();

        // Agora podemos pensar na lógica para mover os elementos, para a gente mover os elementos vamos utilizar um for
        // para iterar o nosso vetor, aqui dentro do nosso for o nosso 'i' não vai de 0 até o length do nosso vetor como
        // a gente está acostumado a fazer nos outros códigos, nós vamos inicializar o 'i' com uma outra variável aqui
        // nós vamos inicializar ela com o valor do nosso 'tamanho' e a variável 'i' precisa ser maior ou igual a
        // posição que a gente está passando já que a gente foi até o índice da posição que a gente desejava e moveu os
        // elementos daquela posição pra frente e ao invés de incrementar nós vamos decrementar já que a gente está
        // iterando o vetor de trás pra frente
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            // Agora vamos focar na nossa lógica de mover os elementos
            this.elementos[i + 1] = this.elementos[i];
        }

        // Depois de mover todos os elementos a gente só precisa atribuir o elemento para a posição
        this.elementos[posicao] = elemento;

        // E também adicionamos 1 para o nosso tamanho
        this.tamanho++;

        return true;
    }

    // Aumentar capacidade no vetor, como esse metodo vai ser utilizado apenas internamente na nossa classe Vetor vou
    // declarar ele como privado
    private void aumentaCapacidade() {
        // Precisamos verificar quando é que vamos aumentar a capacidade do vetor? É sempre que o nosso 'tamanho' do
        // vetor for igual ao length do vetor que é a capacidade que o vetor tem
        if (this.tamanho == this.elementos.length) {
            // Como é que a gente faz isso? Declarando um novo vetor já que o nosso vetor de elementos é do tipo String
            // então vou declarar um vetor de String e vou chamá-lo de 'elementosNovos' e vou instânciá-lo
            // E o que passo aqui? Capacidade + 1? A melhor forma da gente fazer aqui é sempre dobrando a capacidade do
            // vetor
            String[] elementosNovos = new String[this.elementos.length * 2];

            // O que vamos fazer aqui é muito simples, vamos iterar o nosso vetor
            for (int i = 0; i < this.elementos.length; i++) {
                // O que a gente vai fazer? Basicamente a gente vai atribuir a posição 0 do 'elementosNovos' o que está
                // na posição 0 do nosso vetor
                elementosNovos[i] = this.elementos[i];
            }

            // O que nós vamos fazer então é atribuir esse novo vetor ao nosso vetor e lembrando que esse código só vai
            // ser executado quando atingirmos a capacidade
            this.elementos = elementosNovos;
        }
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
