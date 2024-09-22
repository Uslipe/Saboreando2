package com.saboreando.negocio;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Comentario;
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
    private ControladorComentario controladorComentario;
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
        this.controladorComentario = ControladorComentario.getInstance();
        this.loginControlador = LoginControlador.getInstance();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do ControadorComentario
    public void inserirComentario(Comentario comentario){
        controladorComentario.inserirComentario(comentario);
    }

    public List<Comentario> listarComentariosPostagem(Postagem postagem){
        return controladorComentario.listarComentariosPostagem(postagem);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Métodos do ControladorCurtida
    public void inserirOuRemoverCurtida(Curtida curtida, Usuario usuario, Postagem postagem) throws CurtidaExistenteException{
        controladorCurtida.inserirOuRemoverCurtida(curtida, usuario, postagem);
    }

    public int retornarQntCurtidasPostagem(Postagem postagem){
        return controladorCurtida.retornarQntCurtidasPostagem(postagem);
    }

    public boolean curtiuOuNao(Usuario usuario, Postagem postagem){
        return controladorCurtida.curtiuOuNao(usuario, postagem);
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


    public int retornarQuantidadeComentarios(Postagem postagem){
        return controladorPostagem.retornarQuantidadeComentarios(postagem);
    }

    public void excluirPostagem(String usuario, Postagem postagem){
        controladorPostagem.excluirPostagem(usuario, postagem);
    }

    public int retornarQntPostagensUsuario(Usuario usuario){
        return controladorPostagem.retornarQntPostagensUsuario(usuario);
    }

    public void alterarAutorPostagem(String antigo, String novo){
        controladorPostagem.alterarAutorPostagem(antigo, novo);
    }

    public List<Postagem> montarFeedDePostagens(){
        return controladorPostagem.montarFeedDePostagens();
    }

    public List<Postagem> montarFeedDePostagensUsuario(){
        return controladorPostagem.montarFeedDePostagensUsuario();
    }

    public int retornarIndicePostagem(Postagem postagem){
        return controladorPostagem.retornarIndicePostagem(postagem);
    }

    public Postagem retornarPostagemPorIndice(int i){
        return controladorPostagem.retornarPostagemPorIndice(i);
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

    public void setUsuarioLogado(String usuario){
        loginControlador.setUsuarioLogado(usuario);
    }
}
