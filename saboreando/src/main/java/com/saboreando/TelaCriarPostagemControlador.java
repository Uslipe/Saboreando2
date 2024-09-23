package com.saboreando;

import com.saboreando.dados.beans.Categorias;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;

public class TelaCriarPostagemControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private ChoiceBox<Categorias> choiceBoxCategorias;

    @FXML
    private Button botaoEnviar;

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
    private Hyperlink hyperLinkTelaFeed;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private TextField inputConteudoPostagem;

    @FXML
    private TextField inputTituloPostagem;

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

        hboxSair.setOnMouseEntered(event -> hboxSair.setStyle("-fx-background-color: #f7b9cd; -fx-background-radius: 24"));
        hboxSair.setOnMouseExited(event -> hboxSair.setStyle("-fx-background-color: transparent;"));

        //Hover botão criar
        botaoEnviar.setOnMouseEntered(event -> botaoEnviar.setStyle("-fx-background-color: #b30746; -fx-background-radius: 8"));
        botaoEnviar.setOnMouseExited(event -> botaoEnviar.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 8"));

        //ChoiceBox
        //Populando o ChoiceBox com as categorias
        choiceBoxCategorias.getItems().addAll(Categorias.values());
        choiceBoxCategorias.setValue(Categorias.values()[0]); // Define uma categoria padrão
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

    @FXML 
    void handleBotaoCriarPostagemAction(ActionEvent event) {
        String titulo = inputTituloPostagem.getText();
        String conteudo = inputConteudoPostagem.getText();
    
        // Coleta as categorias selecionadas do ChoiceBox
        List<Categorias> categoriasSelecionadas = new ArrayList<>();
        Categorias categoriaSelecionada = choiceBoxCategorias.getValue();
        if (categoriaSelecionada != null && !categoriaSelecionada.equals(Categorias.NENHUM)) {
            categoriasSelecionadas.add(categoriaSelecionada);
        }
    
        // Cria a postagem com as categorias
        Postagem postagem = new Postagem(fachada.getUsuarioLogado(), titulo, conteudo, categoriasSelecionadas);
        fachada.criarPostagem(postagem);
    
        System.out.println("Postagem cadastrada na tela");
    
        // Limpa os campos de entrada
        inputConteudoPostagem.setText(null);
        inputTituloPostagem.setText(null);
    }
    

    @FXML
    public void HyperLinkActionSair(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaLogin.fxml"));
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
