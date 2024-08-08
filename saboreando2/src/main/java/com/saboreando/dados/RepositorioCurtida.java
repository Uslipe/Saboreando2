package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

public class RepositorioCurtida {
    private static RepositorioCurtida instance;
    private ArrayList<Curtida> listaCurtida;

    //Padrão singleton
    public static RepositorioCurtida getInstance(){
        if(instance == null){
            instance = new RepositorioCurtida();
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
}
