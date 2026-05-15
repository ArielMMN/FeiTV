# FEItv

Projeto da disciplina CCM310 — Profa. Gabriela Biondi e Prof. Isaac de Jesus  
Centro Universitário FEI

---

## Objetivo

O FEItv é uma plataforma desktop de informações sobre vídeos (filmes e séries), desenvolvida em Java com interface gráfica Swing e persistência de dados em banco de dados PostgreSQL. O sistema permite que usuários se cadastrem, façam login, busquem vídeos, curtam conteúdos e gerenciem listas de reprodução favoritas.

---

## Tecnologias Utilizadas

- **Java** — linguagem principal de desenvolvimento
- **Swing** — biblioteca para construção da interface gráfica (GUI)
- **JDBC + PostgreSQL** — conexão e persistência de dados no banco relacional
- **NetBeans IDE** — ambiente de desenvolvimento utilizado
- **Git / GitHub** — controle de versão

---

## Arquitetura MVC

O projeto segue o padrão arquitetural **Model-View-Controller (MVC)**:

- **Model** (`src/model/`) — classes de domínio: `Video` (abstrata), `Filme`, `Serie`, `Usuario`, `ListaReproducao`, `Curtida`, e a interface `Situacao`.
- **View** (`src/view/`) — telas Swing: `Login`, `Cadastro`, `Principal`, `Busca`, `DetalhesVideo`, `Logado`, `Favoritos`, `ListasReproducao`, `Alteracao`, `Exclusao`.
- **Controller** (`src/controller/`) — lógica de negócio: `ControleLogin`, `ControleCadastro`, `ControleBusca`, `ControleDetalhesVideo`, `ControleFavoritos`, `ControleListasReproducao`, `ControleLogado`, `ControleAlteracao`, `ControleExclusao`.
- **DAO** (`src/dao/`) — acesso ao banco de dados: `UsuarioDAO`, `VideoDAO`, `CurtidaDAO`, `FavoritoDAO`, `ListaReproducaoDAO`, `Conexao`.

---

## Diagrama de Classes

```
<<interface>>
Situacao
    └── Video (abstract)
            ├── Filme
            └── Serie

Usuario  ◄──  ListaReproducao  ──►  Video
Usuario  ◄──  Curtida          ──►  Video
```

- `Video` é uma classe **abstrata** que implementa a interface `Situacao`.
- `Filme` e `Serie` herdam de `Video` e implementam os métodos abstratos `exibirInfo()` e `getSituacao()`.
- `getSituacao()` retorna a duração (filmes) ou número de temporadas (séries).

---

## Funcionalidades Implementadas

### Usuário
- **Cadastro** — criação de nova conta com nome, e-mail e senha (senha armazenada com hash SHA-256)
- **Login** — autenticação por e-mail e senha
- **Busca de vídeos** — pesquisa por nome, exibindo resultados em tabela
- **Detalhes do vídeo** — visualização completa das informações de um vídeo selecionado
- **Curtir / Descurtir** — registra ou remove curtida de um vídeo
- **Favoritos** — adiciona ou remove vídeos de uma lista de favoritos
- **Listas de reprodução** — cria, edita, exclui listas e gerencia os vídeos dentro delas

---

## Banco de Dados

Banco: **PostgreSQL**  
Nome do banco: `feitv`

### Tabelas

```sql
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(64)  -- hash SHA-256
);

CREATE TABLE video (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200),
    descricao TEXT,
    anoLancamento INT,
    tipo VARCHAR(10),      -- 'filme' ou 'serie'
    duracao INT,           -- apenas para filmes (minutos)
    temporadas INT         -- apenas para séries
);

CREATE TABLE curtida (
    usuario_id INT REFERENCES usuario(id),
    video_id INT REFERENCES video(id),
    PRIMARY KEY (usuario_id, video_id)
);

CREATE TABLE favorito (
    usuario_id INT REFERENCES usuario(id),
    video_id INT REFERENCES video(id),
    PRIMARY KEY (usuario_id, video_id)
);

CREATE TABLE lista_reproducao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    usuario_id INT REFERENCES usuario(id)
);

CREATE TABLE lista_video (
    lista_id INT REFERENCES lista_reproducao(id),
    video_id INT REFERENCES video(id),
    PRIMARY KEY (lista_id, video_id)
);
```

---

## Como Executar

### Pré-requisitos

- Java JDK 11 ou superior
- PostgreSQL instalado e rodando
- Driver JDBC do PostgreSQL (postgresql-xx.jar) no classpath

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/ArielMMN/FeiTV.git
   ```

2. Crie o banco de dados no PostgreSQL:
   ```sql
   CREATE DATABASE feitv;
   ```

3. Execute os scripts SQL acima para criar as tabelas.

4. Configure a conexão em `src/dao/Conexao.java` se necessário (usuário/senha do PostgreSQL).

5. Abra o projeto no NetBeans e execute a classe `ExemploBD.java`.

---

## Segurança

- Senhas armazenadas com **hash SHA-256** (sem texto puro no banco).
- Todas as queries utilizam **PreparedStatement** para prevenção de SQL Injection.
- Conexões gerenciadas com **try-with-resources** para evitar vazamento de recursos.

---

## Estrutura de Pastas

```
FeiTV/
├── src/
│   ├── controller/   # Lógica de negócio (Controllers)
│   ├── dao/          # Acesso ao banco de dados (DAOs + Conexao)
│   ├── model/        # Classes de domínio (Model)
│   ├── view/         # Telas Swing (Views)
│   └── exemplobd/    # Classe main (ExemploBD.java)
├── build/
├── nbproject/
└── README.md
```

---

## Autor

**Ariel Moraes**  
Disciplina CCM310 — Centro Universitário FEI  
