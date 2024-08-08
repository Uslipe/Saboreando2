package com.saboreando.negocio;

import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

public class ControladorPostagem {
    private static ControladorPostagem instance;
    private RepositorioPostagem repositorioPostagem;

    //Padrão singleton de única instância
    public static ControladorPostagem getInstance(){
        if(instance == null){
            instance = new ControladorPostagem();
        }
        return instance;
    }

    //Construtor da classe
    public ControladorPostagem(){
        this.repositorioPostagem = RepositorioPostagem.getInstance();
    }

    //Criar uma nova postagem
    public void criarPostagem(Postagem postagem){
        //Abordagem um pouco diferente do cadastrarUsuario
        if(postagem.getAutorPostagem() != null && postagem.getConteudo() != null){
            repositorioPostagem.inserir(postagem);
        }
        else{
            throw new IllegalArgumentException("Argumento nulo");
        }
    }

    public String retornarTituloPostagem(Postagem postagem){
        if(postagem.getTituloPostagem() != null){
            return postagem.getTituloPostagem();
        }
        else{
            throw new IllegalArgumentException("Titulo da postagem não identificado");
        }
    }

    public String retornarConteudoPostagem(Postagem postagem){
        if(postagem.getConteudo() != null){
            return postagem.getConteudo();
        }
        else{
            throw new IllegalArgumentException("Conteúdo da postagem não identificado");
        }
    }
}
