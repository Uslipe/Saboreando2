package com.saboreando.dados;


import com.saboreando.dados.beans.Usuario;

public interface IRepositorioUsuario<T> {
    //Adicionar ao array
    void inserir(Usuario u);

    //Achar usuário por username
    Usuario listar(String username);

    //Remover
    void remover(String senha);

}
