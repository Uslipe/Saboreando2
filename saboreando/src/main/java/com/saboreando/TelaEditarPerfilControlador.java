package com.saboreando;

import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaEditarPerfilControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private Button botaoEnviar;

    @FXML
    private HBox hboxCriar;

    @FXML
    private HBox hboxFeed;

    @FXML
    private HBox hboxPerfil;

    @FXML
    private Hyperlink hyperLinkTelaFeed;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private TextField inputEditarEmail;

    @FXML
    private TextField inputEditarNome;

    @FXML
    private TextField inputEditarUsername;

    @FXML
    private void initialize(){
        botaoEnviar.setOnMouseEntered(event -> botaoEnviar.setStyle("-fx-background-color: #b30746; -fx-background-radius: 8"));
        botaoEnviar.setOnMouseExited(event -> botaoEnviar.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 8"));

        inputEditarEmail.setText(fachada.pegarInstanciaUsuarioLogado().getEmail());
        inputEditarNome.setText(fachada.pegarInstanciaUsuarioLogado().getNome());
        inputEditarUsername.setText(fachada.pegarInstanciaUsuarioLogado().getUsername());
    }

    @FXML
    public void HyperLinkActionTelaFeed(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaFeed.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) hyperLinkTelaFeed.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HyperLinkActionTelaPerfil(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaPerfil.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) hyperLinkTelaPerfil.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
