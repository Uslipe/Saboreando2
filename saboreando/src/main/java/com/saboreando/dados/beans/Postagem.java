package com.saboreando.dados.beans;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Postagem implements Serializable{
    private String tituloPostagem;
    private String usernameAutorPostagem;
    private String conteudo;
    private List<Categorias> categorias;

    //Construtor
    public Postagem(String autor, String titulo, String conteudo, List<Categorias> categorias){
        this.usernameAutorPostagem = autor;
        this.tituloPostagem = titulo;
        this.conteudo = conteudo;
        this.categorias = new ArrayList<>(categorias);
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

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = new ArrayList<>(categorias);
    }

    //To String
    public String toString(){
        return "\nAutor: " + usernameAutorPostagem + "\nTítulo: " + tituloPostagem +"\nConteúdo: " + conteudo + "\nCategorias: " + categorias + "\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.tituloPostagem.equals(((Postagem)obj).tituloPostagem) &&
            this.conteudo.equals(((Postagem)obj).conteudo) &&
            this.usernameAutorPostagem.equals(((Postagem)obj).usernameAutorPostagem) &&
            this.categorias.equals(((Postagem)obj).categorias)) {  // Comparando as categorias também
            return true;
        }
        return false;
    }
}