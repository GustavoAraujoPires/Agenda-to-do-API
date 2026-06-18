<h1 align="center"> Agenda de Tarefas API</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java" alt="Java 21"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.15-brightgreen?style=for-the-badge&logo=springboot" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven"/>
</p>

<p align="center">
  API REST completa para gerenciamento de tarefas com autenticação, controle de acesso por perfis e interface de login personalizada via Thymeleaf.
</p>

---

##  Sobre o Projeto

**Agenda de Tarefas** é uma aplicação back-end desenvolvida com **Spring Boot** que oferece um sistema completo de gerenciamento de tarefas com autenticação de usuários, autorização por roles e uma tela de login personalizada. O projeto aplica boas práticas como uso de DTOs, mapeamento de objetos via MapStruct, validação de dados e tratamento global de exceções.

---

##  Funcionalidades

-  **CRUD completo** de tarefas (criar, listar, buscar por ID, atualizar, deletar)
-  **Gerenciamento de status** — fluxo `PENDENTE → CONCLUÍDA` com validação de estado
-  **Cadastro e autenticação** de usuários com senha criptografada via **BCrypt**
-  **Controle de acesso por roles** — `USUARIO` e `ADM` com `@PreAuthorize`
-  **Tela de login personalizada** integrada via **Thymeleaf**
-  **Tratamento global de exceções** com respostas padronizadas em JSON
-  **Mapeamento de DTOs** com **MapStruct** e integração com Lombok
-  **Armazenamento de roles em array nativo do PostgreSQL** com `hypersistence-utils`

---

## Estrutura do Projeto

```
src/
├── config/
│   ├── LoginConfiguration.java       # Configuração da página de login
│   └── SecurityConfiguration.java    # Filtros e regras de segurança
├── controller/
│   ├── DTO/
│   │   ├── TarefaDTO.java
│   │   └── UsuarioDTO.java
│   ├── mappers/
│   │   ├── TarefaMapper.java         # MapStruct
│   │   └── UsuarioMapper.java
│   ├── common/
│   │   └── GlobalExceptionHandler.java
│   ├── TarefaController.java
│   ├── UsuarioController.java
│   ├── HomeViewController.java
│   └── LoginViewController.java
├── exception/
│   ├── IdNaoEncontradoException.java
│   ├── StatusInvalidoException.java
│   └── UsuarioNaoEncontradoException.java
├── model/
│   ├── Tarefa.java
│   ├── Usuario.java
│   └── StatusTarefa.java             # Enum: PENDENTE | CONCLUIDA
├── repository/
│   ├── TarefaRepository.java
│   └── UsuarioRepository.java
├── security/
│   ├── CustomUserDetailsService.java
│   └── SecurityService.java
└── service/
    ├── TarefaService.java
    └── UsuarioService.java
```

---

## Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
|---|---|---|
| Java | 21 | Linguagem principal |
| Spring Boot | 3.5.15 | Framework base |
| Spring Web | 3.5.15 | API REST |
| Spring Data JPA / Hibernate | 3.15.3 | Persistência de dados |
| Spring Security | 3.5.15 | Autenticação e autorização |
| Spring Validation | 3.0.2 | Validação de campos dos DTOs |
| Thymeleaf | 3.5.15 | Template engine para login |
| PostgreSQL | 7.11 | Banco de dados relacional |
| Lombok | 1.18.38 | Redução de boilerplate |
| MapStruct | 1.5.5.Final | Mapeamento entre entidades e DTOs |
| Hypersistence Utils | 3.15.3 | Suporte a tipos nativos do PostgreSQL (array) |
| Maven | — | Gerenciamento de dependências |

---

## Endpoints da API

### Tarefas — `/tarefas`

| Método | Endpoint | Role | Descrição |
|---|---|---|---|
| `POST` | `/tarefas` | `USUARIO` | Cria uma nova tarefa |
| `GET` | `/tarefas` | `ADM` | Lista todas as tarefas |
| `GET` | `/tarefas/{id}` | `USUARIO` | Busca tarefa por ID |
| `PUT` | `/tarefas/{id}` | `USUARIO` | Atualiza uma tarefa |
| `PATCH` | `/tarefas/{id}` | `USUARIO` | Conclui uma tarefa |
| `DELETE` | `/tarefas/{id}` | `USUARIO` | Remove uma tarefa |

### Usuários — `/usuarios`

| Método | Endpoint | Acesso | Descrição |
|---|---|---|---|
| `POST` | `/usuarios` | Público | Cadastra um novo usuário |
| `GET` | `/usuarios/login` | Público | Busca usuário por login |
| `GET` | `/usuarios` | Público | Buscar todos usuários |
| `DELETE` | `/usuarios/id` | Público | Deleta usuário por Id |


### Views

| Rota | Descrição |
|---|---|
| `/login` | Tela de login personalizada |
| `/home` | Página inicial após autenticação |

---

## Exemplo de Requisição

**Criar tarefa** — `POST /tarefas`

```json
{
  "titulo": "Estudar Spring Security",
  "descricao": "Revisar filtros e configuração de roles",
  "dataInicio": "2025-06-18",
  "dataLimite": "2025-06-25"
}
```

**Resposta** — `201 Created`

```json
{
  "id": 1,
  "titulo": "Estudar Spring Security",
  "descricao": "Revisar filtros e configuração de roles",
  "dataInicio": "2025-06-18",
  "dataLimite": "2025-06-25",
  "statusTarefa": "PENDENTE"
}
```

---

## Como Rodar o Projeto

### Pré-requisitos

- Java 21+
- Maven 3.8+
- PostgreSQL em execução

### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/gustavoaraujopires/agenda-api.git
cd agenda-api
```

**2. Configure o banco de dados**

Crie um banco chamado `agendaDB` no PostgreSQL:
```sql
CREATE DATABASE agendaDB;
```

**3. Ajuste o `application.yaml`** (se necessário)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/agendaDB
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
```

**4. Execute a aplicação**
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## Autenticação

O sistema utiliza **Form Login** do Spring Security com página de login personalizada via Thymeleaf.

- Acesse `/login` para autenticar
- Após o login, você é redirecionado para `/home`
- Rotas da API exigem autenticação via **HTTP Basic** ou sessão ativa
- Senhas são criptografadas com **BCrypt (strength 10)**

**Roles disponíveis:**
- `USUARIO` — acesso às operações de tarefas individuais
- `ADM` — acesso total, incluindo listagem geral

---

## Arquitetura e Boas Práticas

- **Camadas bem definidas**: Controller → Service → Repository
- **DTOs com validação**: campos obrigatórios validados com `@NotBlank`, `@NotNull`
- **MapStruct**: mapeamento automático entre `TarefaDTO` ↔ `Tarefa` e `UsuarioDTO` ↔ `Usuario`
- **Lombok**: eliminação de getters, setters e construtores com `@Data` e `@RequiredArgsConstructor`
- **Tratamento de exceções**: `GlobalExceptionHandler` com `@RestControllerAdvice` retornando `ErroResposta` padronizado
- **Roles em array nativo do PostgreSQL**: usando `hypersistence-utils` com `ListArrayType`

---

## Autor

Feito por **Gustavo Araújo Pires**

[![GitHub](https://img.shields.io/badge/GitHub-gustavoaraujopires-181717?style=flat-square&logo=github)](https://github.com/gustavoaraujopires)

---

<p align="center">
  Desenvolvido com Java e Spring Boot.
</p>
