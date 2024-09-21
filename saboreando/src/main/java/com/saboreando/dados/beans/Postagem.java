package com.saboreando.dados.beans;

import java.io.Serializable;

public class Postagem implements Serializable{
    private String tituloPostagem;
    private String usernameAutorPostagem;
    private String conteudo;

    //Construtor
    public Postagem(String autor, String titulo, String conteudo){
        this.usernameAutorPostagem = autor;
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

    public String getAutorPostagem() {
        return usernameAutorPostagem;
    }

    public void setAutorPostagem(String autorPostagem) {
        this.usernameAutorPostagem = autorPostagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    //To String
    public String toString(){
        return "\nAutor: " + usernameAutorPostagem + "\nTítulo: " + tituloPostagem +"\nConteúdo: " + conteudo + "\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this.tituloPostagem.equals(((Postagem)obj).tituloPostagem) && this.conteudo.equals(((Postagem)obj).conteudo) && this.usernameAutorPostagem.equals(((Postagem)obj).usernameAutorPostagem)){
            return true;
        }
        return false;
    }
}