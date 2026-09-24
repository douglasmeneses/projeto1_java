# ☕ Projeto 1 — API de Gestão de Usuários (Mentoria Java)

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-Database-003B57?style=for-the-badge)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

Projeto prático desenvolvido durante o **Módulo 1 da Mentoria Java**, focando nos pilares de Programação Orientada a Objetos (POO), arquitetura limpa em camadas com **Spring Boot 3** e **Java 21**, boas práticas de DTOs para exposição segura de dados e persistência relacional com **H2 Database**.

---

## 📌 Funcionalidades

- 👤 **CRUD Completo de Usuários:** Cadastro, busca por ID, listagem geral, atualização cadastral e exclusão.
- 🔒 **Proteção de Dados com DTOs:** Uso de `UsuarioDTO` para entrada e `UsuarioPublicoDTO` para respostas sem expor dados sensíveis.
- 📐 **Arquitetura em Camadas:** Desacoplamento entre Controladores (`controllers`), Serviços (`services`) e Repositórios (`repositories`).
- ⚡ **Banco de Dados em Memória:** Persistência configurada com H2 para execução instantânea sem necessidade de infraestrutura externa.

---

## 🏗️ Estrutura do Projeto

```text
src/main/java/org/example/projeto1/
├── controllers/          # Endpoints REST (UsuarioController)
├── models/
│   ├── dto/              # DTOs (UsuarioDTO, UsuarioPublicoDTO)
│   └── entities/         # Entidade JPA Usuario
├── repositories/         # Interface Spring Data JPA (UsuarioRepository)
├── services/             # Regras de negócio (UsuarioService)
└── Projeto1Application.java
```

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** [Java 21](https://www.oracle.com/java/)
- **Framework:** [Spring Boot 3.5.x](https://spring.io/projects/spring-boot)
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** H2 Database (em memória)
- **Produtividade:** Project Lombok
- **Build Tool:** Gradle

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- [JDK 21](https://adoptium.net/) instalado

### 1. Clonar o repositório
```bash
git clone https://github.com/douglasmeneses/projeto1_java.git
cd projeto1_java
```

### 2. Compilar e executar
No Linux/macOS:
```bash
./gradlew bootRun
```
No Windows:
```cmd
gradlew.bat bootRun
```

A API estará rodando em `http://localhost:8080`.

---

## 📡 Endpoints da API

| Método | Rota | Descrição | Resposta |
| :--- | :--- | :--- | :--- |
| `POST` | `/usuarios` | Cadastra um novo usuário | `201 Created` + `UsuarioPublicoDTO` |
| `GET` | `/usuarios` | Lista todos os usuários | `200 OK` + Lista de usuários |
| `GET` | `/usuarios/{id}` | Busca um usuário por ID | `200 OK` + `UsuarioPublicoDTO` |
| `PUT` | `/usuarios/{id}` | Atualiza dados cadastrais | `200 OK` + Usuário atualizado |
| `DELETE` | `/usuarios/{id}` | Remove um usuário | `204 No Content` |

---

## 👨‍💻 Autor

Desenvolvido por **Douglas Meneses** na Mentoria Java.

- 💼 GitHub: [@douglasmeneses](https://github.com/douglasmeneses)
- ✉️ Email: [meneses.doug@gmail.com](mailto:meneses.doug@gmail.com)
