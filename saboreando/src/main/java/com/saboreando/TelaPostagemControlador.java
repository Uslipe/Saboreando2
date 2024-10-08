package com.saboreando;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;

import com.saboreando.dados.beans.Categorias;
import com.saboreando.dados.beans.Comentario;
import com.saboreando.dados.beans.Curtida;

public class TelaPostagemControlador {

    Fachada fachada = Fachada.getInstance();

    @FXML
    private Button botaoCurtir;

    @FXML
    private Button botaoProximo;

    @FXML
    private Button botaoAdicionarComentario;

    @FXML
    private Button botaoAnterior;

    @FXML
    private GridPane gridComentarios;

    @FXML
    private ImageView imageCoracao;

    @FXML
    private Label labelQntCurtidas;

    @FXML
    private GridPane gridPostagens;

    @FXML
    private GridPane gridCategorias;

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
    private Hyperlink hyperLinkTelaCriar;

    @FXML
    private Hyperlink hyperLinkTelaPerfil;

    @FXML
    private Hyperlink hyperLinkTelaFeed;

    @FXML
    private Hyperlink labelAutorPostagem;

    @FXML
    private Label labelConteudoPostagem;

    @FXML
    private Label labelTituloPostagem;

    private List<Comentario> listaComentarios;
    int indicePostagem = 0;

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

        botaoCurtir.setOnMouseEntered(event -> botaoCurtir.setStyle("-fx-background-color: #b30746; -fx-background-radius: 8"));
        botaoCurtir.setOnMouseExited(event -> botaoCurtir.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 8"));

        botaoAdicionarComentario.setOnMouseEntered(event -> botaoAdicionarComentario.setStyle("-fx-background-color: #b30746; -fx-background-radius: 8"));
        botaoAdicionarComentario.setOnMouseExited(event -> botaoAdicionarComentario.setStyle("-fx-background-color: #e00958;  -fx-background-radius: 8"));
        
        Postagem postagem = fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId());
        labelAutorPostagem.setText(postagem.getAutorPostagem());
        labelConteudoPostagem.setText(postagem.getConteudo());
        labelTituloPostagem.setText(postagem.getTituloPostagem());

        //Inicializador de categorias--------------------------------------------------------------------------------------------------------------------------

        List<Categorias> listaCategorias = postagem.getCategorias();

        int coluna = 0;

        if(!listaCategorias.isEmpty()){
            try {
                for(Categorias categoria : listaCategorias){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("paneCategoria.fxml"));
                    Pane pane = fxmlLoader.load();
                    PaneCategoriaControlador paneCategoriaControlador = fxmlLoader.getController();
                    paneCategoriaControlador.setData(categoria.name());
                    
                    gridCategorias.add(pane, coluna, 0);

                    if(coluna == 1){
                        break;
                    }
                    coluna++;

                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            System.out.println("A lista de categorias está vazia trouxão");
        }



        //Inicializador de curtidas----------------------------------------------------------------------------------------------------------------------------

        if(fachada.curtiuOuNao(fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId()))){
            botaoCurtir.setText("Descurtir");
        }
        else{
            botaoCurtir.setText("Curtir");
        }

        labelQntCurtidas.setText(String.valueOf(fachada.retornarQntCurtidasPostagem(postagem)));

        //Inicializador de comentários--------------------------------------------------------------------------------------------------------------------------
        listaComentarios = new ArrayList<>(fachada.listarComentariosPostagem(postagem));

        if(!listaComentarios.isEmpty()){
            try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("paneComentario.fxml"));
                    Pane pane = fxmlLoader.load();
                    PaneComentarioControlador paneComentarioControlador = fxmlLoader.getController();
                    paneComentarioControlador.setData(listaComentarios.get(indicePostagem).getTexto(), listaComentarios.get(indicePostagem).getAutor().getUsername());

                    gridComentarios.add(pane, 0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
    public void HyperLinkActionTelaAdicionarComentario(@SuppressWarnings("exports") ActionEvent event) {
        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaAdicionarComentario.fxml"));
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
    public void curtir() throws CurtidaExistenteException{
        Curtida curtida = new Curtida(fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId()));
        fachada.inserirOuRemoverCurtida(curtida, fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId()));
        if(fachada.curtiuOuNao(fachada.pegarInstanciaUsuarioLogado(), fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId()))){
            botaoCurtir.setText("Descurtir");
        }
        else{
            botaoCurtir.setText("Curtir");
        }
        labelQntCurtidas.setText(String.valueOf(fachada.retornarQntCurtidasPostagem(fachada.retornarPostagemPorIndice(PaneControlador.getPostagemId()))));
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

    @FXML
    public void proximo(){
            gridComentarios.getChildren().clear();
            indicePostagem++;

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("paneComentario.fxml"));
                Pane pane = fxmlLoader.load();
                PaneComentarioControlador paneComentarioControlador = fxmlLoader.getController();
                paneComentarioControlador.setData(listaComentarios.get(indicePostagem).getTexto(), listaComentarios.get(indicePostagem).getAutor().getUsername());

                gridComentarios.add(pane, 0, 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void anterior(){
            gridComentarios.getChildren().clear();
            indicePostagem--;

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("paneComentario.fxml"));
                Pane pane = fxmlLoader.load();
                PaneComentarioControlador paneComentarioControlador = fxmlLoader.getController();
                paneComentarioControlador.setData(listaComentarios.get(indicePostagem).getTexto(), listaComentarios.get(indicePostagem).getAutor().getUsername());

                gridComentarios.add(pane, 0, 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void mandarNomeParaTelaPerfilOutros(){
        TelaPerfilOutrosControlador.setStringNomeUsuario(labelAutorPostagem.getText());

        try {
            // Carregar o novo arquivo FXML
            FXMLLoader loader = new FXMLLoader(TelaLoginControlador.class.getResource("telaPerfilOutros.fxml"));
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