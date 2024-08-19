package com.fabiokusaba.estruturadados.lista;

// Listas encadeadas ou listas ligadas são estruturas dinâmicas, cada elemento que nós temos dentro da nossa estrutura
// de dados é um nó ou uma célula e por se tratar de uma estrutura dinâmica vamos lidar com ponteiros, mas o Java já tem
// a parte de ponteiros completamente embutida pra gente facilitando a gente trabalhar com essa estrutura, já que a gente
// vai passar a lidar apenas com referências de objetos
// Uma coisa que é diferente das estruturas estáticas que trabalhamos em módulos passados é que aqui a gente guarda apenas
// a referência do primeiro elemento nós vamos guardar também a referência do último elemento, mas não existe uma maneira
// super simples da gente ir diretamente no elemento que está no meio da lista, a gente precisa percorrer todos os elementos
// que estão na nossa lista até a gente chegar naquele elemento desejado
// E porque a gente precisa percorrer a lista e também nós só temos referência ao primeiro elemento nós também vamos guardar
// uma referência para o próximo elemento da nossa lista
// Em uma lista encadeada nós temos o elemento inicial, cada elemento é um nó ou uma célula, cada nó é composto do próprio
// elemento do valor que a gente está querendo guardar na memória e além disso a gente também tem uma referência para o
// próximo elemento e sabemos quando uma lista terminou quando o próximo elemento dela é um valor nulo
// Novamente a gente vai precisar também tipar de forma genérica a nossa lista encadeada, afinal a gente pode ter uma lista
// de números, strings, objetos e etc
public class ListaEncadeada<T> {
    // Cada lista tem um nó e esse nó ou célula tem duas informações
    private No<T> inicio;

    // O próximo passo é criarmos o nosso primeiro metodo para poder adicionar um elemento
    // Aqui nesse metodo o nó é algo interno nosso, então para quem vai usar essa lista a única coisa que importa é o objeto
    // é o valor
    // O que é que precisa ser feito? Então quando a gente insere do início inicialmente a nossa lista vai estar vazia, ou seja,
    // aquele atributo de início vai apontar pra nulo porque a gente não instânciou nenhum nó ainda e nós vamos criar primeiro
    // o nosso elemento que é essa caixinha com o valor
    public void adiciona(T elemento) {
        // Primeiro vou declar um nó do tipo T e vou precisar instânciar esse nó com o elemento
        No<T> celula = new No<T>(elemento);

        // O que a gente precisa fazer é apontar o 'inicio' para esse nó que acabamos de criar, ou seja, o 'inicio' vai passar a
        // apontar para o nosso nó e assim a nossa lista vai ter um elemento adicionado
        // Quando a gente faz isso, lembrando que no Java nós estamos trabalhando apenas com as referências que nos diagramas são
        // as setinhas
        this.inicio = celula;
    }

    @Override
    public String toString() {
        return "ListaEncadeada [inicio=" + inicio + "]";
    }

    
}
