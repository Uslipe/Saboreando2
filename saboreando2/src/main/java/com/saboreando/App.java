package com.saboreando;

import com.exceptions.UsuarioExisteException;
import com.exceptions.UsuarioNaoEncontradoException;
import com.saboreando.dados.RepositorioCurtida;
import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.negocio.ControladorPostagem;
import com.saboreando.negocio.ControladorUsuario;

public class App 
{
    public static void main( String[] args ) throws UsuarioExisteException, UsuarioNaoEncontradoException{
        new RepositorioUsuario();
        //Instanciando o repositorio de usuários com sigleton
        RepositorioUsuario repositorioUsuario = RepositorioUsuario.getInstance();
        RepositorioPostagem repositorioPostagem = RepositorioPostagem.getInstance();
        RepositorioCurtida repositorioCurtida = RepositorioCurtida.getInstance();

        //Instanciando os controladores
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        ControladorPostagem controladorPostagem = ControladorPostagem.getInstance();

        //TESTES DE USUÁRIO
        //-------------------------------------------------------------------------------------------------------------------
        
        //Teste para inserção de usuários (SUCESSO)
        //System.out.println("TESTE DE CADASTRO DE USUÁRIOS\n");

        Usuario usuario1 = new Usuario("Felipe", "felipe@smau.com", "uslipe", "12345678");
        Usuario usuario2 = new Usuario("Gisele", "gisele@smau.com", "xixa", "12345678");
        Usuario usuario3 = new Usuario("Giovana", "giovana@smau.com", "xeo", "12345678");
        Usuario usuario4 = new Usuario("Joanderson", "joanderson@smau.com", "joa", "12345678");

        controladorUsuario.cadastrarUsuario(usuario1);
        controladorUsuario.cadastrarUsuario(usuario2);
        controladorUsuario.cadastrarUsuario(usuario3);
        //Teste de exception [OK] - controladorUsuario.cadastrarUsuario(usuario4);

        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para troca de username (SUCESSO)
        //System.out.println("\nTESTE DE TROCA DE USERNAME\n");
        controladorUsuario.editarUsernameUsuario(usuario3, "gioca");
        //Essa linha gera erro corretamente, porém se eu alterar o username de instância dele para "uslipe", o código buga lindamente - controladorUsuario.editarUsernameUsuario(usuario4, "joanderson");
        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para exclusão de usuário (SUCESSO)
        //System.out.println("\nTESTE DE EXCLUSÃO DE USUÁRIO\n");
        //controladorUsuario.excluirUsuario("GIOCONDA", "12345678");
        //System.out.println(repositorioUsuario.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //TESTES DE POSTAGEM
        //Teste para cadastro de postagens (SUCESSO) (passar pelo controladorUsuario ainda)
        Postagem postagem1 = new Postagem(usuario1, "Bolo de morango", "Bolo branco com cauda de morango");
        Postagem postagem2 = new Postagem(usuario2, "Tteokbokki", "Bolinho de farinha de arroz com molho apimentado");
        Postagem postagem3 = new Postagem(usuario2, "Banana juice", "Leite saborizado com essência de banana");

        controladorPostagem.criarPostagem(postagem1);
        controladorPostagem.criarPostagem(postagem2);
        controladorPostagem.criarPostagem(postagem3);

        System.out.println("\nTESTE DE CADASTRO DE POSTAGEM\n");
        System.out.println(repositorioPostagem.listar()); //Usando o repositorio só para listar
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
