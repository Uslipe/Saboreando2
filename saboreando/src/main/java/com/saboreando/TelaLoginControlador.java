package com.saboreando;

import java.io.IOException;

import com.saboreando.exceptions.SenhaIncorretaException;
import com.saboreando.exceptions.UsuarioIncorretoException;
import com.saboreando.exceptions.UsuarioNaoEncontradoException;
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

public class TelaLoginControlador {

    Fachada fachada = Fachada.getInstance();
    
    @FXML
    private Button botaoLogar;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField inputUsuario;

    @FXML
    private Label titulo;

    @FXML
    private Label labelErro;

    @FXML
    private Hyperlink linkParaTelaCadastro;

    @FXML
    private void initialize(){
        botaoLogar.setOnMouseEntered(event -> botaoLogar.setStyle("-fx-background-color: #b30746; -fx-background-radius: 16"));
        botaoLogar.setOnMouseExited(event -> botaoLogar.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 16"));
    }

    // Método chamado ao clicar no botão de login
    @FXML
    private void handleBotaoLogarAction(ActionEvent event) throws SenhaIncorretaException, UsuarioIncorretoException, IOException {
        String username = inputUsuario.getText();
        String senha = inputSenha.getText();
        
        try {
            boolean loginBemSucedido = fachada.validarLogin(username, senha);
            
            if (loginBemSucedido) {
                // Login bem-sucedido, prossiga para a próxima tela ou exiba uma mensagem de sucesso
                System.out.println("Login bem-sucedido!");
                labelErro.setText("");
                
                //Ao apertar o botão de login (e ser bem sucedido), ir para a tela feed
                FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaFeed.fxml"));
                AnchorPane novaTela = loader.load();
            
                // Obter a cena atual e definir a nova tela como seu conteúdo
                Stage stage = (Stage) linkParaTelaCadastro.getScene().getWindow();
                Scene novaCena = new Scene(novaTela);
                stage.setScene(novaCena);
            }

        } 
        catch(UsuarioNaoEncontradoException e) {
            // Usuário não encontrado, exibir uma mensagem de erro
            System.out.println("Erro: " + e.getMessage());
            // Exibir uma mensagem de erro na interface gráfica, se necessário
            labelErro.setText("Usuário não encontrado!");
        } 
        catch(SenhaIncorretaException e){
            //Senha incorreta, exibir erro
            System.out.println("Erro: " + e.getMessage());
            // Exibir uma mensagem de erro na interface gráfica, se necessário
            labelErro.setText("Senha incorreta!");
        } 
        catch(UsuarioIncorretoException e){ //Chega até ser reduntante essa parte do código aqui
            //Usuário incorreto, exibir erro
            System.out.println("Erro: " + e.getMessage());
            // Exibir uma mensagem de erro na interface gráfica, se necessário
            labelErro.setText("Usuário incorreto!");
        }
    }

    //Método para direcionar para a tela de cadastro
    @FXML
    public void handleHyperlinkAction(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaCadastro.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaCadastro.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
