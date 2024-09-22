package com.saboreando;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PaneComentarioControlador {
    @FXML
    private Label ComentarioPane;

    @FXML
    private Label labelIdPostagem;

    @FXML
    private Label usernamePane;

    @FXML
    public void setData(String comentario, String username){
        ComentarioPane.setText(comentario);
        usernamePane.setText(username);
    }

    
}
