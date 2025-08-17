# 🍕 API Pizzería

API REST desarrollada con **Spring Boot** para la gestión de una pizzería.  
Esta aplicación permite manejar **pizzas, pedidos y clientes**, además de autenticación básica.

## 📌 Objetivo
Ofrecer un servicio centralizado para la gestión de una pizzería, permitiendo **crear, listar, actualizar y eliminar pizzas**, gestionar pedidos y consultar información de clientes.

## 🧑🏽‍💻 Entidades
La aplicación maneja las siguientes entidades principales:

- **Pizza:** Representa una pizza con atributos como nombre, descripción, precio y disponibilidad.  
- **Order (Pedido):** Representa un pedido realizado por un cliente, con detalles de fecha, resumen y estado.  
- **Customer (Cliente):** Representa un cliente de la pizzería con atributos como teléfono e identificador.  
- **Auth:** Maneja la autenticación de usuarios (login).  

## 🚀 Funcionalidades

### Pizza Controller
- `GET /api/pizzas` → Lista todas las pizzas  
- `GET /api/pizzas/{id}` → Obtiene una pizza por su id  
- `GET /api/pizzas/cheapest/{price}` → Lista pizzas más baratas que un precio dado  
- `GET /api/pizzas/by-not-description/{description}` → Lista pizzas que **no contienen** cierta descripción  
- `GET /api/pizzas/by-name/{name}` → Busca pizzas por nombre  
- `GET /api/pizzas/by-description/{description}` → Lista pizzas por descripción  
- `GET /api/pizzas/available` → Lista pizzas disponibles  
- `POST /api/pizzas/add` → Agrega una nueva pizza  
- `PUT /api/pizzas/update` → Actualiza los datos de una pizza  
- `PUT /api/pizzas/update-price` → Actualiza solo el precio de una pizza  
- `DELETE /api/pizzas/delete/{id}` → Elimina una pizza por id  

---

### Order Controller
- `GET /api/orders` → Lista todos los pedidos  
- `GET /api/orders/today` → Lista los pedidos del día actual  
- `GET /api/orders/summary/{id}` → Obtiene el resumen de un pedido por id  
- `GET /api/orders/outside` → Lista pedidos para entrega fuera del local  
- `GET /api/orders/customer/{idCustomer}` → Lista los pedidos de un cliente específico  

---

### Customer Controller
- `GET /api/customers/phone/{phone}` → Busca un cliente por teléfono  
- `GET /api/customers/customer/{idCustomer}` → Obtiene la información de un cliente por id  

---

### Auth Controller
- `POST /api/auth/login` → Autenticación de usuarios  

---

## ⚙️ Tecnologías utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Gradle  
- Docker  
- Swagger (documentación de la API)  

---

## 📂 Estructura del proyecto

```bash
src/main/java/com/pizzeria/
├── domain/        # Lógica de dominio (modelos, DTOs, excepciones, repositorios y servicios)
│   ├── dto/       # Clases DTO
│   ├── exception/ # Excepciones personalizadas
│   ├── repository/# Interfaces del dominio
│   └── service/   # Servicios de dominio
├── persistence/   # Capa de persistencia
│   ├── crud/      # Interfaces CRUD (JPA)
│   ├── entity/    # Entidades JPA
│   └── mapper/    # Mappers MapStruct
├── web/           # Capa web
│   ├── config/    # Configuraciones (Swagger, seguridad, etc.)
│   ├── controller/# Controladores REST
│   └── exception/ # Manejo global de errores
```

---

## Base de datos
- PostgreSQL  

