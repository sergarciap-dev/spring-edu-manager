# SpringEduManager - Plataforma de Gestión Académica

Proyecto integrador para el módulo **Desarrollo de Aplicaciones JEE con Spring Framework**. Implementa un sistema de gestión educativa interna desarrollado con arquitectura en capas, control de acceso basado en roles (RBAC), persistencia relacional en memoria e interoperabilidad mediante servicios web RESTful.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17 / 26
* **Framework:** Spring Boot 3.3.4
  * Spring Boot Starter Data JPA
  * Spring Boot Starter Web (Spring MVC)
  * Spring Boot Starter Security
  * Spring Boot Starter Validation
  * Spring Boot Starter Thymeleaf
  * Thymeleaf Extras Spring Security 6
* **Base de Datos:** H2 Database Engine (In-Memory)
* **Gestor de Dependencias:** Apache Maven 3.9.16
* **Frontend:** Thymeleaf, HTML5, CSS3 / Bootstrap 5

---

## 📋 Requisitos Previos

* Java Development Kit (JDK 17 o superior) instalado y configurado.
* Apache Maven 3.9+ agregado a las variables de entorno (`PATH`).
* Git.

---

## 🔑 Credenciales del Proyecto

### 1. Base de Datos H2 Console
* **URL:** http://localhost:8080/h2-console
* **Driver Class:** `org.h2.Driver`
* **JDBC URL:** `jdbc:h2:mem:edumanagerdb`
* **Usuario:** `sa`
* **Contraseña:** *(dejar vacío, sin contraseña)*

### 2. Usuarios Web (Spring Security)
* **Administrador:**
  * **Usuario:** `admin`
  * **Contraseña:** `admin123`
  * **Rol:** `ROLE_ADMIN`
  * **Permisos:** Acceso total (crear cursos, eliminar estudiantes, endpoints REST y consola H2).
* **Usuario Estándar:**
  * **Usuario:** `user`
  * **Contraseña:** `user123`
  * **Rol:** `ROLE_USER`
  * **Permisos:** Consultar cursos/estudiantes y registrar nuevos estudiantes.

---

## 🚀 Instrucciones de Ejecución

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/sergarciap-dev/spring-edu-manager.git](https://github.com/sergarciap-dev/spring-edu-manager.git)
   cd spring-edu-manager
