# RJK Score - Backend

Este repositorio contiene la parte de servidor de **RJK Score**, un proyecto realizado como Trabajo Fin de Grado. La aplicación está desarrollada con **Spring Boot** y expone una API REST para la gestión de usuarios, favoritos y la consulta de datos de esports a través de PandaScore y SportDevs.

## Requisitos

- Java 21
- Maven
- Una base de datos MySQL

## Configuración

Antes de iniciar el servicio deben proporcionarse varias variables de entorno:

- `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME` y `SPRING_DATASOURCE_PASSWORD`: datos de conexión a MySQL.
- `JWT_SECRET_KEY`: clave secreta usada para firmar y validar los tokens JWT.

Opcionalmente pueden configurarse los tokens de PandaScore y SportDevs mediante las propiedades `pandascore.api.token` y `sportdevs.api.token` en `application.properties`.

Ejemplo de configuración:

```bash
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/rjk_score"
export SPRING_DATASOURCE_USERNAME=root
export SPRING_DATASOURCE_PASSWORD=contraseña
export JWT_SECRET_KEY=mi_clave_secreta
```

## Ejecución

El proyecto utiliza Maven. Para compilar y ejecutar la aplicación localmente:

```bash
./mvnw spring-boot:run
```

Las migraciones de base de datos se encuentran en `src/main/java/rjkscore/Resources/db/migration` y se aplicarán al iniciar la aplicación.

## Endpoints principales

La API está dividida en varios controladores bajo el prefijo `/api`.

### Autenticación

- `POST /api/auth/register` &ndash; Registro de nuevos usuarios.
- `POST /api/auth/login` &ndash; Inicio de sesión. Devuelve un JWT que debe incluirse en la cabecera `Authorization` en las peticiones protegidas.

### Usuarios

- `GET /api/users` &ndash; Lista todos los usuarios.
- `GET /api/users/{id}` &ndash; Obtiene los datos de un usuario por ID.
- `PUT /api/users/me` &ndash; Actualiza el usuario autenticado.
- `PUT /api/users/{id}` &ndash; Actualiza un usuario concreto.
- `PUT /api/users/{id}/coins` &ndash; Modifica las monedas de un usuario.

### Favoritos

(Requiere autenticación)

- `GET /api/favorites` &ndash; Devuelve los favoritos del usuario actual.
- `POST /api/favorites` &ndash; Añade un nuevo favorito.
- `DELETE /api/favorites/{id}` &ndash; Elimina un favorito.

### Leagues

- `GET /api/leagues` &ndash; Obtiene todas las ligas (SportDevs).

### PandaScore (equipos, jugadores, partidos...)

Bajo `/api/pandascore` están disponibles múltiples endpoints para consultar datos en PandaScore:

- `GET /api/pandascore/teams`, `/teams/{id}` y recursos relacionados (ligas, partidos, torneos).
- `GET /api/pandascore/players`, `/players/{id}` y subrutas equivalentes.
- `GET /api/pandascore/matches`, `/matches/past`, `/matches/running`, etc.
- `GET /api/pandascore/videogames`, `/videogames/{id}`, etc.

Consultar los controladores en `src/main/java/rjkscore/infrastructure/Controller` para ver el listado completo de rutas.

## Estructura del código

- `Domain`: Entidades JPA como `AppUser` y `Favorite`.
- `infrastructure/Repository`: Interfaces de acceso a datos con Spring Data JPA.
- `application/mapper`: Mapeadores entre entidades y DTOs.
- `application/service` y `application/service/impl`: Capas de servicio que contienen la lógica de negocio. Se encargan de tratar con los repositorios, validar datos y llamar a los clientes externos.
- `infrastructure/Client`: Clientes HTTP para PandaScore (`PandaScoreApiClient`) y SportDevs (`SportDevsApiClient`).
- `configuration`: Configuración de seguridad, filtros JWT y beans comunes.
- `infrastructure/Controller`: Controladores REST que exponen la API.

La seguridad está basada en JWT. El filtro `JwtAuthenticationFilter` se registra en `SecurityConfig` y valida el token presente en la cabecera `Authorization`. Solo algunos endpoints requieren autenticación, configurados también en `SecurityConfig`.

## Pruebas

El proyecto incluye una prueba básica en `src/test/java/rjkscore/RjkScoreApplicationTests.java` que verifica la carga del contexto de Spring Boot.

## Licencia

Este proyecto se distribuye sin licencia explícita. Consultar con los autores para uso o distribución.

