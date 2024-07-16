package com.saboreando.negocio;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;

public class ControladorUsuario {
    private RepositorioUsuario repositorioUsuario;

    public ControladorUsuario(){
        this.repositorioUsuario = RepositorioUsuario.getInstance();
    }

    //Cadastrar usuário
    public void cadastrarUsuario(Usuario u){
        //Verifica se todos os campos são preenchidos
        if(u.getNome() == null || u.getEmail() == null || u.getUsername() == null || u.getSenha() == null){
            throw new IllegalArgumentException("Argumento nulo");
        }
        //Caso todos estejam preenchidos...
        else{
            //...Verifica se o username já é cadastrado
            if(repositorioUsuario.procurarUsuarioIndice(u.getUsername()) == -1){
                repositorioUsuario.inserir(u);
            }
            else{
                throw new IllegalArgumentException("Usuário existente");
            }
        }
    }
}

