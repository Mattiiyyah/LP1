# 🏥 Sistema de Atendimento Clínico

Projeto acadêmico da disciplina de Linguagem de Programação I (LP1) da FATEC. O sistema consiste em uma aplicação de gestão clínica que registra e gerencia atendimentos, pacientes, médicos, funcionários, exames e procedimentos.

## 🚀 Tecnologias Utilizadas

O projeto foi dividido em duas camadas principais:

### ☕ Back-End (Java)
- **Java Orientado a Objetos**: Utilizado para criar toda a regra de negócio e estrutura de dados (Entidades).
- **Sem Frameworks Web**: Toda a lógica foi construída utilizando Java puro, sem a necessidade de frameworks como Spring Boot.
- **Exportação de Dados**: Utilização da biblioteca **Gson** (`gson-2.11.0.jar`) para serializar as instâncias dos objetos Java em um arquivo `dados.json`, permitindo a comunicação com o Front-End.

### 🌐 Front-End (HTML/CSS/JS)
- **HTML5**: Estruturação semântica do painel (Dashboard).
- **CSS3 Vanilla**: Estilização moderna com tema escuro (Dark Mode), efeito de *Glassmorphism*, gradientes, micro-animações e layout totalmente responsivo.
- **JavaScript (Vanilla JS)**: Consumo do arquivo `dados.json` via Fetch API e renderização dinâmica dos componentes na tela.
- **Integração Assíncrona**: O Front-End lê os dados gerados pelo Java e constrói a interface de forma automática.

## 📂 Estrutura do Projeto

```text
Atendimento_Clinico/
├── bin/                   # Arquivos .class compilados
├── lib/                   # Bibliotecas externas (Gson)
│   └── gson-2.11.0.jar
├── src/                   # Código fonte Java
│   ├── App.java           # Classe principal (gera os dados e exporta o JSON)
│   └── entities/          # Classes de entidade (Paciente, Médico, Exame, etc.)
└── web/                   # Código fonte do Front-End
    ├── app.js             # Lógica de renderização da interface
    ├── dados.json         # Arquivo gerado pelo Java contendo os dados
    ├── index.html         # Estrutura do Dashboard
    └── style.css          # Estilos e design
```

## ⚙️ Como Executar

Para rodar o projeto localmente, siga os passos abaixo:

### 1. Gerar os Dados (Back-End)
Primeiro, é necessário compilar e rodar a aplicação Java para que ela gere o arquivo `dados.json`.
Abra o terminal na raiz do projeto (`Atendimento_Clinico`) e execute:

```powershell
# Compilar o código
javac -cp "lib/gson-2.11.0.jar" -d bin src/entities/*.java src/App.java

# Executar a aplicação
java -cp "bin;lib/gson-2.11.0.jar" App
```
*Se tudo der certo, você verá uma mensagem informando que o `web/dados.json` foi gerado com sucesso.*

### 2. Iniciar o Painel (Front-End)
Como a aplicação utiliza o `fetch()` no JavaScript, é necessário servir os arquivos HTML através de um servidor HTTP local.
No mesmo terminal, inicie um servidor apontando para a pasta `web/`:

```powershell
# Iniciar o servidor com npx
npx -y http-server web -p 8080
```

### 3. Acessar
Abra o seu navegador e acesse:
👉 **http://127.0.0.1:8080**

## 💡 Funcionalidades
- **Painel Administrativo**: Visualização dos dados do administrador do sistema.
- **Resumo Geral**: Cards com métricas de total de atendimentos, consultas, procedimentos e exames.
- **Atendimentos Detalhados**: Cards expansíveis (Acordeões) mostrando:
  - Dados do Paciente e do Funcionário responsável.
  - Médicos envolvidos (com status da consulta e CRM).
  - Procedimentos realizados e seus resultados.
  - Exames solicitados com respectivos laudos.

---
*Desenvolvido em colaboração com Antigravity/Claude AI.*
