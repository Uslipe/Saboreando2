package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;

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

    //Métodos para a montagem da postagem
    public String retornarUsernameAutor(Postagem postagem){
        return postagem.getAutorPostagem().getUsername();
    }

    public String retornarTituloPostagem(Postagem postagem){
        return postagem.getTituloPostagem();
    }

    public String retornarConteudoPostagem(Postagem postagem){
        return postagem.getConteudo();
    }

    //AVISO: no controlador, colocar o método para retornar uma lista com as postagens e verificar se a postagem puxada já não está presente na lista
    public Postagem retornarPostagensAleatorias(){
        Random numeroAleatorio = new Random();
        int index = numeroAleatorio.nextInt(listaPostagens.size());
        return listaPostagens.get(index);
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
