package com.saboreando.negocio;

import java.util.ArrayList;

import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.CurtidaExistenteException;
import com.saboreando.exceptions.SenhaIncorretaException;
import com.saboreando.exceptions.UsuarioExisteException;
import com.saboreando.exceptions.UsuarioIncorretoException;
import com.saboreando.exceptions.UsuarioNaoEncontradoException;

//Implementação do padrão de projeto FACADE
public class Fachada {
    private static Fachada instance;

    private ControladorCurtida controladorCurtida;
    private ControladorPostagem controladorPostagem;
    private ControladorUsuario controladorUsuario;
    private LoginControlador loginControlador;
    
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
        this.loginControlador = LoginControlador.getInstance();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do ControladorCurtida
    public void inserirCurtida(Curtida curtida, Usuario usuario, Postagem postagem) throws CurtidaExistenteException{
        controladorCurtida.inserirCurtida(curtida, usuario, postagem);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do ControladorPostagem
    public void criarPostagem(Postagem postagem){
        controladorPostagem.criarPostagem(postagem);
    }

    public String retornarTituloPostagem(Postagem postagem){
        return controladorPostagem.retornarTituloPostagem(postagem);
    }

    public String retornarConteudoPostagem(Postagem postagem){
        return controladorPostagem.retornarConteudoPostagem(postagem);
    }

    public String retornarAutorPostagem(Postagem postagem){
        return controladorPostagem.retornarAutorPostagem(postagem);
    }

    public int retornarQuantidadeCurtidas(Postagem postagem){
        return controladorPostagem.retornarQuantidadeCurtidas(postagem);
    }

    public int retornarQuantidadeComentarios(Postagem postagem){
        return controladorPostagem.retornarQuantidadeComentarios(postagem);
    }

    public void excluirPostagem(Usuario usuario, Postagem postagem){
        controladorPostagem.excluirPostagem(usuario, postagem);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do controlador usuário
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExisteException{
        controladorUsuario.cadastrarUsuario(usuario);
    }

    public void editarUsernameUsuario(Usuario usuario, String novoUsername) throws UsuarioNaoEncontradoException, UsuarioExisteException{
        controladorUsuario.editarUsernameUsuario(usuario, novoUsername);
    }

    public void editarEmailUsuario(Usuario usuario, String novoEmail) throws UsuarioNaoEncontradoException{
        controladorUsuario.editarEmailUsuario(usuario, novoEmail);
    }

    public void editarNomeUsuario(Usuario usuario, String novoNome) throws UsuarioNaoEncontradoException{
        controladorUsuario.editarNomeUsuario(usuario, novoNome);
    }

    public void excluirUsuario(String username, String senha) throws UsuarioNaoEncontradoException{
        controladorUsuario.excluirUsuario(username, senha);
    }

    public ArrayList<Usuario> listar(){
        return controladorUsuario.listar();
    }

    public Usuario pegarInstanciaUsuarioLogado(){
        return controladorUsuario.pegarInstanciaUsuarioLogado();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do login controlador
    public boolean validarLogin(String username, String senha) throws UsuarioNaoEncontradoException, SenhaIncorretaException, UsuarioIncorretoException{
        return loginControlador.validarLogin(username, senha);
    }

    public String getUsuarioLogado(){
        return loginControlador.getUsuarioLogado();
    }
}
