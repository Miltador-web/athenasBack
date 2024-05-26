# Sistema de Gerenciamento de Pessoas (API REST com Spring Boot)

Este projeto Spring Boot implementa uma API REST completa para gerenciar informações de pessoas, incluindo funcionalidades de listagem, adição, atualização, remoção e cálculo de peso ideal. Ele utiliza o padrão de projeto DTO (Data Transfer Object) para transferência de dados entre as camadas da aplicação.

## Funcionalidades

- **Listar todas as pessoas (`GET /system/listar-pessoas`):** Retorna uma lista completa de todas as pessoas cadastradas no sistema.
- **Listar pessoa por ID (`GET /system/listar-pessoa/{id}`):** Retorna os detalhes de uma pessoa específica com base no ID fornecido.
- **Adicionar pessoa (`POST /system/adicionar-pessoa`):** Permite adicionar uma nova pessoa ao sistema, recebendo os dados via requisição POST.
- **Atualizar pessoa (`PATCH /system/atualizar-pessoa/{id}`):** Permite atualizar os dados de uma pessoa existente, recebendo o ID da pessoa e os dados atualizados via requisição PATCH.
- **Remover pessoa (`DELETE /system/remover-pessoa/{id}`):** Remove uma pessoa do sistema com base no ID fornecido.
- **Calcular peso ideal (`GET /system/peso-ideal/{id}`):** Retorna o peso ideal de uma pessoa com base em seus dados (altura, sexo, etc.).

## Tecnologias Utilizadas

- **Spring Boot:** Framework para desenvolvimento de aplicações Java.
- **Spring Web:** Módulo do Spring para criação de APIs REST.
- **Spring Data JPA:** Simplifica o acesso a dados em bancos de dados relacionais.
- **Banco de Dados:** Especifique o banco de dados utilizado (ex: MySQL, PostgreSQL).

## Estrutura do Projeto

- **com.athenas.system.controller (PessoaController):** Contém os endpoints da API REST.
- **com.athenas.system.DTO (PessoaDTO):** Define a estrutura de dados para transferência de informações de pessoas.
- **com.athenas.system.service (PessoaService):** Implementa a lógica de negócio relacionada às operações com pessoas, incluindo o cálculo de peso ideal.
- **com.athenas.system.model (Pessoa):** Representa a entidade Pessoa no banco de dados.
- **com.athenas.system.repository (PessoaRepository):** Interface para acesso aos dados da entidade Pessoa no banco de dados.

## Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Maven
- Banco de dados instalado e configurado
- IDE de sua preferência (ex: IntelliJ, Eclipse, VSCode)

## Como Executar

1. **Clone o projeto:**
   ```bash
   git clone <URL_DO_SEU_REPOSITÓRIO>
   ```

2. **Verifique as configurações:**
    - Certifique-se de que as configurações de conexão com o banco de dados no arquivo `application.properties` (ou `application.yml`) estão corretas.

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run 
   ```

4. **Utilize a API:**
    - Acesse os endpoints da API através de ferramentas como Postman ou curl. Consulte os exemplos de requisições abaixo.

## Exemplos de Requisições

### GET /system/listar-pessoas

```bash
curl -X GET http://localhost:8080/system/listar-pessoas
```

### GET /system/listar-pessoa/{id}

```bash
curl -X GET http://localhost:8080/system/listar-pessoa/1
```

### POST /system/adicionar-pessoa

```bash
curl -X POST -H "Content-Type: application/json" -d '{"nome": "João Silva", "email": "joao@email.com"}' http://localhost:8080/system/adicionar-pessoa
```

### PATCH /system/atualizar-pessoa/{id}

```bash
curl -X PATCH -H "Content-Type: application/json" -d '{"nome": "João da Silva", "email": "joao@email.com"}' http://localhost:8080/system/atualizar-pessoa/1
```

### DELETE /system/remover-pessoa/{id}

```bash
curl -X DELETE http://localhost:8080/system/remover-pessoa/1
```

### GET /system/peso-ideal/{id}

```bash
curl -X GET http://localhost:8080/system/peso-ideal/1
```

## Observação

- Adapte as URLs e os dados de exemplo de acordo com a sua configuração.
- As requisições PATCH e DELETE não retornam corpo na resposta.