package com.luiz.ed.vetor;

public class Vetor<T> {
    private T[] elementos;

    private int posicaoAtual = 0;

    public Vetor(int tamanho) {
        this.elementos =(T[]) new Object[tamanho];
    }

    public boolean adicionar(T elemento)  {
        aumentarCapacidade();
        if(this.posicaoAtual < this.elementos.length) {
            this.elementos[posicaoAtual] = elemento;
            posicaoAtual++;
            return true;
        } else {
            return false;
        }
        
    }

    public boolean adicionar(int pos ,T elemento) {
        aumentarCapacidade();
        validarPosicao(pos);

        if(this.elementos[pos] != null) {
            for(int i = this.posicaoAtual; i > pos; i--) {
                this.elementos[i] = this.elementos[i-1];
            }
        }

        this.elementos[pos] = elemento;
        posicaoAtual++;

        return true;
    }

    public void remove(int pos) {
        validarPosicao(pos);

        for(int i = pos; i < posicaoAtual-1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        posicaoAtual--;
    }

    public int tamanho() {
        return this.posicaoAtual;
    }

    public T buscar(int pos) throws IllegalArgumentException  {
        validarPosicao(pos);

        return this.elementos[pos];
    }

    public int buscaSequencial(String elemento) {
        for(int i = 0; i < this.tamanho(); i++) {
            if(this.elementos[i].equals(elemento)) {
                return i;
            }
        }

        return -1;
    }

    public void aumentarCapacidade() {
        if(this.posicaoAtual == this.elementos.length) {
            T[] novosElementos =(T[]) new Object[this.elementos.length * 2];

            for(int i = 0; i < this.elementos.length; i++) {
                novosElementos[i] = this.elementos[i];
            }

            this.elementos = novosElementos;
        }
    }

    public void validarPosicao(int pos) {
        if(!(pos >= 0 && pos < this.elementos.length)) {
            throw new IllegalArgumentException("Posição inválida");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        for(int i = 0; i < this.posicaoAtual-1; i++) {
            s.append(this.elementos[i]);
            s.append(",");
        }

        if(this.posicaoAtual > 0) {
            s.append(this.elementos[this.tamanho() - 1]);
        }

        s.append("]");
        
        return s.toString();
    }

}
