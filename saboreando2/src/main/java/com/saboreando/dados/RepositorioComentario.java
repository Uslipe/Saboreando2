package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Postagem;

public class RepositorioComentario {
    private static RepositorioComentario instance;
    private ArrayList<Comentario> listaComentarios;

    //Padrão singleton
    public static RepositorioComentario getInstance(){
        if(instance == null){
            instance = new RepositorioComentario();
        }
        return instance;
    }

    //Construtor
    public RepositorioComentario() {
        this.listaComentarios = new ArrayList<>();
    }

    public void inserir(Comentario comentario){
        listaComentarios.add(comentario);
    }

    //Retorna uma lista com todos os comentários relacionados a determinada postagem
    public List<Comentario> listarComentariosPostagem(Postagem postagem){
        List<Comentario> comentariosDaPostagem = new ArrayList<>();
        //Vasculha o array atrás de comentários
        for(Comentario comentario : listaComentarios){
            //Verificar se a postagem armazenada no comentário se iguala a postagem do parâmetro
            if(comentario.getPostagemRelacionada().equals(postagem)){
                comentariosDaPostagem.add(comentario);
            }
        }
        return comentariosDaPostagem;
    }

    
}
