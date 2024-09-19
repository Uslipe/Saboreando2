package com.saboreando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PaneControlador {

    private static PaneControlador instance;

    public static PaneControlador getInstance(){
        
        if(instance == null){
            instance = new PaneControlador();
        }
        return instance;
    }

    @FXML
    private Hyperlink hyperLinkTelaPostagem;

    @FXML
    private Label tituloPane;

    @FXML
    private Label usernamePane;

    @FXML
    private Label labelIdPostagem;

    private int id;
    private static int retornoDoId;

    @FXML
    public void setData(String titulo, String username, int id){
        tituloPane.setText(titulo);
        usernamePane.setText(username);
        labelIdPostagem.setText(String.valueOf(id));
        this.id = id;
    }

    @FXML
    public void HyperlinkActionTelaCriar(@SuppressWarnings("exports") ActionEvent event) {
        try {
            //Passa o id para uma variável
            retornoDoId = id;

            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaPostagem.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) hyperLinkTelaPostagem.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getPostagemId(){
        return retornoDoId;
    }
}
