package com.saboreando;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import com.saboreando.dados.beans.Categorias;

import java.io.IOException;

import com.saboreando.dados.RepositorioComentario;
import com.saboreando.dados.RepositorioCurtida;
import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.UsuarioExisteException;
import com.saboreando.negocio.ControladorPostagem;
import com.saboreando.negocio.Fachada;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        scene = new Scene(loadFXML("telaLogin"), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws UsuarioExisteException {
        launch();
        List<Categorias> categorias = Arrays.asList(Categorias.VEGANO);
        //Fachada.getInstance().criarPostagem(new Postagem(RepositorioUsuario.getInstance().retornarUsuario(0).getUsername(), "Paçoca", "Ingredientes: \nAmendoím com sal\nAçṹcar\n\nModo de preparo:\nMoa o amendoim com sal junto do açúcar", categorias));

        //MÉTODOS PARA CADASTRAR USUÁRIOS CASO A LISTA CAIA -----------------------------------------------------------------------------------------------------------
            //Usuario usuario1 = new Usuario("Thiago", "thiago@smau.com", "Guinho", "12345678");
            //Usuario usuario2 = new Usuario("Gisele", "gisele@smau.com", "clawdeen", "pipoca88");
            //Fachada.getInstance().cadastrarUsuario(usuario1);
            //Fachada.getInstance().cadastrarUsuario(usuario2);

        
        Curtida curtida = new Curtida(RepositorioUsuario.getInstance().retornarUsuario(1), RepositorioPostagem.getInstance().retornarPostagemPorIndice(0));
        //RepositorioCurtida.getInstance().inserir(curtida);

        //System.out.println(RepositorioPostagem.getInstance().retornarIndicePostagem(curtida.getPostagemRelacionada()));
        

        //System.out.println(RepositorioCurtida.getInstance().listar());
        //System.out.println(RepositorioCurtida.getInstance().retornarQntCurtidasPostagem(RepositorioPostagem.getInstance().retornarPostagemPorIndice(0)));
        //System.out.println(RepositorioUsuario.getInstance().listar());
        
        //System.out.println(RepositorioCurtida.getInstance().curtiuOuNao(RepositorioUsuario.getInstance().retornarUsuario(1), RepositorioPostagem.getInstance().retornarPostagemPorIndice(0))); 
        
        //System.out.println(RepositorioPostagem.getInstance().retornarPostagemPorIndice(0).getCategorias());
        System.out.println(RepositorioPostagem.getInstance().listar());








        
        Comentario comentario = new Comentario(
            /*usuario*/ RepositorioUsuario.getInstance().retornarUsuario(1), 
            /*postagem*/RepositorioPostagem.getInstance().retornarPostagemPorIndice(0), 
            /*texto*/"Comentário 3");

        //RepositorioComentario.getInstance().inserir(comentario);
        //System.out.println(RepositorioComentario.getInstance().listar());
        System.out.println(RepositorioComentario.getInstance().listarComentariosPostagem(RepositorioPostagem.getInstance().retornarPostagemPorIndice(0)));    


    }

}