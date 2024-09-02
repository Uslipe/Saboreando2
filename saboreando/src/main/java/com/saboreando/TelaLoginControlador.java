package com.saboreando;

import com.saboreando.exceptions.UsuarioNaoEncontradoException;
import com.saboreando.negocio.LoginControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TelaLoginControlador {

    LoginControlador loginControlador = LoginControlador.getInstance();
    
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

        // Método chamado ao clicar no botão de login
    @FXML
    private void handleBotaoLogarAction(ActionEvent event) {
        String username = inputUsuario.getText();
        String senha = inputSenha.getText();
        
        try {
            boolean loginBemSucedido = loginControlador.validarLogin(username, senha);
            
            if (loginBemSucedido) {
                // Login bem-sucedido, prossiga para a próxima tela ou exiba uma mensagem de sucesso
                System.out.println("Login bem-sucedido!");
                labelErro.setText("");
                // Aqui você pode navegar para a próxima tela, por exemplo:
                // irParaProximaTela();
            }

        } catch (UsuarioNaoEncontradoException e) {
            // Usuário não encontrado, exibir uma mensagem de erro
            System.out.println("Usuário não encontrado: " + e.getMessage());
            // Exibir uma mensagem de erro na interface gráfica, se necessário
            labelErro.setText("Usuário não encontrado!");
            
        }
    }

}
