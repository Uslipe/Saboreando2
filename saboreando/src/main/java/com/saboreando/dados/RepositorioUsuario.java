package com.saboreando.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.saboreando.dados.beans.Usuario;

@SuppressWarnings("rawtypes")//Não sei oque é isso, mas desativou um alerta da linha de baixo 

public class RepositorioUsuario implements IRepositorioUsuario, Serializable {
    private static RepositorioUsuario instance;
    private ArrayList<Usuario> listaUsuarios;

    public static RepositorioUsuario getInstance(){
        if(instance == null){
            instance = lerDoArquivo();
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
        salvarArquivo();
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

    //Retornar um usuário da lista
    public Usuario retornarUsuario(int indice){
        return listaUsuarios.get(indice);
    }

    //Remover usuário baseado no username e senha
    @Override
    public void remover(int indice) {
        listaUsuarios.remove(indice);
        salvarArquivo();
    }

    //Editar username do usuário
    public void editarUsername(Usuario usuario, String novoUsername){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setUsername(novoUsername);
        salvarArquivo();
    }

    //Editar email do usuário
    public void editarEmail(Usuario usuario, String novoEmail){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setEmail(novoEmail);
        salvarArquivo();
    }

    //Editar nome do usuário
    public void editarNome(Usuario usuario, String novoNome){
        listaUsuarios.get(procurarUsuarioIndice(usuario.getUsername())).setNome(novoNome);
        salvarArquivo();
    }

    //Métodos de arquivos
    //Método para salvar o objeto no arquivo
    private void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("usuarios.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Método para ler o objeto do arquivo
    private static RepositorioUsuario lerDoArquivo() {
        RepositorioUsuario instanciaLocal = null;
        File in = new File("usuarios.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioUsuario) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioUsuario(); // Se ocorrer erro, cria um novo repositório vazio
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return instanciaLocal;
    }
}
