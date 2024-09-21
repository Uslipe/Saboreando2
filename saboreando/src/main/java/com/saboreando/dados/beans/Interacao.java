package com.saboreando.dados.beans;

import java.io.Serializable;

public abstract class Interacao implements Serializable{
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

    public Postagem getPostagemRelacionada() {
        return postagemRelacionada;
    }

    public void setPostagemRelacionada(Postagem postagemRelacionada) {
        this.postagemRelacionada = postagemRelacionada;
    }

}