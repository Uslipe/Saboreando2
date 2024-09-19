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

import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

public class RepositorioCurtida implements Serializable {
    private static RepositorioCurtida instance;
    private ArrayList<Curtida> listaCurtida;

    //Padrão singleton
    public static RepositorioCurtida getInstance(){
        if(instance == null){
            instance = lerDoArquivo();
        }
        return instance;
    }

    //Construtor
    public RepositorioCurtida() {
        this.listaCurtida = new ArrayList<>();
    }

    //Inserir curtida na lista
    public void inserir(Curtida curtida){
        listaCurtida.add(curtida);
        salvarArquivo();
    }

    public void remover(Curtida curtida){
        listaCurtida.remove(curtida);
        salvarArquivo();
    }

    //Retorna uma lista com todas as curtidas relacionadas a determinada postagem
    public List<Curtida> listarCurtidasPostagem(Postagem postagem){
        List<Curtida> curtidasDaPostagem = new ArrayList<>();
        //Vasculha o array atrás de curtidas
        for(Curtida curtida : listaCurtida){
            //Verificar se a postagem armazenada na curtida se iguala a postagem do parâmetro
            if(curtida.getPostagemRelacionada().equals(postagem)){
                curtidasDaPostagem.add(curtida);
            }
        }
        return curtidasDaPostagem;
    }

    //Verificar se um determinado usuário já curtiu a postagem
    public boolean curtiuOuNao(Usuario usuario, Postagem postagem){
        for(Curtida curtida : listaCurtida){
            if(curtida.getAutor().equals(usuario) && curtida.getPostagemRelacionada().equals(postagem)){
                return true; //Retorna verdadeiro se o usuário já curtiu a postagem
            }
        }
        return false; //Retorna falso se ele ainda não curtiu, ou seja, usar o false para permitir curtidas
    }

    //Métodos de arquivos
    //Método para salvar o objeto no arquivo
    private void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("Saboreando2/saboreando/curtidas.dat");
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
    private static RepositorioCurtida lerDoArquivo() {
        RepositorioCurtida instanciaLocal = null;
        File in = new File("Saboreando2/saboreando/curtidas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioCurtida) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioCurtida(); // Se ocorrer erro, cria um novo repositório vazio
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
