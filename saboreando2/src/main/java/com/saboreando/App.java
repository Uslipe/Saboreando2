package com.saboreando;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;

public class App 
{
    public static void main( String[] args ){
        RepositorioUsuario repo = new RepositorioUsuario();

        Usuario u1 = new Usuario("Felipe", "felipe.pereira.nave@gmail.com", "uslipe", "12345678");
        Usuario u2 = new Usuario("Gisele", "xixa.gatinha@gmail.com", "minhaxixa", "12345678");

        repo.inserir(u1);
        repo.inserir(u2);

        System.out.println(repo.listar("uslipe"));
        System.out.println(repo.listar("minhaxixa"));
        
        repo.remover("uslipe", "12345678");

        System.out.println(repo.listar("uslipe")); // Printa "null"

    }
}
