package com.saboreando;

import com.saboreando.dados.beans.Postagem;
import com.saboreando.negocio.Fachada;

import java.util.List;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaPerfilControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private Button botaoEditarPerfil;
    
    @FXML
    private HBox hboxCriar;

    @FXML
    private HBox hboxFeed;

    @FXML
    private HBox hboxPerfil;

    @FXML
    private Hyperlink linkParaTelaFeed;

    @FXML
    private Label nomeDisplay;

    @FXML
    private Label numPublicacoes;

    @FXML
    private Label usernameDisplay;
    
    @FXML
    private Label labelPublicacoes;

    @FXML
    private GridPane gridPostagens;

    @FXML
    private void initialize(){
        nomeDisplay.setText(fachada.pegarInstanciaUsuarioLogado().getNome());
        usernameDisplay.setText(fachada.pegarInstanciaUsuarioLogado().getUsername());
        numPublicacoes.setText(String.valueOf(fachada.retornarQntPostagensUsuario(fachada.pegarInstanciaUsuarioLogado())));

        botaoEditarPerfil.setOnMouseEntered(event -> botaoEditarPerfil.setStyle("-fx-background-color: #b30746; -fx-background-radius: 8"));
        botaoEditarPerfil.setOnMouseExited(event -> botaoEditarPerfil.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 8"));

        List<Postagem> listaPostagensUsuario = new ArrayList<>(fachada.montarFeedDePostagensUsuario());
        int coluna = 0;
        int linha = 1;
        

        if(!listaPostagensUsuario.isEmpty()){
            try {
                labelPublicacoes.setText("Publicações");
                for(Postagem p : listaPostagensUsuario){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("panePostagem.fxml"));
                    Pane pane = fxmlLoader.load();
                    PaneControlador paneControlador = fxmlLoader.getController();
                    paneControlador.setData(p.getTituloPostagem(), p.getAutorPostagem());

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

    //Direcionamento para tela editar perfil
    @FXML
    public void HyperlinkActionTelaEditarPerfil(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaEditar.fxml"));
            AnchorPane novaTela = loader.load();
            
            // Obter a cena atual e definir a nova tela como seu conteúdo
            Stage stage = (Stage) linkParaTelaFeed.getScene().getWindow();
            Scene novaCena = new Scene(novaTela);
            stage.setScene(novaCena);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
