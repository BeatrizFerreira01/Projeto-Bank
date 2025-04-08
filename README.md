
# 📄 Projeto Bank

**Sistema de Gerenciamento de Contas Bancárias**  
Projeto desenvolvido para a disciplina de **Java Advanced**.

---

## 🚀 Tecnologias Usadas
- Java 17
- Spring Boot 3.4.4
- Maven
- API REST (com validações)
- Postman (para testar as requisições)

---

## 🛠️ Como Rodar o Projeto

### 1. Pré-requisitos
- Java JDK 17 ou superior instalado
- Maven instalado (ou usar Maven Wrapper `mvnw.cmd`)
- IDE (Visual Studio Code, IntelliJ, Eclipse)

### 2. Clonar o repositório
```bash
git clone https://github.com/BeatrizFerreira01/Projeto-Bank.git
```

### 3. Navegar até o projeto
```bash
cd projetoBank
```

### 4. Rodar o projeto
No terminal, execute:
```bash
./mvnw spring-boot:run
```
Ou, no Windows:
```bash
mvnw.cmd spring-boot:run
```
Ou ainda:
```bash
mvn spring-boot:run
```

---

## 🌐 Endpoints da API

| Método | URL | Função |
|:------:|:----|:------|
| `GET` | `/contas/` | Mensagem de boas-vindas |
| `POST` | `/contas` | Criar uma nova conta |
| `GET` | `/contas` | Listar todas as contas |
| `GET` | `/contas/{id}` | Buscar conta por ID |
| `GET` | `/contas/cpf/{cpf}` | Buscar conta por CPF |
| `POST` | `/contas/{id}/deposito?valor={valor}` | Realizar depósito |
| `POST` | `/contas/{id}/saque?valor={valor}` | Realizar saque |
| `POST` | `/contas/{origemId}/transferencias/{destinoId}?valor={valor}` | Realizar transferência PIX |
| `DELETE` | `/contas/{id}` | Encerrar (inativar) uma conta |

---

## 📋 Regras de Negócio
- Campos obrigatórios: número, agência, nome do titular, CPF, tipo, saldo inicial e data de abertura.
- Não é permitido:
  - Criar contas com campos obrigatórios vazios.
  - Criar conta com data de abertura no futuro.
  - Depositar ou sacar valores negativos ou zerados.
  - Realizar operações em contas inativas.
  - Transferir (Pix) entre contas inativas ou com saldo insuficiente.

---

## ✅ Testando a API

Você pode usar o **Postman** (extensão do VS Code).

### Exemplo de JSON para criar uma conta:
```json
{
  "numero": "53120",
  "agencia": "005",
  "nomeTitular": "Beatriz Ferreira",
  "cpfTitular": "12345678900",
  "dataAbertura": "2025-04-07",
  "saldo": 1500.00,
  "ativa": true,
  "tipo": "corrente"
}
```

---

## 📋 Exemplos de Requisições

### Criar Conta (POST)
**URL:** `http://localhost:8080/contas`  
**Body (JSON):**
```json
{
  "numero": "12345",
  "agencia": "001",
  "nomeTitular": "Alice Ferreira",
  "cpfTitular": "12345678910",
  "dataAbertura": "2024-04-06",
  "saldo": 1000.00,
  "ativa": true,
  "tipo": "corrente"
}
```

---

### Buscar Conta por ID (GET)
**URL:** `http://localhost:8080/contas/1`

---

### Buscar Conta por CPF (GET)
**URL:** `http://localhost:8080/contas/cpf/12345678900`

---

### Realizar Depósito (POST)
**URL:** `http://localhost:8080/contas/1/deposito?valor=500`

---

### Realizar Saque (POST)
**URL:** `http://localhost:8080/contas/1/saque?valor=200`

---

### Realizar Transferência PIX (POST)
**URL:** `http://localhost:8080/contas/1/transferencias/2?valor=100`

---

### Encerrar Conta (DELETE)
**URL:** `http://localhost:8080/contas/1`

---

## 👩‍💻 Autora
- **Beatriz Ferreira Cruz**

---

## 📝 Observações

Este projeto foi desenvolvido como parte da disciplina de **Java Advanced** no curso de graduação, focando nos conceitos de:
- Programação orientada a objetos (POO)
- Criação de APIs REST com Spring Boot
- Validação de dados usando Bean Validation
- Boas práticas de organização e arquitetura de código.

---
