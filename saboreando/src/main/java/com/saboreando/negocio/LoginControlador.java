package com.saboreando.negocio;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.UsuarioNaoEncontradoException;

public class LoginControlador {
    private static LoginControlador instance;
    private RepositorioUsuario repositorioUsuario;
    private String usuarioLogado;

    //Padrão Singleton
    public static LoginControlador getInstance(){
        if(instance == null){
            instance = new LoginControlador();
        }
        return instance;
    }

    public LoginControlador(){
        this.repositorioUsuario = RepositorioUsuario.getInstance();
    }

    //Autenticar o usuário
    public boolean validarLogin(String username, String senha) throws UsuarioNaoEncontradoException{
        //Procura o indice do usuário
        int indice = repositorioUsuario.procurarUsuarioIndice(username);
        //Se for diferente de -1, ele existe...
        if(indice != -1){
            //Utiliza o indice do usuário para retornar a instancia desse usuário
            Usuario usuario = repositorioUsuario.retornarUsuario(indice);
            //Se a senha e o username forem iguais aos parametros passados...
            if(usuario.getUsername().equals(username) && usuario.getSenha().equals(senha)){
                usuarioLogado = username;
                return true;
            }
            else{
                System.out.println("Login errado");
            }
        }
        //Se for igual a -1, usuário não existe, lança exceçao
        else{
            throw new UsuarioNaoEncontradoException();
        }

        return false;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }
}
