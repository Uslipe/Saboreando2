package com.saboreando.negocio;

import com.saboreando.dados.RepositorioPostagem;
import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Postagem;
import com.saboreando.dados.beans.Usuario;

public class ControladorPostagem {
    private static ControladorPostagem instance;
    private RepositorioPostagem repositorioPostagem;

    //Padrão singleton de única instância
    public static ControladorPostagem getInstance(){
        if(instance == null){
            instance = new ControladorPostagem();
        }
        return instance;
    }

    //Construtor da classe
    public ControladorPostagem(){
        this.repositorioPostagem = RepositorioPostagem.getInstance();
    }

    //Criar uma nova postagem
    public void criarPostagem(Postagem postagem){
        //Abordagem um pouco diferente do cadastrarUsuario
        if(postagem.getAutorPostagem() != null && postagem.getConteudo() != null){
            repositorioPostagem.inserir(postagem);
        }
        else{
            throw new IllegalArgumentException("Argumento nulo");
        }
    }

    //MÉTODOS PARA MONTAGEM DA POSTAGEM
    //Retornar o título
    public String retornarTituloPostagem(Postagem postagem){
        if(repositorioPostagem.retornarTituloPostagem(postagem) != null){
            return repositorioPostagem.retornarTituloPostagem(postagem);
        }
        else{
            throw new IllegalArgumentException("Titulo da postagem não identificado");
        }
    }

    //Retornar conteúdo
    public String retornarConteudoPostagem(Postagem postagem){
        if(repositorioPostagem.retornarConteudoPostagem(postagem) != null){
            return repositorioPostagem.retornarConteudoPostagem(postagem);
        }
        else{
            throw new IllegalArgumentException("Conteúdo da postagem não identificado");
        }
    }

    //RetornarAutor
    public String retornarAutorPostagem(Postagem postagem){
        if(repositorioPostagem.retornarUsernameAutor(postagem) != null){
            return  repositorioPostagem.retornarUsernameAutor(postagem);
        }
        else{
            throw new IllegalArgumentException("Conteúdo da postagem não identificado");
        }
    }

    //Retornar quantidade de curtidas
    public int retornarQuantidadeCurtidas(Postagem postagem){
        return repositorioPostagem.contabilizarCurtidas(postagem);
    }

    //Retornar quantidade de comentários
    public int retornarQuantidadeComentarios(Postagem postagem){
        return repositorioPostagem.contabilizarComentarios(postagem);
    }

    //Excluir postagem
    //para excluir, tem que verificar se o autor postagem é o mesmo usuário da pessoa logada
    public void excluirPostagem(Usuario usuario, Postagem postagem){
        //Verifica se o usuário é o autor da postagem
        if(usuario.equals(postagem.getAutorPostagem())){
            repositorioPostagem.remover(postagem);
        }
        else{
            throw new IllegalArgumentException("Usuário inválido");
        }
    }
}
