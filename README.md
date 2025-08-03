Proyecto Tienda de Electrodomésticos

Descripción
Este proyecto es una aplicación de tienda de electrodomésticos desarrollada usando arquitectura de microservicios. Aplica diversos patrones de diseño para garantizar escalabilidad, mantenimiento y robustez.
Cada microservicio está desacoplado y se comunica a través de Eureka Server, configurado con Spring Cloud Config para una gestión centralizada de configuración.

Tecnologías utilizadas
Java 17
Spring Boot (Microservicios)
Spring Cloud Eureka (Service Discovery)
Spring Cloud Config Server (Configuración centralizada)
MySQL 8.0 (Bases de datos)
Docker y Docker Compose (Contenerización)
Maven (Gestión de dependencias y build)
Hibernate/JPA (Persistencia)

Patrones de diseño como Circuit Breaker, API Gateway, Service Discovery, Load Balancing, Config Server.

Microservicios
eureka-server: Servicio de descubrimiento de servicios.
config-server: Servidor centralizado de configuración.
products-service: Microservicio encargado de productos.
sales-service: Microservicio encargado de ventas.
trolleys-service: Microservicio encargado de carritos de compra.
api-gateway: Punto de entrada único para todas las solicitudes hacia los microservicios.

Arquitectura y patrones de diseño
Arquitectura basada en microservicios desacoplados.

Registro y descubrimiento de servicios con Eureka.
Configuración centralizada con Spring Cloud Config.
Comunicación entre servicios con REST.

Cómo correr el proyecto
Clonar el repositorio:

git clone https://github.com/JPRomanelli94/proyecto_tienda_electrodomesticos.git
cd proyecto_tienda_electrodomesticos

Construir y levantar los contenedores con Docker Compose:
docker-compose up --build

Acceder a los servicios:
Eureka Server: http://localhost:8761
Productos: http://localhost:8083
Carritos: http://localhost:8084
Ventas: http://localhost:8085
Config Server: http://localhost:8081
Api-Gateway: http://localhost:443

Contribuciones
Las contribuciones son bienvenidas. Por favor, abrí un issue o hacé un pull request.
