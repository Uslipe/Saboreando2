package com.saboreando.negocio;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;

public class ControladorUsuario {
    private RepositorioUsuario repositorioUsuario;

    public ControladorUsuario(){
        this.repositorioUsuario = RepositorioUsuario.getInstance();
    }

    //
    public void cadastrarUsuario(Usuario u){

    }
}
