package com.saboreando;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PaneControlador {
    @FXML
    private Label tituloPane;

    @FXML
    private Label usernamePane;

    @FXML
    public void setData(String titulo, String username){
        tituloPane.setText(titulo);
        usernamePane.setText(username);
    }
}
