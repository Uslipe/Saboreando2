package com.saboreando;

import com.exceptions.UsuarioExisteException;
import com.saboreando.dados.RepositorioCurtida;
import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.negocio.ControladorUsuario;

public class App 
{
    public static void main( String[] args ) throws UsuarioExisteException{
        new RepositorioUsuario();
        //Instanciando o repositorio de usuários com sigleton
        RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();
        RepositorioPostagem repositorioPostagem = RepositorioPostagem.getInstance();
        RepositorioCurtida repositorioCurtida = RepositorioCurtida.getInstance();

        //Instanciando o controlador de usuários
        ControladorUsuario controlador = ControladorUsuario.getInstance();

        //TESTES DE USUÁRIO
        //-------------------------------------------------------------------------------------------------------------------
        
        //Teste para inserção de usuários (SUCESSO)
        //System.out.println("TESTE DE CADASTRO DE USUÁRIOS\n");

        Usuario usuario1 = new Usuario("Felipe", "felipe@smau.com", "uslipe", "12345678");
        Usuario usuario2 = new Usuario("Gisele", "gisele@smau.com", "xixa", "12345678");
        Usuario usuario3 = new Usuario("Giovana", "giovana@smau.com", "xeo", "12345678");
        //Teste de exception [OK] - Usuario usuario4 = new Usuario("Joanderson", "joanderson@smau.com", "uslipe", "12345678");

        controlador.cadastrarUsuario(usuario1);
        controlador.cadastrarUsuario(usuario2);
        controlador.cadastrarUsuario(usuario3);
        //Teste de exception [OK] - controlador.cadastrarUsuario(usuario4);

        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para troca de username (SUCESSO)
        //System.out.println("\nTESTE DE TROCA DE USERNAME\n");
        controlador.editarUsernameUsuario(usuario3, "GIOCONDA");
        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para exclusão de usuário (SUCESSO)
        //System.out.println("\nTESTE DE EXCLUSÃO DE USUÁRIO\n");
        controlador.excluirUsuario("GIOCONDA", "12345678");
        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //TESTES DE POSTAGEM
        //Teste para cadastro de postagens (SUCESSO) (passar pelo controlador ainda)
        Postagem postagem1 = new Postagem(usuario1, "Bolo de morango");
        Postagem postagem2 = new Postagem(usuario2, "Tteokbokki");
        Postagem postagem3 = new Postagem(usuario2, "Banana juice");

        repositorioPostagem.inserir(postagem1);
        repositorioPostagem.inserir(postagem2);
        repositorioPostagem.inserir(postagem3);

        System.out.println("\nTESTE DE CADASTRO DE POSTAGEM\n");
        System.out.println(repositorioPostagem.listar());
        //-------------------------------------------------------------------------------------------------------------------
        
        //TESTE DE COMENTÁRIO E CURTIDA
        Comentario comentario1 = new Comentario(usuario1, postagem3, "Que delícia!");
        Comentario comentario2 = new Comentario(usuario1, postagem3, "Quero provar esse juice");

        //Duas curtidas na postagem 3
        Curtida curtida1 = new Curtida(usuario1, postagem3);
        Curtida curtida2 = new Curtida(usuario2, postagem3);
        Curtida curtida3 = new Curtida(usuario2, postagem3);

        //Adiciona os comentários
        repositorioPostagem.adicionarComentario(comentario1);
        repositorioPostagem.adicionarComentario(comentario2);

        //Adiciona as curtidas
        repositorioPostagem.adicionarCurtida(curtida1);
        repositorioPostagem.adicionarCurtida(curtida2);
        repositorioPostagem.adicionarCurtida(curtida3);

        System.out.println("\nTESTE DE LISTAGEM DE COMENTÁRIOS\n");
        System.out.println(repositorioPostagem.listarComentarios(postagem3));
        System.out.println("QUANTIDADE DE CURTIDAS");
        System.out.println(repositorioPostagem.contabilizarCurtidas(postagem3));
        //-------------------------------------------------------------------------------------------------------------------
    }
    
}
