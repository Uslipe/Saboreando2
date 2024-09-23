package com.saboreando;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PaneCategoriaControlador {
    @FXML
    private ImageView imagemCategoria;

    @FXML
    private Label labelCategoria;

    @FXML
    public void setData(String texto){
        labelCategoria.setText(texto);
    }
}
