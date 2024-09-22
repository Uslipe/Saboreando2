package com.saboreando.dados.beans;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Curtida extends Interacao implements Serializable{

    public Curtida(Usuario autor, Postagem postagemRelacionada) {
        super(autor, postagemRelacionada);
    }
    
    //Obter autor da interação
    public Usuario getAutor(){
        return super.getAutor();
    }

    // Método para obter a postagem relacionada de uma interação
    public Postagem getPostagemRelacionada() {
        return super.getPostagemRelacionada();
    }

    public String toString(){
        return "Curtida:\n" + "Autor: " + getAutor() + "Postagem: " + getPostagemRelacionada();
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getAutor().equals(((Curtida)obj).getAutor()) && this.getPostagemRelacionada().equals(((Curtida)obj).getPostagemRelacionada())){
            return true;
        }
        return false;
    }
}
