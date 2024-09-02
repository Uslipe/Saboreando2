package com.saboreando.dados.beans;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{

    private String nome;
    private String email;
    private String username;
    private String senha;

    private List<Usuario> seguindo;

    //Construtor
    public Usuario( String nome, String email, String username, String senha){
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
    }

    //Métodos
    public void seguirUsuario(Usuario usuario){
        seguindo.add(usuario);
    }

    //Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(List<Usuario> seguindo) {
        this.seguindo = seguindo;
    }

    //To String
    public String toString(){
        return "\nNome: " + this.getNome() + "\nEmail: " + this.getEmail() + "\nUsername: " + getUsername() + "\nSenha: " + getSenha() + "\n";
    }
}