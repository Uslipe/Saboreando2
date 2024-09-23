package com.saboreando.dados.beans;

public enum Categorias {
    NENHUM(""),
    VEGANO("../../../../../resources/com/saboreando/images/vegan.png"),
    CARNE("../../../../../resources/com/saboreando/images/steak.png"),
    SOBREMESA("../../../../../resources/com/saboreando/images/dessert.png"),
    MASSA("../../../../../resources/com/saboreando/images/pasta.png"),
    DOCE("../../../../../resources/com/saboreando/images/candy.png"),
    BEBIDAS("../../../../../resources/com/saboreando/images/drink.png");

    private String caminhoImagem;

    // Construtor do enum
    Categorias(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    // Método para obter o caminho da imagem associado à categoria
    public String getCaminhoImagem() {
        return caminhoImagem;
    }
}
