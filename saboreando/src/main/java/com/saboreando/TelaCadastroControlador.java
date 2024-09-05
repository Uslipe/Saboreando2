package com.saboreando;

import com.saboreando.dados.beans.Usuario;
import com.saboreando.exceptions.UsuarioExisteException;
import com.saboreando.negocio.Fachada;

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

    Fachada fachada = Fachada.getInstance();

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

    //Método para fazer cadastro
    @FXML
    private void handleBotaoCadastrarAction(ActionEvent event) throws UsuarioExisteException{
        String nome = inputNome.getText();
        String email = inputEmail.getText();
        String username = inputUsuario.getText();
        String senha = inputSenha.getText();

        try{
            Usuario usuario = new Usuario(nome, email, username, senha);
            fachada.cadastrarUsuario(usuario);
            System.out.println("Usuario cadastrado com sucesso");
        } 
        catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
            labelErro.setText("Parâmetro inválido");
        }
        catch(UsuarioExisteException e){
            System.out.println("Erro: " + e.getMessage());
            labelErro.setText("O usuário com o nome \"" + username + "\" já existe");
        }

        
    }

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
