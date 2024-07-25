package com.saboreando.dados;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;

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
        //Vasculha o array atrás de comentários
        for(Curtida curtida : listaCurtida){
            //Verificar se a postagem armazenada no comentário se iguala a postagem do parâmetro
            if(curtida.getPostagemRelacionada().equals(postagem)){
                curtidasDaPostagem.add(curtida);
            }
        }
        return curtidasDaPostagem;
    }
}
