package com.exceptions;

public class UsuarioNaoEncontradoException extends Exception {

    public UsuarioNaoEncontradoException(){
        super("O usuário com o nome não foi encontrado");
    }
}
