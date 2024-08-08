package com.saboreando.dados.beans;

public class Postagem{
    private String tituloPostagem;
    private Usuario autorPostagem;
    private String conteudo;

    //Construtor
    public Postagem(Usuario autor, String titulo, String conteudo){
        this.autorPostagem = autor;
        this.tituloPostagem = titulo;
        this.conteudo = conteudo;
    }

    //Métodos
    //Gets e Sets
    public String getTituloPostagem() {
        return tituloPostagem;
    }

    public void setTituloPostagem(String tituloPostagem) {
        this.tituloPostagem = tituloPostagem;
    }

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