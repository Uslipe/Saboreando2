package com.saboreando;

import java.util.List;

public class Postagem{
    private Usuario autorPostagem;
    private String conteudo;
    //private List<Curtida> curtidas;
    //private List<Comentario> comentarios;
    //private int qntCurtidas;

    //Construtor
    public Postagem(Usuario autor, String conteudo){
        this.autorPostagem = autor;
        this.conteudo = conteudo;
    }

    //Gets e Sets
    public Usuario getAutorPostagem() {
        return autorPostagem;
    }

    public void setAutorPostagem(Usuario autorPostagem) {
        this.autorPostagem = autorPostagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    
}