package com.saboreando.dados.beans;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Comentario extends Interacao implements Serializable {
    private String texto;

    public Comentario(Usuario autor, Postagem postagemRelacionada, String texto) {
        super(autor, postagemRelacionada);
        this.texto = texto;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //Obter autor da interação
    public Usuario getAutor(){
        return super.getAutor();
    }

    // Método para obter a postagem relacionada de uma interação
    public Postagem getPostagemRelacionada() {
        return super.getPostagemRelacionada();
    }

    //To String
    public String toString(){
        return "\nAutor: " + this.getAutor().getUsername() + "\nPostagem: " + this.getPostagemRelacionada() + "\nTexto: " + this.getTexto() + "\n";
    }
}
