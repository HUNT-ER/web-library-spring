# Web Library
This project allows to do basic CRUD operations on Books and People, assign and release book from person, role system for workers.
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

# Access to pages
| Page    |  ADMIN  | WORKER |
|:--------|:-------:|:------:|
| Login   |    +    |    +   |
| Logout  |    +    |    +   |
| Workers |    +    |    -   |
| Books   |    +    |    +   |
| Persons |    +    |    +   |

# API Reference 

## Log in
**GET** `/auth/login`
  returns login page

## Workers operations

**GET** `/admin/workers`
  returns page with workers

**GET** `/admin/workers/new`
  returns page with form to create new worker

**POST** `/admin/workers `
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

## People operations

**GET** `/people`
  returns page of people

**GET** `/people/new`
   returns page with form to create new person

**GET** `/people/{id}`
  returns person page by Id

**GET** `/people/{id}/edit`
  returns page for editing person by Id

**POST** `/people`
  saves new people

**PATCH** `/people/{id}`
  updates saved people by Id

**DELETE** `/people/{id}`
  deletes people by Id

# Entity diagram
![web-library](https://github.com/HUNT-ER/web-library-spring/assets/38404914/13e5c78a-762a-4dcd-846c-7c4266cc09de)

# What I learned
- Learned Spring MVC, Spring Boot, Spring Security, Thymeleaf
