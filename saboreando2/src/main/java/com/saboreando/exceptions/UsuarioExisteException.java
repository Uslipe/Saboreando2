package com.saboreando.exceptions;

public class UsuarioExisteException extends Exception {

    private String username;

    public UsuarioExisteException(String name){
        super("O usuário com o nome " + name + " já existe");
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

}
