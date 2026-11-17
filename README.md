# BarberShop — PostgreSQL + Hibernate

Sistema de barbearia (Swing) com persistência real em PostgreSQL via Hibernate.

## Requisitos

- JDK 11+ (recomendado 17)
- Maven 3.9+
- PostgreSQL rodando em `localhost:5432`
- Banco `barbershop`, usuário/senha `postgres` / `postgres`  
  (ajuste em `src/main/resources/hibernate.cfg.xml` se necessário)

## Criar o banco (pgAdmin ou psql)

```sql
CREATE DATABASE barbershop;
```

## Rodar

```bash
mvn compile
mvn exec:java -Dexec.mainClass=View.Login
```

Teste rápido sem interface:

```bash
mvn exec:java -Dexec.mainClass=Application.TestePersistencia
```

## Login de teste

| Usuário           | Senha       |
|-------------------|-------------|
| barbeiro          | barbeiro    |
| estagiario        | estagiario  |
| jefferson         | 12345       |
| rafaelprofessor   | 12345       |

Na primeira execução, `Banco.inicia()` popula usuários, clientes, serviços e agendamentos iniciais.

## O que foi implementado

- `hibernate.cfg.xml` com dialeto PostgreSQL e `hbm2ddl.auto=update`
- Entidades JPA: `Cliente`, `Usuario`, `Servico`, `Agendamento` (`Pessoa` com `@MappedSuperclass`)
- `HibernateUtil` + `GenericDAO` (insert/update/delete/selectAll com `Session`)
- DAOs específicos usando Hibernate (sem ArrayList em memória)
- Fluxo de login e agendamento persistindo no PostgreSQL
