package com.saboreando;

import java.util.ArrayList;
import java.util.List;

import com.saboreando.dados.beans.Categorias;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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
    private ChoiceBox<Categorias> choiceBoxCategorias;

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
    private HBox hboxSair;

    @FXML
    private Hyperlink hyperLinkSair;

    @FXML
    private void initialize() {
        // ... (código do hover)
    
        // Populando o ChoiceBox com as categorias
        choiceBoxCategorias.getItems().addAll(Categorias.values());
        choiceBoxCategorias.setValue(Categorias.values()[0]); // Define uma categoria padrão
    
        List<Postagem> listaPostagensFeed = new ArrayList<>(fachada.montarFeedDePostagens());
    
        final int[] coluna = {0};
        final int[] linha = {0};
    
        // Filtragem inicial
        filtrarPostagens(listaPostagensFeed, choiceBoxCategorias.getValue(), coluna, linha);
    
        // Listener para atualizar as postagens ao mudar a categoria
        choiceBoxCategorias.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            coluna[0] = 0; // Reinicia a coluna
            linha[0] = 0;  // Reinicia a linha
            gridPostagens.getChildren().clear(); // Limpa o grid
            filtrarPostagens(listaPostagensFeed, newValue, coluna, linha);
        });
    }
    
    private void filtrarPostagens(List<Postagem> listaPostagensFeed, Categorias categoria, int[] coluna, int[] linha) {
        if (!listaPostagensFeed.isEmpty()) {
            try {
                for (Postagem p : listaPostagensFeed) {
                    // Se a categoria for 'NENHUM', mostra todas as postagens
                    if (categoria.equals(Categorias.NENHUM) || 
                        p.getCategorias().contains(categoria)) {
                        
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("panePostagem.fxml"));
                        Pane pane = fxmlLoader.load();
                        PaneControlador paneControlador = fxmlLoader.getController();
                        paneControlador.setData(p.getTituloPostagem(), p.getAutorPostagem(), fachada.retornarIndicePostagem(p));
    
                        if (coluna[0] == 2) {
                            coluna[0] = 0;
                            linha[0]++;
                        }
                        gridPostagens.add(pane, coluna[0]++, linha[0]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
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
