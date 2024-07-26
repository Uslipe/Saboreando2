package com.saboreando.dados.beans;

import java.util.List;

public class Postagem{
    private Usuario autorPostagem;
    private String conteudo;

    //Construtor
    public Postagem(Usuario autor, String conteudo){
        this.autorPostagem = autor;
        this.conteudo = conteudo;
    }

    //Métodos
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

    //To String
    public String toString(){
        return "\nAutor: " + autorPostagem.getUsername() + "\nConteúdo: " + conteudo + "\n";
    }
    
}