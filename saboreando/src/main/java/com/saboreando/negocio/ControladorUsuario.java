package com.saboreando.negocio;

import java.util.ArrayList;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.UsuarioExisteException;
import com.saboreando.exceptions.UsuarioNaoEncontradoException;

public class ControladorUsuario {
    private static ControladorUsuario instance;
    private RepositorioUsuario repositorioUsuario;
    private LoginControlador loginControlador;

    //Padrão singleton de única instância
    public static ControladorUsuario getInstance(){
        if(instance == null){
            instance = new ControladorUsuario();
        }
        return instance;
    }

    //Construtor da classe
    public ControladorUsuario(){
        this.repositorioUsuario = RepositorioUsuario.getInstance();
        this.loginControlador = LoginControlador.getInstance();
    }

    //Cadastrar usuário
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExisteException{
        //Verifica se todos os campos são preenchidos
        if(usuario.getNome() == null || usuario.getEmail() == null || usuario.getUsername() == null || usuario.getSenha() == null || usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getUsername().isEmpty() || usuario.getSenha().isEmpty()){
            throw new IllegalArgumentException("Argumento nulo");
        }
        //Caso todos estejam preenchidos...
        else{
            //...Verifica se o username já é cadastrado
            if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) == -1){
                repositorioUsuario.inserir(usuario);
            }
            else{
                throw new UsuarioExisteException(usuario.getUsername());
            }
        }
    }

    //Editar username do usuário
    public void editarUsernameUsuario(Usuario usuario, String novoUsername) throws UsuarioNaoEncontradoException, UsuarioExisteException{
        //Verifica se o novo username já não pertence a alguém
        if(repositorioUsuario.procurarUsuarioIndice(novoUsername) == -1){
            //Verifica se o usuário existe
            if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
                repositorioUsuario.editarUsername(usuario, novoUsername);
            }
            else{
                throw new UsuarioNaoEncontradoException();
            }
        }
        //Se o novo username pertencer a alguém...
        else{
            //Verifica se já não é o próprio usuário
            if(novoUsername.equals(loginControlador.getUsuarioLogado())){
                repositorioUsuario.editarUsername(usuario, novoUsername);
            }
            else{
                throw new UsuarioExisteException(novoUsername); 
            }
        }
        
    }

    //Editar email do usuário
    public void editarEmailUsuario(Usuario usuario, String novoEmail) throws UsuarioNaoEncontradoException{
        if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
            repositorioUsuario.editarEmail(usuario, novoEmail);
        }
        else{
            throw new UsuarioNaoEncontradoException();
        }
    }

    //Editar nome do usuário
    public void editarNomeUsuario(Usuario usuario, String novoNome) throws UsuarioNaoEncontradoException{
        if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
            repositorioUsuario.editarNome(usuario, novoNome);
        }
        else{
            throw new UsuarioNaoEncontradoException();
        }
    }

    //Excluir usuário
    public void excluirUsuario(String username, String senha) throws UsuarioNaoEncontradoException{
        int indice = repositorioUsuario.procurarUsuarioIndice(username);
        if(indice != -1){
            if(senha.equals(repositorioUsuario.retornarUsuario(indice).getSenha())){
                repositorioUsuario.remover(indice);
            }
            else{
                throw new IllegalArgumentException("Senha incorreta");
            }
        }
        else{
            throw new UsuarioNaoEncontradoException();
        } 
    }

    public Usuario pegarInstanciaUsuarioLogado(){
        //Retorna o indice do usuário com base no username do usuário logado
        int indice = repositorioUsuario.procurarUsuarioIndice(loginControlador.getUsuarioLogado());
        return repositorioUsuario.retornarUsuario(indice);

    }

    public ArrayList<Usuario> listar(){
        return repositorioUsuario.listar();
    }

    public int procurarUsuarioIndice(String username){
        return repositorioUsuario.procurarUsuarioIndice(username);
    }

    public Usuario retornarUsuario(int i){
        return repositorioUsuario.retornarUsuario(i);
    }
}

