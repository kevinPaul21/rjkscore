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

## Arquitectura y análisis técnico

La aplicación sigue el patrón habitual de capas en Spring Boot. Las entidades `AppUser` y `Favorite` residen en el paquete `Domain`; los repositorios JPA se encuentran en `infrastructure/Repository` y la lógica de negocio en `application/service`.

La seguridad se implementa con JWT. En `SecurityConfig` se definen las rutas públicas y se registra el filtro que valida los tokens:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
    http
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.POST, "/api/favorites").authenticated()
            .requestMatchers(HttpMethod.GET, "/api/favorites").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/users/me").authenticated()
            .requestMatchers("/api/auth/**", "/api/pandascore/**", "/api/leagues/**").permitAll()
        )
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
}
```

El filtro `JwtAuthenticationFilter` excluye las rutas públicas y valida el token:

```java
protected boolean shouldNotFilter(HttpServletRequest request) {
    String path = request.getRequestURI();
    return path.startsWith("/api/auth/") ||
           path.startsWith("/api/pandascore/") ||
           path.startsWith("/api/leagues/");
}
```

## Referencia detallada de la API

### Autenticación

- `POST /api/auth/register` – Crea un usuario. Cuerpo de ejemplo:

```json
{
  "username": "jdoe",
  "email": "jdoe@example.com",
  "password": "secreto"
}
```

- `POST /api/auth/login` – Devuelve un JWT que deberá enviarse en la cabecera `Authorization` como `Bearer <token>`.

```json
{
  "usernameOrEmail": "jdoe",
  "password": "secreto"
}
```

### Usuarios

- `GET /api/users` – Lista todos los usuarios.
- `GET /api/users/{id}` – Datos de un usuario por ID.
- `PUT /api/users/me` – Actualiza el usuario autenticado.
- `PUT /api/users/{id}` – Actualiza un usuario concreto.
- `PUT /api/users/{id}/coins` – Modifica las monedas de un usuario.

Fragmento del controlador:

```java
@PutMapping("/me")
public ResponseEntity<AppUserResponseDto> updateCurrentUser(Principal principal, @RequestBody UpdateUserDto dto) {
    try {
        return ResponseEntity.ok(service.updateUser(principal.getName(), dto));
    } catch (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
```

### Favoritos

(Requiere token de autenticación)

- `GET /api/favorites` – Devuelve los favoritos del usuario actual.
- `POST /api/favorites` – Añade un favorito. Ejemplo:

```json
{
  "itemType": "team",
  "itemId": 123
}
```

- `DELETE /api/favorites/{id}` – Elimina un favorito.

Internamente se consulta PandaScore para obtener información del elemento guardado.
Los valores posibles de `itemType` incluyen los genéricos (`team`, `player`, `match`, `tournament`, `videogame`) y otros específicos como `csgo_team`, `csgo_player`, `dota2_team`, `dota2_player`, etc.

```java
switch (type) {
    case "team" -> itemData = pandaScoreApiClient.getTeam(id);
    case "player" -> itemData = pandaScoreApiClient.getPlayer(id);
    case "match" -> itemData = pandaScoreApiClient.getMatch(id);
    // ...
}
```

### Leagues

- `GET /api/leagues` – Lista de ligas obtenidas de SportDevs.

### PandaScore

Bajo `/api/pandascore` existen múltiples rutas para equipos, jugadores, partidos y videojuegos. Por ejemplo:

- `GET /api/pandascore/teams`
- `GET /api/pandascore/players`
- `GET /api/pandascore/matches`
- `GET /api/pandascore/videogames`
- Endpoints específicos de CSGO bajo `/api/pandascore/csgo` (maps, weapons, games, etc.).
- Endpoints de Dota2 bajo `/api/pandascore/dota2` (abilities, heroes, items, matches, etc.).

Todas estas rutas devuelven directamente la respuesta de PandaScore en formato JSON.

### Uso con Postman

1. Realiza una petición `POST /api/auth/login` con tus credenciales y copia el valor `token` de la respuesta.
2. En las peticiones que requieran autenticación añade la cabecera:
   `Authorization: Bearer <token>`.
3. Puedes crear variables en Postman para el `baseUrl` y el token, facilitando las pruebas de los distintos endpoints.

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

