package com.saboreando.dados;

import java.util.List;

import com.saboreando.dados.beans.Postagem;

public interface IRepositorioPostagem<T> {
    //Adicionar ao array
    void inserir(Postagem p);

    //Lista todas as postagens em um arraylist
    List<T> listar();

    //Remover postagem
    void remover(Postagem p);
}
