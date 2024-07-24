package com.saboreando.dados.beans;

public abstract class Interacao {
    private Usuario autor;
    private Postagem postagemRelacionada;

    //Construtor
    public Interacao(Usuario autor, Postagem postagemRelacionada) {
        this.autor = autor;
        this.postagemRelacionada = postagemRelacionada;
    }

    //Gets e Sets
    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}