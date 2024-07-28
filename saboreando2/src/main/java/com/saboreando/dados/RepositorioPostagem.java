package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

@SuppressWarnings("rawtypes") //Isso faz o alerta amarelo sumir

public class RepositorioPostagem implements IRepositorioPostagem{
    private static RepositorioPostagem instance;
    private ArrayList<Postagem> listaPostagens;

    private RepositorioComentario repositorioComentario;
    private RepositorioCurtida repositorioCurtida;

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
        this.repositorioComentario = RepositorioComentario.getInstance();
        this.repositorioCurtida = RepositorioCurtida.getInstance();
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

    public Usuario retornarAutorPostagem(Postagem postagem){
        return postagem.getAutorPostagem();
    }

    //Métodos de comentários
    public void adicionarComentario(Comentario comentario){
        repositorioComentario.inserir(comentario);
    }
    
    public List<Comentario> listarComentarios(Postagem postagem){
        return repositorioComentario.listarComentariosPostagem(postagem);
    }

    public int contabilizarComentarios(Postagem postagem){
        return repositorioComentario.listarComentariosPostagem(postagem).size();
    }

    //Métodos de curtidas
    public void adicionarCurtida(Curtida curtida){
        repositorioCurtida.inserir(curtida);
    }

    public List<Curtida> listarCurtidas(Postagem postagem){
        return repositorioCurtida.listarCurtidasPostagem(postagem);
    }

    public int contabilizarCurtidas(Postagem postagem){
        return repositorioCurtida.listarCurtidasPostagem(postagem).size();
    }
}
