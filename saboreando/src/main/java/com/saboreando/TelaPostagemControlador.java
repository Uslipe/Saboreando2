package com.saboreando;

import java.util.List;

import com.saboreando.dados.beans.Postagem;
import com.saboreando.exceptions.CurtidaExistenteException;
import com.saboreando.negocio.Fachada;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import com.saboreando.dados.beans.Curtida;

public class TelaPostagemControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private Button botaoCurtir;

    @FXML
    private ImageView imageCoracao;

    @FXML
    private Label labelQntCurtidas;

    @FXML
    private GridPane gridPostagens;

    @FXML
    private HBox hboxCriar;

    @FXML
    private HBox hboxFeed;

    @FXML
    private HBox hboxPerfil;

    @FXML
    private Hyperlink hyperLinkTelaCriar;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private Hyperlink hyperLinkTelaFeed;

    @FXML
    private Label labelAutorPostagem;

    @FXML
    private Label labelConteudoPostagem;

    @FXML
    private Label labelTituloPostagem;

    @FXML
    private void initialize(){
        Postagem postagem = fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId());
        labelAutorPostagem.setText(postagem.getAutorPostagem());
        labelConteudoPostagem.setText(postagem.getConteudo());
        labelTituloPostagem.setText(postagem.getTituloPostagem());

        labelQntCurtidas.setText(String.valueOf(fachada.retornarQuantidadeCurtidas(postagem)));
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
    public void curtir() throws CurtidaExistenteException{
        Curtida curtida = new Curtida(fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getInstance().getPostagemId()));
        fachada.inserirOuRemoverCurtida(curtida, fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getInstance().getPostagemId()));
        labelQntCurtidas.setText(String.valueOf(fachada.retornarQuantidadeCurtidas(fachada.retornarPostagemPorIndice(PaneControlador.getInstance().getPostagemId()))));
    }
}
