package com.fabiokusaba.estruturadados.fila.teste;

import com.fabiokusaba.estruturadados.fila.FilaComPrioridade;
import com.fabiokusaba.estruturadados.fila.Paciente;

public class Aula24 {
    public static void main(String[] args) {
        FilaComPrioridade<Paciente> fila = new FilaComPrioridade<>();

        fila.enfileira(new Paciente("A", 2));
        fila.enfileira(new Paciente("C", 1));
        fila.enfileira(new Paciente("B", 3));

        System.out.println(fila); // 1 2 3 e não 1 3 2

        System.out.println(fila.desenfileira());

        System.out.println(fila);
    }
}
