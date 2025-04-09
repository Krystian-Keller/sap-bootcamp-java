# 💻 ASE Prerequisite Test for Java

Este repositório contém minha solução para o *Prerequisite Test* do bootcamp **Agile Software Engineering (ASE)** da SAP, com foco em Java. O objetivo do exercício é verificar se o candidato possui os conhecimentos mínimos em Java para acompanhar o conteúdo do treinamento.

---

## 🎯 Objetivo

O teste consiste em implementar duas classes principais — `Developer` e `Hackathon` — utilizando princípios de Programação Orientada a Objetos (POO), herança, exceções personalizadas e tratamento de listas. Além disso, o teste avalia o domínio do ambiente Java com uso de Maven, Git e IDEs como IntelliJ, VSCode ou STS.

---

## 🧰 Requisitos Técnicos

- Java JDK 17 ou 21  
- Maven  
- Git  
- IDE de sua preferência (ex: IntelliJ, Visual Studio Code, Spring Tool Suite)  

---

## 🧠 Lógica Implementada

### `Developer` (subclasse de `CodeCreator`)
- Contém os atributos privados `name` e `language`.
- Implementa a lógica do método `code()`.
- Lança exceções personalizadas (`UnsupportedDevelopmentLanguageException`) para linguagens não suportadas.

### `Hackathon` (implementa `DeveloperEvent`)
- Implementa o método `codeTogether(List<CodeCreator>)`.
- Concatena o resultado do método `code()` de todos os participantes.
- Trata exceções lançadas individualmente por cada `Developer`.

---

## 🚀 Como rodar localmente

1. Clone este repositório:
```bash
git clone https://github.com/seu-usuario/ase-pretest-java.git
cd ase-pretest-java
```

2. Execute os testes:
```bash
mvn clean verify
```

---

## 📬 Observações

- Projeto baseado no repositório original do ASE Bootcamp da SAP.
- O uso de ferramentas como GitHub Copilot foi evitado para garantir domínio real do conteúdo.
- Este projeto representa meu comprometimento em me aprofundar na stack Java e seguir na jornada para me tornar um developer dentro da SAP.

---

## 🧠 Sobre o Bootcamp

O Agile Software Engineering Bootcamp é uma iniciativa da SAP voltada para desenvolvedores interessados em aprofundar habilidades modernas de desenvolvimento, incluindo TDD, Clean Code e práticas ágeis.

---

## 📌 Licença

Este projeto é baseado em um exercício interno da SAP. Uso pessoal e educacional.
