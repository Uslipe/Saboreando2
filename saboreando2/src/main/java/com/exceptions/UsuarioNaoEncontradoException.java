package com.exceptions;

public class UsuarioNaoEncontradoException extends Exception {
    
    private String username;

    public UsuarioNaoEncontradoException(String name){
        super("O usuário com o nome " + name + " não foi encontrado");
        this.username = name;
    }

    public String getUsername() {
        return username;
    }
}
