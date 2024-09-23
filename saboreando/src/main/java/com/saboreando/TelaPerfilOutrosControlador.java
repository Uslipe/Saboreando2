package com.saboreando;

import com.saboreando.dados.beans.Postagem;
import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

public class TelaPerfilOutrosControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private GridPane gridPostagens;

    @FXML
    private HBox hboxCriar;

    @FXML
    private HBox hboxFeed;

    @FXML
    private HBox hboxPerfil;

    @FXML
    private HBox hboxSair;

    @FXML
    private Hyperlink hyperLinkSair;

    @FXML
    private Label labelPublicacoes;

    @FXML
    private Hyperlink linkParaTelaCriar;

    @FXML
    private Hyperlink linkParaTelaFeed;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private Label nomeDisplay;

    @FXML
    private Label numPublicacoes;

    @FXML
    private Label usernameDisplay;

    static String nomeDoUsuario;

    public static void setStringNomeUsuario(String nomeDado){
        nomeDoUsuario = nomeDado;
    }

    @FXML
    private void initialize(){
        nomeDisplay.setText(fachada.retornarUsuario(fachada.procurarUsuarioIndice(nomeDoUsuario)).getNome());
        usernameDisplay.setText(fachada.retornarUsuario(fachada.procurarUsuarioIndice(nomeDoUsuario)).getUsername());
        numPublicacoes.setText(String.valueOf(fachada.retornarQntPostagensUsuario(fachada.retornarUsuario(fachada.procurarUsuarioIndice(nomeDoUsuario)))));

        //Hover effect do menu (BOTÃO FEED)
        hboxFeed.setOnMouseEntered(event -> hboxFeed.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxFeed.setOnMouseExited(event -> hboxFeed.setStyle("-fx-background-color: transparent;"));

        //Hover effect do menu (BOTÃO CRIAR)
        hboxCriar.setOnMouseEntered(event -> hboxCriar.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxCriar.setOnMouseExited(event -> hboxCriar.setStyle("-fx-background-color: transparent;"));

        //Hover effect do menu (BOTÃO PERFIL)
        hboxPerfil.setOnMouseEntered(event -> hboxPerfil.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxPerfil.setOnMouseExited(event -> hboxPerfil.setStyle("-fx-background-color: transparent;"));

        hboxSair.setOnMouseEntered(event -> hboxSair.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxSair.setOnMouseExited(event -> hboxSair.setStyle("-fx-background-color: transparent;"));

        List<Postagem> listaPostagensOutroUsuario = new ArrayList<>(fachada.montarFeedDePostagensOutroUsuario(fachada.retornarUsuario(fachada.procurarUsuarioIndice(nomeDoUsuario))));
        int coluna = 0;
        int linha = 0;


        if(!listaPostagensOutroUsuario.isEmpty()){
            try {
                labelPublicacoes.setText("Publicações");
                for(Postagem p : listaPostagensOutroUsuario){
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
            labelPublicacoes.setText("Não há postagens feitas");
        }
    }

    //Direcionamento para tela feed
    @FXML
    public void HyperlinkActionTelaFeed(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaFeed.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaFeed.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HyperlinkActionTelaCriar(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaCriarPostagem.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaFeed.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void HyperLinkActionSair(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaLogin.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaFeed.getScene().getWindow();
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
