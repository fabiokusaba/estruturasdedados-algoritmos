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
    // Esse 'inicio' a gente não gera nem o get e nem o set porque nós que queremos ter o controle, então esse controle dos
    // valores que vão ser atribuídos pra esse atributo serão apenas internamente isso não vai ser exposto pra quem for
    // utilizar a nossa API a nossa lista encadeada
    private No<T> inicio;

    // Mantendo uma referência para o último nó ou o último elemento, agora nós temos duas referências
    private No<T> ultimo;

    // A gente quer fazer o controle de quantos nós a gente tem porque afinal se a gente tiver 10 elementos a gente não quer
    // percorrer toda a lista pra poder ficar contando quantos elementos a gente tem porque isso seria muito custoso do ponto de
    // vista computacional e como alternativa pra ter essa informação sempre disponível pra gente nós vamos criar aqui mais um
    // atributo/variável pra poder ajudar a gente a fazer esse controle 
    // Por padrão aqui no Java valores primitivos eles sempre começam com 0, mas se a gente quiser deixar isso explícito podemos
    // atribuir o valor 0
    // A gente sempre vai levar em consideração essa variável sempre que a gente adicionar elementos ou remover elementos também
    private int tamanho = 0;

    // O próximo passo é criarmos o nosso primeiro metodo para poder adicionar um elemento
    // Aqui nesse metodo o nó é algo interno nosso, então para quem vai usar essa lista a única coisa que importa é o objeto
    // é o valor
    // O que é que precisa ser feito? Então quando a gente insere do início inicialmente a nossa lista vai estar vazia, ou seja,
    // aquele atributo de início vai apontar pra nulo porque a gente não instânciou nenhum nó ainda e nós vamos criar primeiro
    // o nosso elemento que é essa caixinha com o valor
    public void adiciona(T elemento) {
        // Primeiro vou declar um nó do tipo T e vou precisar instânciar esse nó com o elemento
        No<T> celula = new No<T>(elemento);

        // Se o tamanho for igual a 0 a gente vai pegar o início e vai apontar para esse novo elemento e além disso a gente vai
        // pegar o último e apontar para a nossa célula
        // Se não for, agora se a nossa lista não estiver vazia, tiver alguma informação o que nós vamos fazer? Nós vamos pegar
        // esse último e setar o próximo elemento pra nossa célula
        // E no final a gente apenas move o ponteiro do último pra célula e a gente também incrementa esse valor
        if (this.tamanho == 0) {
            // O que a gente precisa fazer é apontar o 'inicio' para esse nó que acabamos de criar, ou seja, o 'inicio' vai passar a
            // apontar para o nosso nó e assim a nossa lista vai ter um elemento adicionado
            // Quando a gente faz isso, lembrando que no Java nós estamos trabalhando apenas com as referências que nos diagramas são
            // as setinhas
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }

        // Quando a gente insere um elemento o que está acontecendo aqui? Eu tenho esse elemento e estou pegando o início e
        // apontando pra esse elemento e o que nós precisamos fazer é também apontar o último ou final para esse mesmo elemento
        // então se a nossa lista tiver apenas um nó nós vamos ter tanto o início quanto o último apontando pra esse único elemento
        this.ultimo = celula;

        // E agora a gente quer adicionar um segundo elemento então o que precisa acontecer pra gente poder ligar esse elemento pra
        // esse segundo elemento? Nós vamos pegar o 'ultimo.proximo' e a gente vai ligar para a nossa célula e depois que a gente
        // fizer isso a gente vai remover, pegar esse último e a gente vai passar esse último e apontar para o elemento que a gente
        // acabou de adicionar na lista
        // Só que tem uma coisa muito importante do jeito que o nosso código está o início também está apontando para a célula, então
        // a gente precisa verificar se o tamanho da nossa lista está vazio a gente atualiza o início, se não a gente atualiza a parte
        // do último

        // E agora que a gente tem esse 'tamanho' também a gente tem o metodo 'adiciona' o que a gente pode fazer também é pegar
        // o 'tamanho' e incrementar o seu valor em 1
        this.tamanho++;

        // Para inserirmos um elemento no final da nossa lista encadeada o que precisa acontecer é pegar o início, o primeiro
        // primeiro elemento que nós temos, e apontar a propriedade 'proximo' para o novo nó, ou seja, 'inicio.proximo = novo Nó'
        // Porém, se a gente quiser adicionar um terceiro elemento como isso vai funcionar? Nós temos o início apontando para o
        // elemento n.1, e ao tentarmos adicionar o elemento n.3 a gente não pode mais fazer 'inicio.proximo' apontar para o novo
        // Nó porque se não a gente vai acabar perdendo o nó n.2, nesse caso o que deveria ser feito é: 'inicio.proximo' que está
        // apontando para o nó n.2 apontar para o próximo, ou seja, 'inicio.proximo.proximo' apontar para o novo nó só que
        // dependendo da quantidade de elementos que nós temos na nossa lista a gente teria que percorrer até o final da lista
        // O que nós vamos fazer então? Além de manter a referência para o primeiro elemento da nossa lista a gente também vai
        // manter a referência do último elemento da nossa lista, dessa forma quando a gente for adicionar o terceiro elemento tudo
        // o que a gente precisa fazer é pegar o 'ultimo.proximo' e apontar para o novo nó, e além disso a gente também teria que
        // pegar e atualizar a referência do último elemento para agora o elemento n.3 porque afinal se a gente tentar adicionar um
        // elemento de n.4, por exemplo, a gente vai também ter essa referência e assim a gente consegue adicionando elementos na
        // nossa lista sempre no final
    }

    // Além disso, vou criar também um metodo para retornar esse 'tamanho', lembrando que não temos um set para esse 'tamanho'
    // porque essa variável vai ficar disponível apenas internamente pra gente
    public int getTamanho() {
        return this.tamanho;
    }

    // Como é que a gente remove todos os itens de uma lista encadeada? Seria muito simples se a gente apenas atribuísse o valor de
    // nulo para o início da lista, dessa maneira todos os outros elementos vão ficar perdidos na memória e a nossa lista vai voltar
    // para tamanho 0, essa é uma das implementações que você pode fazer e também seria a forma mais simples da gente fazer isso
    // Só que a gente sempre tenta fazer as coisas da melhor forma que a gente pode, então nesse caso o que nós vamos fazer é tentar
    // seguir o próprio código da lista encadeada do Java, nós vamos percorrer toda a lista e a gente vai atribuir o valor nulo para
    // cada elemento, por que a gente precisa fazer isso? Isso apenas vai otimizar a memória do Java e vai fazer com que os elementos
    // já fiquem disponíveis pra o limpador de lixo (Garbage Collector do Java), então isso acaba otimizando e acelerando um pouco
    // mais a limpeza da memória
    public void limpa() {
        // A outra forma que também é a forma que o Java faz a limpeza da lista encadeada é percorrer toda a lista e atribuir o nulo
        // também pra essa variável
        // O loop for consiste de três partes: a primeira parte onde nós declaramos e inicializamos a variável, a segunda parte é onde
        // colocamos a nossa condição para poder sair do loop e a terceira parte é onde a gente pode, por exemplo, incrementar essa
        // variável
        for (No<T> atual = this.inicio; atual != null;) {
            // Declarando um segundo nó auxiliar que vou chamar de próximo e ele sempre vai ser o 'atual.getProximo'
            No<T> proximo = atual.getProximo();

            // Setando os valores para nulo
            atual.setElemento(null);
            atual.setProximo(null);

            // Pegando o atual e atribuindo a variável próximo
            atual = proximo;

            // E com isso vamos iterar a lista inteira e limpar pra gente
        }

        // A maneira mais simples: para limpar a lista a gente precisaria incluir nulo pro início, atribuir nulo pro último e o
        // tamanho também ficaria com 0
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // Imagine o seguinte problema: dado uma lista encadeada você quer percorrer cada elemento e a gente quer imprimir na tela o
    // valor de cada elemento como é que a gente pode fazer isso? Pra gente poder fazer isso a gente vai começar com uma referência
    // que a gente também chama de vez em quando de ponteiro, geralmente vai ser uma variável chamada 'atual', e essa variável 'atual'
    // nós vamos atribuir o valor início ou o primeiro elemento da nossa lista
    // Dado o elemento atual enquanto o seu próximo for diferente de nulo, ou seja, tiver um próximo elemento a gente consegue obter
    // o próximo elemento movendo esse ponteiro, ou seja, atribuindo o valor de 'atual.proximo' para 'atual', e quando o 'atual.proximo'
    // for nulo, ou seja, ele não estiver apontando para nada nesse caso não tem mais o que a gente percorrer sai do loop, sai da
    // iteração e a gente conseguiu percorrer toda a lista
    @Override
    public String toString() {
        // A primeira coisa que a gente vai fazer é se a lista estiver vazia, inclusive posso fazer essa verificação primeiro para
        // evitar instânciar variáveis que não são necessárias
        if (this.tamanho == 0) {
            // O que nós vamos retornar vai ser apenas um array vazio
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        // Se não, a gente começa a nossa lógica
        // A primeira coisa que a gente vai fazer é declarar uma variável atual que vai receber o inicio porque precisamos começar
        // de algum lugar se fosse iterar isso aqui num array a gente começaria da posição 0 e nesse caso a posição 0 é o início e
        // aqui a gente consegue garantir já que a lista não está vazia pelo menos um elemento nós vamos ter
        No<T> atual = this.inicio;

        // Depois a gente vai colocar aqui o while que é o enquanto, então enquanto o 'atual.getProximo' for diferente de nulo a
        // gente faz algo
        // Mas, antes disso a gente precisa obter esse valor aqui que está no atual que é o primeiro, então aqui nós vamos fazer o
        // append do valor que está no nosso nó e além disso vou fazer o append da vírgula só pra poder separar o nosso elemento
        /* builder.append(atual.getElemento()).append(",");

        while (atual.getProximo() != null) {
            // Ou seja, nós vamos mover para o próximo elemento
            atual = atual.getProximo();

            // Movendo para o próximo elemento nós vamos repetir esse trecho de código aqui porque aí nós já vamos estar no segundo
            // elemento
            builder.append(atual.getElemento()).append(",");
        } */

        // Aqui no Java a gente tem o loop for também que a gente consegue fazer isso com uma forma um pouco mais elegante, dado que
        // o tamanho é diferente de 0 a gente pode colocar um for
        // Eu vou pegar o tamanho até o 'tamanho - 1', ou seja, parar no penúltimo elemento da minha lista, quando for o penúltimo
        // elemento da minha lista esse 'atual.getProximo' para no penúltimo e o que a gente consegue fazer? A gente consegue fazer
        // apenas esse append do último elemento
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }

        builder.append(atual.getElemento()).append("]");

        // E no final a gente consegue retornar a nossa String
        return builder.toString();
    }

    
}
