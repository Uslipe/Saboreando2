package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Postagem;

@SuppressWarnings("rawtypes") //Isso faz o alerta amarelo sumir

public class RepositorioPostagem implements IRepositorioPostagem{
    private static RepositorioPostagem instance;
    private ArrayList<Postagem> listaPostagens;

    //Padrão singleton
    public static RepositorioPostagem getInstance(){
        if(instance == null){
            instance = new RepositorioPostagem();
        }
        return instance;
    }

    //Construtor
    public RepositorioPostagem() {
        this.listaPostagens = new ArrayList<>();
    }

    //Métodos interface
    //Inserir na lista
    @Override
    public void inserir(Postagem p) {
        listaPostagens.add(p);
    }

    //Retorna um arraylist com todos as postagens cadastrados
    @Override
    public List listar() {
        return new ArrayList<>(listaPostagens);
    }

    //Remover a postagem inteira
    @Override
    public void remover(Postagem p) {
        listaPostagens.remove(p);
    }
    
}
