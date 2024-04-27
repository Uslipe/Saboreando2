package com.saboreando.dados;

import java.util.ArrayList;

import com.saboreando.dados.beans.Usuario;

@SuppressWarnings("rawtypes")//Não sei oque é isso, mas desativou um alerta da linha de baixo 
public class RepositorioUsuario implements IRepositorioUsuario {
    private ArrayList<Usuario> listaUsuarios;

    //Tinha dado erro pois esqueci de inicializar a lista
    public RepositorioUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public void inserir(Usuario u) {
        this.listaUsuarios.add(u);
    }

    @Override
    public ArrayList<Usuario> listar() {
        return new ArrayList<>(listaUsuarios);
    }

    @Override
    public void remover(String username, String senha) {
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getSenha().equals(senha) && listaUsuarios.get(i).getUsername().equals(username)){
                listaUsuarios.remove(i);
            }
        }
    }

    
}
