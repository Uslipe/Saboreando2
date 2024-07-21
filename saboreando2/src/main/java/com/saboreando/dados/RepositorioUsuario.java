package com.saboreando.dados;

import java.util.ArrayList;

import com.saboreando.dados.beans.Usuario;

@SuppressWarnings("rawtypes")//Não sei oque é isso, mas desativou um alerta da linha de baixo 

public class RepositorioUsuario implements IRepositorioUsuario {
    private static RepositorioUsuario instance;
    private ArrayList<Usuario> listaUsuarios;

    public static RepositorioUsuario getInstance(){
        if(instance == null){
            instance = new RepositorioUsuario();
        }
        return instance;
    }

    //Construtor
    public RepositorioUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }

    //Métodos da Interface
    //Inserir na lista
    @Override
    public void inserir(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    //Retorna um arraylist com todos os usuários cadastrados
    @Override
    public ArrayList<Usuario> listar() {
        return new ArrayList<>(listaUsuarios);
    }

    //Procura um usuário por username e retorna o indice do usuario na lista
    public int procurarUsuarioIndice(String username){

        for(int i = 0; i < listaUsuarios.size(); i++){
            if(username.equals(listaUsuarios.get(i).getUsername())){
                return i;
            }
        }
        return -1; //Se o usuario não for encontrado
    }

    //Remover usuário baseado no username e senha
    @Override
    public void remover(String username, String senha) {
        for(int i = 0; i < listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getSenha().equals(senha) && listaUsuarios.get(i).getUsername().equals(username)){
                listaUsuarios.remove(i);
            }
        }
    }

    //Editar username do usuário
    public void editarUsername(Usuario usuario, String novoUsername){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setUsername(novoUsername);
    }

    //Editar email do usuário
    public void editarEmail(Usuario usuario, String novoEmail){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setEmail(novoEmail);
    }

    //Editar nome do usuário
    public void editarNome(Usuario usuario, String novoNome){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setNome(novoNome);
    }
}
