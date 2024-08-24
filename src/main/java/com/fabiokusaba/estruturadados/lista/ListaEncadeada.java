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

    // Só que o -1 pode ficar um pouco estranho pra quem não está acostumado com isso, então uma dica de código limpo que a gente
    // acaba adotando é declarar uma variável que indique aquilo que a gente queira fazer 
    private final int NAO_ENCONTRADO = -1;

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

    public void adicionaInicio(T elemento) {
        // Aqui novamente a gente tem dois casos: o primeiro caso é se o tamanho é igual a 0 e o segundo caso é o que nós vamos ver
        if (this.tamanho == 0) {
            // Se o tamanho for igual a 0, o que nós vamos fazer? Nós vamos criar esse nó, o início passa a ser esse novo nó, o
            // último passa a ser esse novo nó e claro a gente aumenta o tamanho
            No<T> novoNo = new No<T>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
            
        } else {
            // Se não é aquele caso nós vamos criar o novo nó, se a gente olhar aqui na definição a gente já tem o construtor pra
            // setar o próximo elemento, então existem duas formas de você fazer isso: você pode utilizar o 'setProximo' ou então
            // você pode simplesmente passar direto no construtor
            No<T> novoNo = new No<T>(elemento, this.inicio);
            // novoNo.setProximo(this.inicio);

            // E aí sim o início passa a ser o novo nó
            this.inicio = novoNo;
        }

        this.tamanho++;
    }

    // Aqui nós vamos criar um método que possibilite a gente adicionar em qualquer lugar da nossa lista
    public void adiciona(int posicao, T elemento) {
        // Para esse método a gente vai explorar três cenários diferentes: o primeiro cenário é se a lista está vazia, ou seja, o
        // tamanho da lista é igual a 0, uma outra forma de verificar isso é se o início é nulo
        // A outra opção é a gente verificar, se a lista não está vazia significa que ela tem elementos, e o que eu quero verificar
        // agora é se a posição é igual ao tamanho da lista, ou seja, se eu tenho 4 elementos na minha lista e eu estou adicionando
        // na posição 4 significa que a posição vai ser igual ao tamanho, se a posição for igual ao tamanho significa que eu quero
        // adicionar na última posição então apenas adiciona o elemento, esse é o mais fácil porque já temos o nosso metodo 'adiciona'
        // que adiciona um elemento no final então precisamos apenas chamar ele
        // Mas, agora ainda tem uma outra questão se a posição que estou querendo adicionar posição -1 ou se é maior que o tamanho
        // vai gerar uma exceção, então se a posição for menor que 0 ou se a posição for maior que o tamanho da lista, ou seja, eu
        // tenho 4 elementos mas eu quero adicionar na posição 6, então a gente vai lançar uma exceção
        // Aí sim, aqui no final vai significar que se não é no início e não é no final significa que nós vamos adicionar no meio da
        // lista 
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        // Existem dois casos: se o tamanho da minha lista for 0 é só adicionar no início, agora se o tamanho não for 0 mas a minha
        // posição é 0, ou seja, se a posição for 0 mas a minha lista não está vazia eu quero fazer com que esse nó seja o primeiro
        // elemento, o que a gente vai precisar fazer nesse caso? A gente vai pegar esse novo nó apontar para o início e aí sim a
        // gente faz o início apontar para o novo nó para a gente não perder essas referências
        if (posicao == 0) { // está vazia
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho) { // adiciona
            this.adiciona(elemento);
        } else { // meio
            // A questão é como a gente vai adicionar um elemento quando está no meio, o que a gente está querendo fazer é buscar
            // pela posição então eu vou buscar o nó anterior que na verdade vai buscar a posição que eu estou querendo inserir
            // que é a posição anterior onde eu quero inserir, então aqui eu vou fazer a busca do nó na posição que estou querendo
            // inserir
            No<T> noAnterior = this.buscaNo(posicao);

            // Com essa referência feita eu posso guardar qual que é o próximo nó
            No<T> proximoNo = noAnterior.getProximo();

            // Agora sim, eu já posso criar a minha célula nova
            // E duas opções de novo que você pode fazer: você pode pegar esse novo nó e usar o metodo 'setProximo' ou você pode
            // passar direto no construtor
            No<T> novoNo = new No<T>(elemento, proximoNo);
            // novoNo.setProximo(proximoNo);

            // E agora sim, o nó anterior 'setProximo' vai ser o novo nó
            noAnterior.setProximo(novoNo);

            // E por último nós vamos iterar o tamanho da lista
            this.tamanho++;
        }
    }

    // Remover o elemento do início da lista, para isso vamos ver o conceito primeiro: dado uma lista com 4 elementos nós temos
    // os elementos 1 - 2 - 4 - 5, a gente deseja remover o primeiro elemento dessa lista que no caso do nosso exemplo é o 1
    // então como é que seria? Simplesmente nós vamos pegar o início que antes estava apontando para o número 1 e nós temos que
    // passar o início essa referência do início para o elemento número 2 como é que a gente faz isso? Se o início estava no
    // elemento número 1 é a gente fazer o início receber o próximo e é claro a gente vai ter que diminuir o tamanho também
    // a gente vai ter que validar se a posição existe a gente também vai ter que remover a quantidade de elementos do tamanho
    // da nossa lista, porém o conceito é esse
    public T removeInicio() {
        // A primeira coisa que nós precisamos fazer é verificar se a lista está vazia ou não porque se eu apenas criar a lista
        // e tentar remover o elemento a gente precisa gerar uma exceção porque afinal nós não temos nenhum elemento nessa lista
        if (this.tamanho == 0) {
            // Se o tamanho for igual a 0 significa que não tem elementos e a gente pode lançar uma exceção
            throw new RuntimeException("Lista está vazia.");
        }
        // Guardando a referência do valor do elemento a ser removido
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        // Se o tamanho for igual a 0 depois que eu remover o elemento a gente também tem que remover a referência do último
        // porque se não o último vai continuar apontando para onde estava antes
        // Se a gente tiver apenas um elemento na nossa lista significa que eu tenho apenas um elemento e isso significa que o
        // primeiro elemento o seu próximo já é nulo então o início já vai receber nulo aqui caso seja esse cenário por isso
        // não é necessário colocar o 'this.inicio = null' também
        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        // Ao final retornamos o elemento removido
        return removido;
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

    // A gente não quer expor o nó para fora da nossa classe, então pra isso vamos criar um terceiro metodo ainda e vou retornar
    // aqui um nó, esse metodo vai ser apenas privado
    private No<T> buscaNo(int posicao) {
        // Então, antes de começar a fazer a gente vai precisar verificar se a posição existe
        // Se a posição for maior ou igual a 0, e se a posição for menor ou igual ao tamanho da nossa lista significa que a gente
        // tem uma posição que existe, mas nesse caso eu quero verificar se a posição não existe então basta eu negar a expressão
        if (!(posicao >= 0 && posicao <= this.tamanho)) {
            // Se esse for o caso, a posição não existir, a gente vai lançar uma exceção
            throw new IllegalArgumentException("Posição não existe");
        }

        // E aí sim a gente pode colocar a nossa lógica aqui porque a gente sabe que vai ser uma lógica válida que a gente já fez
        // a verificação aqui em cima
        // Vamos começar a iterar e a gente sabe que a gente vai precisar de um nó atual e note que todos os algoritmos de lista
        // estão começando sempre assim: o nó atual está recebendo o início da nossa lista
        No<T> noAtual = this.inicio;

        // Vou declarar uma variável 'i' que vai começar do 0, ou seja, vai começar do início, a gente vai iterar até a posição
        // que a gente está buscando
        for (int i = 0; i < posicao; i++) {
            // Até a gente chegar uma posição antes daquela que a gente está buscando a gente vai fazer o nó atual receber o
            // seu próximo, ou seja, nós apenas vamos mover o ponteiro de um nó para outro nó
            noAtual = noAtual.getProximo();
        }

        // Quando a gente terminar essa última iteração esse nó atual vai estar apontando pro nó que a gente está buscando, então
        // nesse caso é só retornar o nó atual
        return noAtual;
    }

    // Quando nós tivermos buscando uma posição nós vamos retornar o elemento em si e não o nó, afinal a gente não quer que a
    // pessoa que esteja buscando ache o nó pra poder manusear os ponteiros, as referências a gente quer apenas que essa pessoa
    // tenha acesso ao valor, então aqui nós vamos retornar T porque ele significa qual que é o tipo da nossa lista através do
    // Java Generics
    public T buscaPorPosicao(int posicao) {
        // E aqui a gente vai buscar por posição passando a posição só que ao final a gente vai pegar apenas o elemento
        // Existe um risco aqui se a posição não existir ou se a posição existir e o metodo 'buscaPorPosicao' retornar nulo isso
        // daqui vai dar uma exceção
        return this.buscaNo(posicao).getElemento();
    }

    // O segundo método nós vamos pesquisar se um elemento existe ou não na nossa lista, então aqui nós vamos retornar um inteiro
    // e o Java e outras linguagens tem também uma convenção dos valores que são retornados, também vou chamar de busca só que vou
    // passar qual que é o elemento que estou procurando
    public int busca(T elemento) {
        // No início dele eu quero percorrer a lista toda e pra cada elemento da lista eu vou ter que verificar se o valor do
        // elemento é o elemento que estou procurando
        // Vamos declrar um nó atual que vai receber o primeiro elemento da lista que é o início
        No<T> noAtual = this.inicio;

        // Nada mais natural do que a gente começar a posição com 0 já que no Java qualquer índice começa com 0 de arrays
        int pos = 0;

        // E nós vamos começar a iterar, pra fazer isso nós vamos comparar o nó atual pra ele ser diferente de nulo, lembrando
        // que quando a nossa lista termina o nó que nós estamos iterando, o nó que estamos utilizando para iteração vai ter o
        // valor de nulo, então é assim que a gente sabe quando sair desse loop while
        while (noAtual != null) {
            // Só que antes a gente vai comprar se esse nó é o nó que tem o elemento que estamos procurando, só que no Java não
            // adianta você fazer o '==' aqui, lembra que no Java o '==' faz a comparação da referência, ou seja, o Java vai
            // comparar se o endereço da memória desse elemento é o mesmo endereço da memória de onde nós estamos guardando esse
            // nó atual aqui e lembrando que você pode ter objetos com exatamente os mesmos valores, porém eles são duplicados e
            // estão guardados em lugares diferentes na memória, então é por isso que quando a gente faz comparação a gente vai
            // utilizar o metodo equals, nesse caso qualquer objeto que você esteja tipando aqui vai ser recomendado que essa
            // classe tenha a implementação do metodo equals é por isso no Java quando a gente declara uma classe nova sempre é
            // recomendado você implementar o metodo equals justamente para casos como esse
            if (noAtual.getElemento().equals(elemento)) {
                // Então, se achou nós vamos retornar a posição só que pra gente poder ter essa posição a gente também precisa
                // fazer o tracking a gente precisa guardar qual posição que nós estamos iterando
                return pos;
            }
            // Se a gente não achou nós vamos iterar a posição através do 'pos++' que seria a mesma coisa que: 'pos += 1'
            // 'pos = pos + 1'
            pos++;

            // E pra poder mover esse nó atual a gente sempre vai pegar o nó atual e pegar o seu próximo
            noAtual = noAtual.getProximo();
        }
        // E se não achar? O zero aqui está representando o primeiro elemento e a nossa lista pode ter mais de um elemento, então
        // está esperando aqui um valor positivo ou zero, a convenção de várias linguagens de programação é retornar o -1 que caso
        // não encontre
        return NAO_ENCONTRADO;
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
