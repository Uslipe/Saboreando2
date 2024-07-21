package com.saboreando;

import com.saboreando.dados.RepositorioUsuario;
import com.saboreando.dados.beans.Usuario;
import com.saboreando.negocio.ControladorUsuario;

public class App 
{
    public static void main( String[] args ){
        new RepositorioUsuario();
        //Instanciando o repositorio de usuários com sigleton
        RepositorioUsuario repositorio = RepositorioUsuario.getInstance();

        //Instanciando o controlador de usuários
        ControladorUsuario controlador = ControladorUsuario.getInstance();
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para inserção de usuários (SUCESSO)
        Usuario usuario1 = new Usuario("Felipe", "felipe@smau.com", "uslipe", "12345678");
        Usuario usuario2 = new Usuario("Gisele", "gisele@smau.com", "xixa", "12345678");
        Usuario usuario3 = new Usuario("Giovana", "giovana@smau.com", "xeo", "12345678");

        controlador.cadastrarUsuario(usuario1);
        controlador.cadastrarUsuario(usuario2);
        controlador.cadastrarUsuario(usuario3);

        System.out.println(repositorio.listar());
        //-------------------------------------------------------------------------------------------------------------------

        //Teste para troca de username (SUCESSO) [ALTERAR PARA CONTROLADOR]
        controlador.editarUsernameUsuario(usuario3, "GIOCONDA");
        System.out.println(repositorio.listar());
        //-------------------------------------------------------------------------------------------------------------------


    }
}
