package com.saboreando;

import java.io.IOException;

import com.saboreando.exceptions.CurtidaExistenteException;
import com.saboreando.exceptions.UsuarioExisteException;
import com.saboreando.exceptions.UsuarioNaoEncontradoException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class App extends Application{
    public static void main( String[] args ) throws UsuarioExisteException, UsuarioNaoEncontradoException, CurtidaExistenteException{
        //Javafx
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/resources/aplicacao/telaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Tela 1");
        stage.setScene(scene);
        stage.show();
    }
    
}
