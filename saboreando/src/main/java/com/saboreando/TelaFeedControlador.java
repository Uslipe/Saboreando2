package com.saboreando;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Postagem;
import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaFeedControlador {

    Fachada fachada = Fachada.getInstance();
    private static TelaFeedControlador instance;

    public static TelaFeedControlador getInstance(){
        if(instance == null){
            instance = new TelaFeedControlador();
        }
        return instance;
    }

    @FXML
    private GridPane gridPostagens;

    @FXML
    private HBox hboxCriar;

    @FXML
    private HBox hboxFeed;

    @FXML
    private HBox hboxPerfil;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private Hyperlink hyperLinkTelaCriar;

    @FXML
    private void initialize(){
        //Hover effect do menu (BOTÃO FEED)
        hboxFeed.setOnMouseEntered(event -> hboxFeed.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxFeed.setOnMouseExited(event -> hboxFeed.setStyle("-fx-background-color: transparent;"));

        //Hover effect do menu (BOTÃO CRIAR)
        hboxCriar.setOnMouseEntered(event -> hboxCriar.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxCriar.setOnMouseExited(event -> hboxCriar.setStyle("-fx-background-color: transparent;"));

        //Hover effect do menu (BOTÃO PERFIL)
        hboxPerfil.setOnMouseEntered(event -> hboxPerfil.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxPerfil.setOnMouseExited(event -> hboxPerfil.setStyle("-fx-background-color: transparent;"));

        List<Postagem> listaPostagensFeed = new ArrayList<>(fachada.montarFeedDePostagens());

        int coluna = 0;
        int linha = 0;

        if(!listaPostagensFeed.isEmpty()){
            try {
                for(Postagem p : listaPostagensFeed){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("panePostagem.fxml"));
                    Pane pane = fxmlLoader.load();
                    PaneControlador paneControlador = fxmlLoader.getController();
                    paneControlador.setData(p.getTituloPostagem(), p.getAutorPostagem(), fachada.retornarIndicePostagem(p));

                    if(coluna == 2){
                        coluna = 0;
                        linha++;
                    }
                    gridPostagens.add(pane, coluna++, linha);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Não há postagens feitas");
        }
    }

    //Direcionamento para tela perfil
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

    @FXML
    public void HyperLinkActionTelaCriar(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaCriarPostagem.fxml"));
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
