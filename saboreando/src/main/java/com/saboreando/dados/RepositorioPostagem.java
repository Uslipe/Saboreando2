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
import com.saboreando.dados.beans.Usuario;

import javafx.geometry.Pos;

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

    public int retornarQntPostagensUsuario(Usuario usuario){
        //Contador para retornar
        int contador = 0;
        //Iterar a lista de postagens
        for(Postagem p : listaPostagens){
            if(p.getAutorPostagem().equals(usuario.getUsername())){
                contador++;
            }
        }
        return contador;
    }

    //Métodos para a montagem da postagem
    public String retornarUsernameAutor(Postagem postagem){
        return postagem.getAutorPostagem();
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

    public Postagem retornarPostagemPorIndice(int i){
        return listaPostagens.get(i);
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

    public void alterarAutorPostagem(String antigoUsuario, String novoUsuario) {
        // Itera sobre todas as postagens no repositório
        for (Postagem postagem : listaPostagens) {
            // Verifica se o autor da postagem é o antigo usuário
            if (postagem.getAutorPostagem().equals(antigoUsuario)) {
                // Atualiza o autor da postagem para o novo usuário
                postagem.setAutorPostagem(novoUsuario);
            }
        }
        // Salva as alterações no arquivo
        salvarArquivo();
    }

    public int retornarIndicePostagem(Postagem postagem){
        int id = 0;
        for(int i = 0; i < listaPostagens.size(); i++){
            if(listaPostagens.get(i).equals(postagem)){
                id = i;
            }
        }
        return id;
    }

    public int retornarQntCategoriasPostagem(Postagem postagem){
        return postagem.getCategorias().size();
    }

        //Métodos de arquivos
    //Método para salvar o objeto no arquivo
    private void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("Saboreando2/saboreando/postagens.dat");
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
        File in = new File("Saboreando2/saboreando/postagens.dat");
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
