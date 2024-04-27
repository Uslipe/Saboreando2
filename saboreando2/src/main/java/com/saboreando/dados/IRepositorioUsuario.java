package com.saboreando.dados;

import java.util.List;

import com.saboreando.dados.beans.Usuario;

public interface IRepositorioUsuario<T> {
    //Adicionar ao array
    void inserir(Usuario u);

    //Achar usuário por username
    List<T> listar();

    //Remover
    void remover(String username,String senha);

}
