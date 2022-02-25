package com.luiz.ed.teste;

import com.luiz.ed.vetor.Vetor;

public class Vetorteste {
    public static void main(String[] args) {
        Vetor<String> v = new Vetor<>(3);

        v.adicionar("Flamengo");
        v.adicionar("Casimiro");
        v.adicionar("Eu");
        v.adicionar("Vasco");

        System.out.println(v);

    }
    
    
}
