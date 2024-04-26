package com.saboreando.dados.beans;

public abstract class Interacao {
    private Usuario autor;

    //Construtor
    public Interacao(Usuario autor) {
        this.autor = autor;
    }

    //Gets e Sets
    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}