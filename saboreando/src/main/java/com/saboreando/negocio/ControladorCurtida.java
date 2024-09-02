package com.saboreando.negocio;

import com.saboreando.dados.RepositorioCurtida;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.CurtidaExistenteException;

public class ControladorCurtida {
    private static ControladorCurtida instance;
    private RepositorioCurtida repositorioCurtida;

    //Padrão singleton de única instância
    public static ControladorCurtida getInstance(){
        if(instance == null){
            instance = new ControladorCurtida();
        }
        return instance;
    }

    public ControladorCurtida(){
        this.repositorioCurtida = RepositorioCurtida.getInstance();
    }

    //Inserir curtida
    public void inserirCurtida(Curtida curtida, Usuario usuario, Postagem postagem) throws CurtidaExistenteException{
        if(repositorioCurtida.curtiuOuNao(usuario, postagem) == false){ //Se o usuário não curtiu a postagem
            repositorioCurtida.inserir(curtida);
        }
        else{
            throw new CurtidaExistenteException(usuario.getUsername());
        }
    }
}
