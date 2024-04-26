package com.saboreando.dados.beans;

public class Comentario extends Interacao {
    private String texto;

    public Comentario(Usuario autor, String texto) {
        super(autor);
        this.texto = texto;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
