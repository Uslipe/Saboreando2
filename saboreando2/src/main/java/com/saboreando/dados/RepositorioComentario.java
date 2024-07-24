package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Comentario;

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

    public void inserir(){
        
    }
}
