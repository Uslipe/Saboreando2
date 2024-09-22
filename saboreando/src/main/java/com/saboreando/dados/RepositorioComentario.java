package com.saboreando.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Postagem;

import javafx.geometry.Pos;

public class RepositorioComentario implements Serializable {
    private static RepositorioComentario instance;
    private ArrayList<Comentario> listaComentarios;

    //Padrão singleton
    public static RepositorioComentario getInstance(){
        if(instance == null){
            instance = lerDoArquivo();
        }
        return instance;
    }

    //Construtor
    public RepositorioComentario() {
        this.listaComentarios = new ArrayList<>();
    }

    public void inserir(Comentario comentario){
        listaComentarios.add(comentario);
        salvarArquivo();
    }

    public ArrayList<Comentario> listar(){
        return new ArrayList<>(listaComentarios);
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

    public int retornarQntComentariosPostagem(Postagem postagem){
        return listarComentariosPostagem(postagem).size();
    }

        //Métodos de arquivos
    //Método para salvar o objeto no arquivo
    private void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("Saboreando2/saboreando/comentarios.dat");
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
    private static RepositorioComentario lerDoArquivo() {
        RepositorioComentario instanciaLocal = null;
        File in = new File("Saboreando2/saboreando/comentarios.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioComentario) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioComentario(); // Se ocorrer erro, cria um novo repositório vazio
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
