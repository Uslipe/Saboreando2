package com.saboreando.negocio;

import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Postagem;

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
}
