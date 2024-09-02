package com.saboreando.negocio;

import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.CurtidaExistenteException;

//Implementação do padrão de projeto FACADE
public class Fachada {
    private static Fachada instance;

    private ControladorCurtida controladorCurtida;
    private ControladorPostagem controladorPostagem;
    private ControladorUsuario controladorUsuario;
    
    //Padrão singleton de única instância
    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    //Construtor da classe
    public Fachada(){
        this.controladorCurtida = ControladorCurtida.getInstance();
        this.controladorPostagem = ControladorPostagem.getInstance();
        this.controladorUsuario = ControladorUsuario.getInstance();
    }

    //Métodos do ControladorCurtida
    public void inserirCurtida(Curtida curtida, Usuario usuario, Postagem postagem) throws CurtidaExistenteException{
        controladorCurtida.inserirCurtida(curtida, usuario, postagem);
    }
}
