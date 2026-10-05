# 🚀 Enterprise Integration Architecture Platform (WSO2 APIM + EI + Spring Boot)

[![Docker](https://img.shields.io/badge/Docker-Containers-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![WSO2 APIM](https://img.shields.io/badge/WSO2-API%20Manager-FF7300?style=for-the-badge&logo=wso2&logoColor=white)](https://wso2.com/api-management/)
[![WSO2 EI](https://img.shields.io/badge/WSO2-Enterprise%20Integrator-FF7300?style=for-the-badge&logo=wso2&logoColor=white)](https://wso2.com/integration/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![OpenLDAP](https://img.shields.io/badge/Security-OpenLDAP-003545?style=for-the-badge&logo=openldap&logoColor=white)](https://www.openldap.org/)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)

---

## 📌 Visão Geral do Projeto

Este repositório contém uma **plataforma completa de integração de dados e governança de APIs de nível corporativo**, totalmente orquestrada via **Docker**. O ecossistema combina as capacidades de Borda (*Edge/API Gateway*) do **WSO2 API Manager**, com o barramento de integração (*ESB*) do **WSO2 Enterprise Integrator**, uma camada de controle de acesso multi-tenant orientada por **OpenLDAP**, e microsserviços em **Spring Boot** com suporte a cache distribuído e persistência relacional com **PostgreSQL**.

A arquitetura foi projetada para resolver problemas complexos do ecossistema corporativo:
- **Governança e Rate Limiting** centralizados no Gateway.
- **Transformação de Carga Protocolar** (XML legada para JSON RESTful moderno).
- **Gestão de Identidade e Multi-Tenancy** granular.
- **Roteamento Inteligente e Caching** para alta vazão e resiliência.

---

## 📐 Arquitetura do Sistema


<img src="https://github.com/kyosho-dev/outros/blob/main/Arquitetura%20Corporativa%20de%20Integra%C3%A7%C3%A3o%20e%20Governan%C3%A7a%20de%20APIs.png" alt="Antes" width="100%" style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);"/>





---

## 🛠️ Stack Tecnológica

* **API Gateway & Governance:** WSO2 API Manager 4.x
* **Enterprise Service Bus (ESB):** WSO2 Enterprise Integrator 6.x / 7.x
* **Identity Provider (IdP):** OpenLDAP (RBAC + Dynamic Multi-tenancy)
* **Backend Services:** Java 17 / 21, Spring Boot 3.x, Spring Data JPA, Spring Cache
* **Database & Storage:** PostgreSQL
* **Containerization:** Docker & Docker Compose

---

## ⚙️ Componentes e Fluxo de Execução

### 1. Borda e Segurança (WSO2 APIM + OpenLDAP)
O **WSO2 APIM** atua como ponto único de entrada (Single Point of Entry). As requisições são submetidas a políticas de autenticação **OAuth2 (JWT/Opaque Tokens)**. O **OpenLDAP** fornece o suporte a diretório corporativo com suporte a **Multi-tenancy**, isolando os papéis e garantindo controle de acesso por domínio/departamento (`rh.com`).

### 2. Barramento e Transformação (WSO2 EI)
O **WSO2 Enterprise Integrator** lida com a mediação complexa de payloads:
- Recebe estruturas legadas em **XML** e realiza a conversão dinâmica para **JSON RESTful**.
- Executa avaliação de expressão **XPath/JavaScript** dentro do barramento para roteamento condicional de mensagens.
- Garante o desacoplamento entre os clientes externos e os contratos de APIs legados.

### 3. Microsserviços Domain-Driven (Spring Boot)
A camada de aplicação é composta por microsserviços autônomos e focados em responsabilidade única:
- **`bilhetador-api`**: Processamento e emissão de bilhetes em alta performance.
- **`rh-consulta-api`**: Consulta de dados cadastrais e colaboradores.
- **`relatorio-legacy-api`**: Emissão de dados em formato XML legados integrados via ESB.
- **`exemplo-cache-data`**: Serviço otimizado com cache em memória para endpoints de altíssima leitura.

---

## 🚦 Endpoints e Portais de Acesso

### Portais Administrativos (WSO2 Platform)

| Serviço | Portal | URL de Acesso |
| :--- | :--- | :--- |
| **WSO2 APIM** | Carbon Admin | `https://localhost:9443/carbon` |
| **WSO2 APIM** | Publisher Portal | `https://localhost:9443/publisher` |
| **WSO2 APIM** | Developer Portal | `https://localhost:9443/devportal` |
| **WSO2 EI** | Management Console | `https://192.168.1.235:9445/carbon/admin/login.jsp` |

### Endpoints da Aplicação Spring Boot

```bash
# Processamento de Bilhetes
POST http://localhost:8081/v1/bilhetes/processar

# Consulta de Funcionários (RH)
GET http://localhost:8082/v2/funcionarios/1

# Relatórios Legados da Frota (XML Integrado ao WSO2 EI)
GET http://localhost:8083/v3/relatorios/frota/xml

# Endpoints com Cache Otimizado
GET http://localhost:8084/v1/time/cached
```

---

## 🔐 Credenciais de Teste e Homologação

> ⚠️ *Credenciais pré-configuradas para ambiente local de desenvolvimento/sandbox.*

### Usuários de Teste (LDAP / Tenant RH)
* **Usuário 1:** `Dbld/marcos.silva@rh.com`
* **Usuário 2:** `Dbld/carlos.gabriel@rh.com`
* **Senha Padrão:** `Password123!`

### Administrador do Tenant
* **Usuário Admin:** `admin@rh.com`
* **Senha Admin:** `admin`

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* **Docker Desktop** (com Docker Compose habilitado)
* **Git**
* Mínimo de **8GB de RAM** alocados para o Docker Engine.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/kyosho-dev/ProjetoWSO2.git
   cd ProjetoWSO2
   ```

2. **Suba todo o ecossistema multi-container:**
   ```bash
   docker-compose up -d --build
   ```

3. **Verifique o status dos containers:**
   ```bash
   docker ps
   ```

   

4. Execulte o api-manager.bat em `wso2am-4.6.0\bin`


5. **Acesse o Developer Portal** em `https://localhost:9443/devportal` para subscrever às APIs publicadas e gerar os tokens OAuth2 de teste.

   
---

## 📝 Projeto Relacionado
* [Repositório de Design de Layouts & Mapeamentos EI](https://github.com/kyosho-dev/Desingn-de-Layouts)


---

