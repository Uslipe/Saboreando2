package com.saboreando.dados;

import java.util.ArrayList;

import com.saboreando.dados.beans.Usuario;

public class RepositorioUsuario implements IRepositorioUsuario {
    private ArrayList<Usuario> listaUsuarios;

    @Override
    public void inserir(Usuario u) {
        this.listaUsuarios.add(u);
    }

    @Override
    public Usuario listar(String username) {
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getUsername().equals(username)){
                return listaUsuarios.get(i);
            }
        }
        return null;
    }

    @Override
    public void remover(String senha) {
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getSenha().equals(senha)){
                listaUsuarios.remove(i);
            }
        }
    }

    
}
