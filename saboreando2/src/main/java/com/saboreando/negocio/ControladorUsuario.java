package com.saboreando.negocio;

import com.exceptions.UsuarioExisteException;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;

public class ControladorUsuario {
    private static ControladorUsuario instance;
    private RepositorioUsuario repositorioUsuario;

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
    }

    //Cadastrar usuário
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExisteException{
        //Verifica se todos os campos são preenchidos
        if(usuario.getNome() == null || usuario.getEmail() == null || usuario.getUsername() == null || usuario.getSenha() == null){
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
    public void editarUsernameUsuario(Usuario usuario, String novoUsername){
        //Verifica se o usuário existe
        if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
            repositorioUsuario.editarUsername(usuario, novoUsername);
        }
        else{
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    //Editar email do usuário
    public void editarEmailUsuario(Usuario usuario, String novoEmail){
        if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
            repositorioUsuario.editarEmail(usuario, novoEmail);
        }
        else{
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    //Editar nome do usuário
    public void editarNomeUsuario(Usuario usuario, String novoNome){
        if(repositorioUsuario.procurarUsuarioIndice(usuario.getUsername()) != -1){ //"Se o usuário está na lista..."
            repositorioUsuario.editarNome(usuario, novoNome);
        }
        else{
            throw new IllegalArgumentException("Usuário não encontrado");
        }
    }

    //Excluir usuário
    public void excluirUsuario(String username, String senha){
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
            throw new IllegalArgumentException("Usuário não encontrado");
        } 
    }
}

