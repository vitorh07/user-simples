# User Simples

Este é um projeto simples de gerenciamento de usuários utilizando Spring Boot, H2 Database e JPA.

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

A API fornece os seguintes endpoints para gerenciamento de usuários:

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
    - **GET** `/api/users/{id}`

- **Buscar Usuário por Username**
    - **GET** `/api/users/username/{username}`

- **Buscar Usuário por Email**
    - **GET** `/api/users/email/{email}`

- **Deletar Usuário**
    - **DELETE** `/api/users/{id}`

- **Buscar Todos os Usuários**
    - **GET** `/api/users`

## Banco de Dados H2

O projeto utiliza o banco de dados H2 em memória. Para acessar o console do H2, utilize a seguinte URL:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(deixe em branco)*

## Estrutura do Projeto

- **`src/main/java/com/prjvitor/entities`**: Contém a entidade `User`.
- **`src/main/java/com/prjvitor/repositories`**: Contém o repositório `UserRepository`.
- **`src/main/java/com/prjvitor/services`**: Contém o serviço `UserService`.
- **`src/main/java/com/prjvitor/controllers`**: Contém o controlador `UserController`.
- **`src/main/resources`**: Contém os arquivos de configuração `application.properties`, `schema.sql` e `data.sql`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.