package com.saboreando.negocio;

import com.saboreando.dados.RepositorioComentario;
import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Postagem;

import java.util.List;

public class ControladorComentario {
    private static ControladorComentario instance;
    private RepositorioComentario repositorioComentario;

    //Padrão singleton
    public static ControladorComentario getInstance(){
        if(instance == null){
            instance = new ControladorComentario();
        }
        return instance;
    }

    public ControladorComentario(){
        this.repositorioComentario = RepositorioComentario.getInstance();
    }

    //Métodos de controle
    public void inserirComentario(Comentario comentario){
        //Se o campo é preenchido...
        if(comentario.getTexto() != null){
            repositorioComentario.inserir(comentario);
        }
        else{ //Se o campo não está preenchido
            throw new IllegalArgumentException("Argumento nulo");
        }
    }

    public List<Comentario> listarComentariosPostagem(Postagem postagem){
        return repositorioComentario.listarComentariosPostagem(postagem);
    }
}
