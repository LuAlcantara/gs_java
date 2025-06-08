# 🌪️ Abrigo+ – Sistema de Gestão de Abrigos em Eventos Extremos

Aplicação web desenvolvida com **Spring Boot + Thymeleaf**, voltada à gestão de abrigos temporários em situações de desastres naturais. O projeto faz parte da iniciativa **Global Solution FIAP 2025**, e propõe uma solução prática e inovadora para mitigar os impactos de eventos extremos, como enchentes, queimadas e ondas de calor.

---

## 📌 Objetivos do Projeto

- Auxiliar órgãos públicos e voluntários no gerenciamento de abrigos.
- Oferecer informações em tempo real sobre ocupação, temperatura, recursos disponíveis e contatos.
- Melhorar a transparência e otimizar o processo de check-in em abrigos.
- Integrar tecnologias de IA, mensageria e banco de dados relacional/não relacional.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Thymeleaf**
- **Spring Security com OAuth 2.0**
- **RabbitMQ (mensageria)**
- **Spring AI com OpenAI**
- **JPA / Hibernate**
- **H2 Database (desenvolvimento)**
- **Oracle e MongoDB (produção)**
- **Bootstrap 5**
- **i18n (internacionalização)**

---

## 🚀 Funcionalidades

- 🏠 Cadastro e listagem de abrigos
- ✅ Check-in de pessoas abrigadas
- 🌡️ Monitoramento de temperatura e recursos
- 🔒 Login com OAuth (Google)
- 🧠 Sugestões com IA
- 📦 Envio e consumo de mensagens com RabbitMQ
- 🌍 Internacionalização (pt / en)
- 🧪 Testes unitários e de integração

---

## ☁️ Aplicação na Nuvem (Azure)

A aplicação está hospedada e funcional em ambiente **Azure App Service**, com banco de dados conectado e testes realizados na nuvem.

🔗 **Link da aplicação**: [https://abrigo-95111.azurewebsites.net](https://abrigo-95111.azurewebsites.net)

---

## 📂 Como Executar o Projeto Localmente

#### ✅ Pré-requisitos
- Java 17 instalado (verifique com `java -version`)
- Maven instalado (verifique com `mvn -v`)
- RabbitMQ rodando localmente (porta 5672)
- IntelliJ IDEA (Ultimate recomendado)

#### 📦 Passos para executar

1. **Clone o repositório:**

Abra o terminal (CMD, PowerShell ou Git Bash) e execute:

```bash
git clone https://github.com/LuAlcantara/gs_java.git
```

2. **Abra o projeto no IntelliJ:**
- Vá em **File > Open**, selecione a pasta `gs_java` e clique em **OK**.
- Aguarde o IntelliJ importar o projeto Maven e baixar as dependências.

3. **Verifique configurações no arquivo `application.properties`:**
- Confirme as credenciais do banco de dados, chaves da OpenAI e conexão com RabbitMQ.

4. **Inicie o RabbitMQ:**
- Se tiver o Docker instalado, use:
```bash
docker run -d --hostname rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
- Ou inicie o serviço manualmente, se tiver o RabbitMQ instalado nativamente.

5. **Execute o projeto:**
- No IntelliJ, abra a classe `AbrigoApplication.java`.
- Clique com o botão direito na classe e selecione **Run 'AbrigoApplication'**.
- O Spring Boot iniciará e mostrará as portas usadas no console.

6. **Acesse no navegador:**
```bash
http://localhost:8080
```

A aplicação estará disponível com autenticação via Google (OAuth 2.0).

---

### 📎 Links Importantes

- 🔗 Repositório GitHub: [https://github.com/LuAlcantara/gs_java](https://github.com/LuAlcantara/gs_java)
- ☁️ Deploy na Azure: https://abrigo-95111.azurewebsites.net
- 🎥 Vídeo Demonstração: [https://youtu.be/qGMeEi7hpcM](https://youtu.be/qGMeEi7hpcM)
- 🎬 Pitch do Projeto: [https://youtu.be/E4sKPdxuuQY](https://youtu.be/E4sKPdxuuQY)

---

### 🧪 Testes

- Testes implementados com JUnit.
- Testes unitários para serviços e testes de integração para controllers.

---

### 👥 Integrantes

| Nome            | RM     | Turma |
|-----------------|--------|--------|
| Glenda Delfy    | 552667 | 2TDSPC |
| Lucas Alcântara | 95111  | 2TDSPC |
| Renan Bezerra   | 553228 | 2TDSPS |

