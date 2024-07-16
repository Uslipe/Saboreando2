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
    public void inserir(Usuario u) {
        this.listaUsuarios.add(u);
    }

    //Retorna um arraylist com todos os usuários cadastrados
    @Override
    public ArrayList<Usuario> listar() {
        return new ArrayList<>(listaUsuarios);
    }

    //Retorna o indice do usuario na lista
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

    
}
