package com.saboreando.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;

@SuppressWarnings("rawtypes") //Isso faz o alerta amarelo sumir

public class RepositorioPostagem implements IRepositorioPostagem, Serializable{
    private static RepositorioPostagem instance;
    private ArrayList<Postagem> listaPostagens;

    private RepositorioComentario repositorioComentario;
    private RepositorioCurtida repositorioCurtida;

    //Padrão singleton
    public static RepositorioPostagem getInstance(){
        if(instance == null){
            instance = lerDoArquivo();
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
        salvarArquivo();
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
        salvarArquivo();
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
    public Postagem retornarPostagemAleatoria() {
        int index = 0;
        if(listaPostagens.size() > 0){
            index = new Random().nextInt(listaPostagens.size());
        }
        else{
            System.out.println("Erro aqui");
            index = 0;
        }
        return listaPostagens.get(index);
    }

    public int retornarTamanhoDaLista(){
        return listaPostagens.size();
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

        //Métodos de arquivos
    //Método para salvar o objeto no arquivo
    private void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("saboreando/postagens.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Método para ler o objeto do arquivo
    private static RepositorioPostagem lerDoArquivo() {
        RepositorioPostagem instanciaLocal = null;
        File in = new File("saboreando/postagens.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioPostagem) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioPostagem(); // Se ocorrer erro, cria um novo repositório vazio
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return instanciaLocal;
    }
}
