package com.saboreando;

import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

public class App 
{
    public static void main( String[] args ){
        RepositorioUsuario repo = new RepositorioUsuario();
        RepositorioPostagem sitorio = new RepositorioPostagem();

        //Criando Usuarios
        Usuario u1 = new Usuario("Felipe", "felipe.pereira.nave@gmail.com", "uslipe", "12345678");
        Usuario u2 = new Usuario("Gisele", "xixa.gatinha@gmail.com", "minhaxixa", "12345678");

        //Criando Posgatens
        Postagem p1 = new Postagem(u1, "Bolu di morango do pica pau");
        Postagem p2 = new Postagem(u1, "Sanduiche perfeito do jake");
        Postagem p3 = new Postagem(u1, "Torta de fadas da amity");
        Postagem p4 = new Postagem(u2, "Sanduiche sensivel especial do bmo");
        Postagem p5 = new Postagem(u2, "Torta escocesa do pica pau");
        
        repo.inserir(u1);
        repo.inserir(u2);

        sitorio.inserir(p1);
        sitorio.inserir(p2);
        sitorio.inserir(p3);
        sitorio.inserir(p4);
        sitorio.inserir(p5);

        System.out.println("Todos os usuários: " + repo.listar());
        System.out.println("\n\n");
        System.out.println("Todos as postagens: " + sitorio.listar());
        
        repo.remover("uslipe", "12345678");

        System.out.println("\n\n");
        System.out.println("Usuarios restantes: ");
        System.out.println(repo.listar()); 

    }
}
