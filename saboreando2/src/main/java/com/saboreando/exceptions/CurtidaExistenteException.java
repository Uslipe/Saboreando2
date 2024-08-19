package com.saboreando.exceptions;

public class CurtidaExistenteException extends Exception{
    private String username;

    public CurtidaExistenteException(String name){
        super("O usuário: " + name + " já curtiu a postagem");
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

}
