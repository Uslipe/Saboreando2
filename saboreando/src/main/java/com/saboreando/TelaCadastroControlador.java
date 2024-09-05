package com.saboreando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastroControlador {
    @FXML
    private Button botaoCadastrar;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputNome;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label labelErro;

    @FXML
    private Hyperlink linkParaTelaLogin;

    @FXML
    private Label titulo;

    //Método para direcionar para a tela de Login
    @FXML
    public void handleHyperlinkAction(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaLogin.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaLogin.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
