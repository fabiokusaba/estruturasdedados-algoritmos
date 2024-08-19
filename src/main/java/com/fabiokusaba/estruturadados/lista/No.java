package com.fabiokusaba.estruturadados.lista;

// O nosso nó vai ser um tipo objeto e esse tipo objeto pode ser qualquer coisa e da mesma forma que fizemos
// nos módulos passados nós utilizamos os tipos genéricos do Java pra gente poder tipar qual que é o tipo
// porque a gente não sabe se isso vai ser uma String, um número, um objeto, pode ser qualquer coisa e a gente
// apenas vai definir isso quando a gente for instânciar a nossa lista
public class No<T> {
    // O elemento é onde vamos guardar o valor que poderá ser de qualquer tipo
    private T elemento;

    // Aqui a gente também vai ter um outro atributo que vai ser o 'proximo' porque a gente precisa também guardar
    // referência do próximo nó e esse nó também vai ser do mesmo tipo do nosso elemento
    private No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(T elemento, No<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [elemento=" + elemento + ", proximo=" + proximo + "]";
    }
}
