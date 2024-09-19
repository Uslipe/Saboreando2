package com.saboreando.dados.beans;

import java.io.Serializable;

public class Curtida extends Interacao implements Serializable{

    public Curtida(Usuario autor, Postagem postagemRelacionada) {
        super(autor, postagemRelacionada);
    }
    
    //Obter autor da interação
    public Usuario getAutor(Interacao interacao){
        return interacao.getAutor();
    }

    // Método para obter a postagem relacionada de uma interação
    public Postagem getPostagemRelacionada(Interacao interacao) {
        return interacao.getPostagemRelacionada();
    }

    public String toString(){
        return "Curtida:\n" + "Autor: " + getAutor() + "Postagem: " + getPostagemRelacionada();
    }
}
