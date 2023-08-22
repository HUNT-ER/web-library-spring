# Web Library API
This API allows to do basic CRUD operations on Book, assign and release book from person, role system for workers.
UI based on HTML and Thymeleaf. 

# Build with
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- Spring Security
- Hibernate
- PostgreSQL
- Lombok
- HTML
- Thymeleaf

## Set up 
- [*clone*](https://github.com/HUNT-ER/web-library-spring.git) the project
- change [application.properties](src/main/resources/application.properties.origin) file based on your database configurations
- run the project using [WebLibrarySbApplication.java](src/main/java/ru/boldyrev/weblibrarysb/WebLibrarySbApplication.java)

# API Reference 

## Workers operations

**GET** `/workers`
  returns page with workers

**GET** `/workers/new`
  returns page with form to create new worker

**POST** `/workers `
  create new worker

## Books operations

**GET** `/books?page&size&sort_by`
  returns sorted page of books, default by title

**GET** `/books/new`
   returns page with form to create new book

**GET** `/books/{id}`
  returns book page by Id

**GET** `/books/{id}/edit`
  returns page for editing book by Id

**GET** `/books/search?title`
  returns page of books searched by title

**POST** `/books`
  saves new book

**PATCH** `/books/{id}`
  updates saved book by Id

**DELETE** `/books/{id}`
  deletes book by Id

**POST** `/books/{id}/assign`
  assigns book to person by Id

**POST** `/books/{id}/release`
  release book from person by Id


# Entity diagram
![Модель данных](https://github.com/HUNT-ER/library-model/assets/38404914/27d33c26-fe64-4101-a35b-27dc07e67ab1)

# What I learned
- Improved skills in Spring Boot, unit testing, Docker, Entity relationships, API Architecture
