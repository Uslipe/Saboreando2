package com.saboreando.dados.beans;

public class Comentario extends Interacao {
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

    // Método para obter a postagem relacionada de uma interação
    public Postagem getPostagemRelacionada(Interacao interacao) {
        return interacao.getPostagemRelacionada();
    }
}
