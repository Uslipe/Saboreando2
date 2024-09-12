# Saboreando2
Versão 2 do projeto "Saboreando"

# Projeto de Gerenciamento de Postagens

Este projeto é uma aplicação desenvolvida em Java e JavaFX para o gerenciamento de postagens, usuários, curtidas e comentários. O sistema utiliza uma arquitetura em camadas para promover modularidade, escalabilidade e separação de responsabilidades.

## Arquitetura em Camadas

O projeto é estruturado em várias camadas, cada uma com uma função específica:

- **Camada de Controle**: Gerencia a lógica da aplicação e a interação entre a interface do usuário e os dados. Inclui:
  - `ControladorPostagem`: Manipula operações relacionadas a postagens.
  - `ControladorUsuario`: Gerencia operações de usuários.
  - `ControladorCurtida`: Lida com as curtidas.
  - `ControladorComentario`: Administra os comentários.

- **Camada de Repositório**: Responsável pela persistência e recuperação dos dados. Inclui:
  - `RepositorioPostagem`: Gerencia as postagens.
  - `RepositorioUsuario`: Administra os usuários.
  - `RepositorioCurtida`: Lida com as curtidas em postagens.
  - `RepositorioComentario`: Gerencia os comentários.

 ```mermaid
classDiagram

    
    class ControladorPostagem {
        +criarPostagem()  void
        +retornarTituloPostagem()  String
        +retornarConteudoPostagem()  String
        +retornarAutorPostagem()  String
        +excluirPostagem()  void
    }

    class ControladorUsuario {
        +cadastrarUsuario()  void
        +editarUsernameUsuario()  void
        +editarEmailUsuario()  void
        +editarNomeUsuario()  void
        +excluirUsuario()  void
    }

    class ControladorCurtida {
        +inserirCurtida()  void
    }

    class ControladorComentario {
        +inserirComentario()  void
    }

    class RepositorioUsuario {
        +inserir()  void
        +listar()  ArrayList<Usuario>
        +procurarUsuarioIndice()  int
        +retornarUsuario()  Usuario
        +remover()  void
        +editarUsername()  void
        +editarEmail()  void
        +editarNome()  void
    }

    class RepositorioPostagem {
        +inserir()  void
        +listar()  ArrayList<Postagem>
        +remover()  void
        +retornarUsernameAutor()  String
        +retornarTituloPostagem()  String
        +retornarConteudoPostagem()  String
    }

    class RepositorioCurtida {
        +inserir()  void
        +listarCurtidasPostagem()  ArrayList<Curtida>
        +curtiuOuNao()  boolean
    }

    class RepositorioComentario {
        +inserir()  void
        +listarComentariosPostagem()  ArrayList<Comentario>
    }

    Fachada --> Telas
  
    ControladorUsuario --> Fachada
    ControladorPostagem --> Fachada
    ControladorCurtida --> Fachada
    ControladorComentario --> Fachada

    RepositorioUsuario --> ControladorUsuario
    RepositorioPostagem --> ControladorPostagem
    RepositorioCurtida --> ControladorCurtida
    RepositorioComentario --> ControladorComentario

```

## Padrão Singleton

O padrão Singleton é utilizado para garantir que exista uma única instância de certos componentes e fornecer um ponto global de acesso a essas instâncias. Isso é implementado principalmente nas classes de repositório, assegurando uma única fonte de dados consistente durante a execução da aplicação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para a lógica da aplicação, incluindo as camadas de controle e repositório.
- **JavaFX**: Biblioteca para criar a interface gráfica do usuário, oferecendo uma experiência interativa e rica.
