package com.saboreando;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
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
        //Fachada.getInstance().criarPostagem(new Postagem(RepositorioUsuario.getInstance().retornarUsuario(0).getUsername(), "Quarta postagem", "teste4"));
        //System.out.println(RepositorioPostagem.getInstance().retornarPostagemAleatoria());
        //System.out.println(ControladorPostagem.getInstance().montarFeedDePostagens());

        //Fachada.getInstance().cadastrarUsuario(new Usuario("Gisele", "gisele@smau.com", "xixa", "12345678"));
        //System.out.println(RepositorioUsuario.getInstance().listar());
        //System.out.println(ControladorPostagem.getInstance().montarFeedDePostagensUsuario());
        System.out.println(RepositorioPostagem.getInstance().listar());
        //RepositorioPostagem.getInstance().remover(RepositorioPostagem.getInstance().retornarPostagemPorIndice(3));
        System.out.println(Fachada.getInstance().retornarQntPostagensUsuario(RepositorioUsuario.getInstance().retornarUsuario(3)));

    }

}