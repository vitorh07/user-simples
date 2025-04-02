# User Simples

Este é um projeto simples de gerenciamento de usuários utilizando Spring Boot, H2 Database, JPA, Spring Security e JWT para autenticação.

![API Funcionando](/src/main/resources/static/assets/api.gif)

## Requisitos

- Java 17
- Maven

## Configuração do Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/user-simples.git
    cd user-simples
    ```

2. Compile e execute o projeto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Endpoints da API

A API fornece os seguintes endpoints para gerenciamento de usuários e autenticação:

### **Gerenciamento de Usuários**

- **Criar Usuário**
    - **POST** `/api/users/register`
    - Corpo da Requisição:
        ```json
        {
            "username": "vitor",
            "password": "teste123",
            "email": "vitor@email.com"
        }
        ```

- **Buscar Usuário por ID**
    - **GET** `/api/users/id/{id}`

- **Buscar Usuário por Username**
    - **GET** `/api/users/username/{username}`

- **Buscar Usuário por Email**
    - **GET** `/api/users/email/{email}`

- **Deletar Usuário**
    - **DELETE** `/api/users/id/{id}`

- **Buscar Todos os Usuários**
    - **GET** `/api/users`

### **Autenticação e Autorização**

- **Login**
    - **POST** `/api/users/login`
    - Corpo da Requisição:
        ```json
        {
            "identifier": "vitor",
            "password": "teste123"
        }
        ```
    - Resposta:
        ```json
        {
            "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
            "username": "vitor",
            "email": "vitor@email.com"
        }
        ```

- **Verificar Token e Obter Informações do Usuário**
    - **GET** `/api/users/me`
    - Cabeçalho da Requisição:
        ```
        Authorization: Bearer <seu_token_jwt>
        ```
    - Resposta:
        ```json
        {
            "id": 1,
            "username": "vitor",
            "email": "vitor@email.com"
        }
        ```

## Banco de Dados H2

O projeto utiliza o banco de dados H2 em memória. Para acessar o console do H2, utilize a seguinte URL:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(deixe em branco)*

## Autenticação com JWT

O projeto utiliza **JWT (JSON Web Token)** para autenticação. Após o login, o back-end retorna um token JWT que deve ser enviado no cabeçalho `Authorization` em todas as requisições protegidas.

### **Como Funciona o JWT no Projeto**
1. O usuário faz login no endpoint `/api/users/login`.
2. O back-end valida as credenciais e retorna um token JWT.
3. O front-end armazena o token (por exemplo, no `localStorage`).
4. O token é enviado no cabeçalho `Authorization` para acessar endpoints protegidos, como `/api/users/me`.

### **Validade do Token**
- O token JWT tem uma validade de **24 horas** (configurada no `JwtUtil`).

## Estrutura do Projeto

- **`src/main/java/com/prjvitor/user_simples/entities`**: Contém a entidade `User`.
- **`src/main/java/com/prjvitor/user_simples/repositories`**: Contém o repositório `UserRepository`.
- **`src/main/java/com/prjvitor/user_simples/services`**: Contém o serviço `UserService`.
- **`src/main/java/com/prjvitor/user_simples/controllers`**: Contém o controlador `UserController`.
- **`src/main/java/com/prjvitor/user_simples/security`**: Contém as classes relacionadas ao Spring Security e JWT (`JwtUtil`, `JwtAuthFilter`, `CustomUserDetailsService`).
- **`src/main/java/com/prjvitor/user_simples/DTO`**: Contém a classe `LoginRequest`.
- **`src/main/resources`**: Contém os arquivos de configuração `application.properties`.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.