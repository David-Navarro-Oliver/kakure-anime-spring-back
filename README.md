# 🎬 Kakure Anime Spring Back
![Java 25](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Persistence-59666C?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-JSON-0A66C2?style=for-the-badge)
![CRUD](https://img.shields.io/badge/CRUD-Functional-2E8B57?style=for-the-badge)
![React Integrated](https://img.shields.io/badge/React-Integrated-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Postman Tested](https://img.shields.io/badge/Postman-Tested-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

**English version:** [README.en.md](README.en.md)

## 📌 Descripción
![Backend REST](https://img.shields.io/badge/Backend-REST%20API-0A66C2?style=for-the-badge)
![Anime Movies](https://img.shields.io/badge/Domain-Anime%20Movies-E53935?style=for-the-badge)
![MySQL Persistence](https://img.shields.io/badge/Persistence-MySQL-4479A1?style=for-the-badge)
![Validated](https://img.shields.io/badge/Validation-Postman%20%2B%20React-2E8B57?style=for-the-badge)

Kakure Anime Spring Back es el backend REST del proyecto Kakure Anime, orientado a la gestión de películas de anime mediante operaciones CRUD sobre la entidad `Movie`. La aplicación está desarrollada con Spring Boot, persiste la información en MySQL y organiza la lógica en una arquitectura por capas clara y mantenible.

El proyecto está pensado para trabajar de forma directa con un frontend React ya integrado, y su funcionamiento se ha validado tanto desde navegador como mediante colecciones de prueba en Postman.

## 🧱 Arquitectura
![Layered Architecture](https://img.shields.io/badge/Architecture-Layered-6A5ACD?style=for-the-badge)
![Controller Service Repository](https://img.shields.io/badge/Flow-Controller%20%E2%86%92%20Service%20%E2%86%92%20Repository-37474F?style=for-the-badge)
![Spring Boot Config](https://img.shields.io/badge/Config-Spring%20Boot-6DB33F?style=for-the-badge)

La arquitectura del backend sigue una separación clásica por capas:

- `controller`: expone los endpoints REST y recibe las peticiones HTTP.
- `service`: concentra la lógica de negocio del CRUD y la ordenación de resultados.
- `repository`: encapsula el acceso a datos mediante `JpaRepository`.
- `model`: define la entidad `Movie` y su mapeo JPA contra la tabla `movies`.
- configuración Spring Boot: `KakureAnimeSpringBackApplication.java` arranca la aplicación y `application.properties` centraliza la configuración de conexión y JPA.

Flujo principal del backend:

`Controller -> Service -> Repository -> Database`

## 🗂️ Estructura del proyecto
![Project Structure](https://img.shields.io/badge/Structure-Organized-455A64?style=for-the-badge)
![Package](https://img.shields.io/badge/Package-org.example-5C6BC0?style=for-the-badge)
![Spring Layout](https://img.shields.io/badge/Layout-Spring%20Boot-6DB33F?style=for-the-badge)

```text
docs
├── badges
│   └── jacoco-coverage.svg
└── screenshots
    ├── CoberturaKABS.png
    ├── CRUDpostmanKABS.png
    └── CRUDreactKAF.png

src
├── main
│   ├── java
│   │   └── org
│   │       └── example
│   │           ├── controller
│   │           │   └── MovieController.java
│   │           ├── model
│   │           │   └── Movie.java
│   │           ├── repository
│   │           │   └── MovieRepository.java
│   │           ├── service
│   │           │   └── MovieService.java
│   │           └── KakureAnimeSpringBackApplication.java
│   └── resources
│       ├── application.properties
│       ├── static
│       └── templates
└── test
    ├── java
    │   └── org
    │       └── example
    │           ├── controller
    │           │   └── MovieControllerTest.java
    │           ├── repository
    │           │   └── MovieRepositoryIntegrationTest.java
    │           ├── service
    │           │   └── MovieServiceTest.java
    │           ├── KakureAnimeSpringBackApplicationMainTest.java
    │           └── KakureAnimeSpringBackApplicationTests.java
    └── resources
        └── application-test.properties
```

## ⚙️ Tecnologías
![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-Testing-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![React](https://img.shields.io/badge/React-Frontend%20Integration-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![H2](https://img.shields.io/badge/H2-Test%20Database-1E88E5?style=for-the-badge)
![JaCoCo](https://img.shields.io/badge/JaCoCo-Coverage-C62828?style=for-the-badge)

- `Java 25`: lenguaje base del proyecto y versión configurada en Maven.
- `Spring Boot 4.0.4`: arranque de la aplicación, configuración automática y capa web.
- `Spring Data JPA`: persistencia de la entidad `Movie` y acceso al repositorio.
- `MySQL`: base de datos usada para almacenar las películas.
- `Maven`: gestión de dependencias y construcción del proyecto.
- `Postman`: validación manual de endpoints y respuestas del CRUD.
- `Integración con frontend React`: consumo real del backend desde la interfaz cliente.
- `H2`: base de datos en memoria utilizada en los tests de integración.
- `JaCoCo`: generación del reporte de cobertura automatizado.

## 🧠 Modelo de datos
![Movie Entity](https://img.shields.io/badge/Entity-Movie-E53935?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-Table%20movies-59666C?style=for-the-badge)
![CRUD Fields](https://img.shields.io/badge/Fields-9%20Properties-2E8B57?style=for-the-badge)

La entidad principal del backend es `Movie`, mapeada con JPA sobre la tabla `movies`. Representa cada película que el sistema puede listar, crear, consultar, actualizar y eliminar.

| Campo | Tipo | Significado |
| --- | --- | --- |
| `id` | `int` | Identificador único autogenerado de la película. |
| `title` | `String` | Título de la película. |
| `year` | `int` | Año de lanzamiento. |
| `duration` | `int` | Duración total en minutos. |
| `genre` | `String` | Género principal de la película. |
| `studio` | `String` | Estudio responsable de la producción. |
| `rating` | `double` | Valoración numérica asignada a la película. |
| `poster` | `String` | Ruta o URL del póster asociado. |
| `synopsis` | `String` | Resumen argumental de la película. |

## 🔌 Endpoints
![REST Endpoints](https://img.shields.io/badge/Endpoints-REST-0A66C2?style=for-the-badge)
![JSON API](https://img.shields.io/badge/Format-JSON-455A64?style=for-the-badge)
![CRUD Routes](https://img.shields.io/badge/Routes-CRUD-2E8B57?style=for-the-badge)

- `GET /movies`: devuelve el listado completo de películas.
- `GET /movies/{id}`: recupera una película concreta a partir de su identificador y devuelve `404 Not Found` si no existe.
- `POST /movies`: crea una nueva película en la base de datos.
- `PUT /movies/{id}`: actualiza los datos de una película existente y devuelve `404 Not Found` si no existe.
- `DELETE /movies/{id}`: elimina una película por su identificador.
- `GET /movies/asc`: devuelve las películas ordenadas de forma ascendente por `title`.

## 🔄 Flujo CRUD
![Create Read Update Delete](https://img.shields.io/badge/Flow-CRUD-2E8B57?style=for-the-badge)
![Business Layer](https://img.shields.io/badge/Logic-MovieService-6A5ACD?style=for-the-badge)
![Sorted Results](https://img.shields.io/badge/Sort-Title%20ASC-455A64?style=for-the-badge)

- Crear -> `POST /movies`
- Leer todas -> `GET /movies`
- Leer por id -> `GET /movies/{id}`
- Actualizar -> `PUT /movies/{id}`
- Eliminar -> `DELETE /movies/{id}`
- Ordenar ascendente -> `GET /movies/asc`

## 🖥️ Integración con el frontend
![React](https://img.shields.io/badge/Frontend-React-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![CORS](https://img.shields.io/badge/CORS-http%3A%2F%2Flocalhost%3A5173-0A66C2?style=for-the-badge)
![Browser Validation](https://img.shields.io/badge/Validation-Browser%20Tested-2E8B57?style=for-the-badge)

El backend ya está integrado con el frontend React del ecosistema Kakure Anime y se ha validado su consumo en navegador. La API permite operar sobre el catálogo desde la interfaz visual y está preparada para aceptar peticiones desde `http://localhost:5173`.

Operaciones comprobadas desde el frontend:

- listado de películas
- detalle por elemento
- creación de nuevos registros
- edición de registros existentes
- borrado de películas

Repositorio del frontend: https://github.com/David-Navarro-Oliver/kakureAnime

## 🧪 Validación y pruebas
![Postman](https://img.shields.io/badge/Postman-Validated-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Startup%20OK-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Connected-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![CRUD Verified](https://img.shields.io/badge/CRUD-Verified-2E8B57?style=for-the-badge)

El backend se ha comprobado en escenarios reales de uso y validación técnica:

- pruebas manuales con Postman sobre todos los endpoints expuestos
- integración real con el frontend React del proyecto
- operaciones CRUD funcionales sobre la entidad `Movie`
- arranque correcto de Spring Boot con conexión activa a MySQL
- prueba de contexto incluida en `KakureAnimeSpringBackApplicationTests`

## 🧪 Tests y cobertura
![JUnit Jupiter](https://img.shields.io/badge/JUnit%20Jupiter-Automated%20Tests-25A162?style=for-the-badge)
![Mockito](https://img.shields.io/badge/Mockito-Unit%20Testing-6A1B9A?style=for-the-badge)
![MockMvc](https://img.shields.io/badge/MockMvc-Web%20Layer-0A66C2?style=for-the-badge)
![H2](https://img.shields.io/badge/H2-In%20Memory%20DB-1E88E5?style=for-the-badge)
![JaCoCo](https://img.shields.io/badge/JaCoCo-Coverage-C62828?style=for-the-badge)
![Coverage](docs/badges/jacoco-coverage.svg)

El proyecto cuenta con una estrategia automatizada de tests orientada a cubrir el comportamiento real del backend sin alterar su lógica. La suite combina pruebas de contexto, unitarias, de capa web e integración con base de datos en memoria para validar el flujo completo del CRUD, y la cobertura se genera de forma automática con JaCoCo.

Tipos de tests implementados:

- `KakureAnimeSpringBackApplicationTests`: verifica la carga del contexto Spring Boot usando el perfil `test`.
- `KakureAnimeSpringBackApplicationMainTest`: comprueba que el punto de entrada delega correctamente en `SpringApplication.run`.
- `MovieServiceTest`: tests unitarios del servicio con Mockito y repositorio mockeado.
- `MovieControllerTest`: tests de la capa web con `@WebMvcTest`, `MockMvc` y `@MockitoBean`.
- `MovieRepositoryIntegrationTest`: prueba de persistencia real con JPA y H2 en memoria.

Herramientas utilizadas:

- `JUnit Jupiter`
- `Mockito`
- `MockMvc`
- `H2`
- `JaCoCo`
- `Maven`

Comandos principales:

```bash
mvn test
mvn verify
```

Dónde consultar la cobertura:

- reporte HTML: `target/site/jacoco/index.html`
- reporte XML: `target/site/jacoco/jacoco.xml`
- reporte CSV: `target/site/jacoco/jacoco.csv`
- recurso visual reutilizable: `docs/badges/jacoco-coverage.svg`

Cobertura del último reporte generado en local:

- `100%` de instrucciones
- `100%` de ramas
- `100%` de líneas

### Vista del reporte de cobertura
Captura del informe HTML de JaCoCo generado tras la última ejecución local de `mvn verify`.

![Reporte de cobertura JaCoCo](docs/screenshots/CoberturaKABS.png)

## 📸 Capturas
![Frontend Screenshot](https://img.shields.io/badge/Capture-React%20Frontend-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Postman Screenshot](https://img.shields.io/badge/Capture-Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Real Assets](https://img.shields.io/badge/Assets-Project%20Images-455A64?style=for-the-badge)

### Frontend React consumiendo el CRUD de películas
Vista del catálogo de películas en la interfaz React, con registros cargados y acciones disponibles para editar y eliminar.

![Frontend React consumiendo el CRUD de películas](docs/screenshots/CRUDreactKAF.png)

### Validación del CRUD completo en Postman
Comprobación de los distintos métodos REST del backend con respuestas correctas y estado `200 OK`.

![Validación del CRUD completo en Postman](docs/screenshots/CRUDpostmanKABS.png)

## 🚀 Cómo ejecutar el proyecto
![Setup](https://img.shields.io/badge/Setup-Local%20Run-455A64?style=for-the-badge)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Ready-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![MySQL](https://img.shields.io/badge/Database-kakure__anime__db-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

1. Clona el repositorio del backend:

   ```bash
   git clone https://github.com/David-Navarro-Oliver/kakure-anime-spring-back.git
   cd kakure-anime-spring-back
   ```

2. Abre el proyecto en IntelliJ IDEA.
3. Crea una base de datos local en MySQL con el nombre `kakure_anime_db`.
4. Revisa `src/main/resources/application.properties` y configura la conexión a MySQL según tu entorno local.
5. Asegúrate de que la aplicación apunte a una base de datos llamada `kakure_anime_db` y de que las propiedades `spring.datasource.url`, `spring.datasource.username` y `spring.datasource.password` estén ajustadas con tus credenciales locales.
6. Inicia la aplicación ejecutando `KakureAnimeSpringBackApplication`.
7. Prueba los endpoints con Postman para validar el CRUD del backend.
8. Si quieres usar la interfaz cliente, clona y ejecuta el frontend React desde:

   `https://github.com/David-Navarro-Oliver/kakureAnime`

## ✅ Estado actual
![Status](https://img.shields.io/badge/Status-Functional-2E8B57?style=for-the-badge)
![CRUD Complete](https://img.shields.io/badge/CRUD-Complete-0A66C2?style=for-the-badge)
![MySQL Persistence](https://img.shields.io/badge/Persistence-Active-4479A1?style=for-the-badge)
![React Integration](https://img.shields.io/badge/React-Integrated-61DAFB?style=for-the-badge&logo=react&logoColor=black)

El proyecto se encuentra operativo y actualmente soporta un CRUD completo de películas, persistencia en MySQL, integración con frontend React y validación funcional mediante Postman.
También incluye una suite automatizada de tests con cobertura generada mediante JaCoCo.

## 👨‍💻 Autor
![Autor](https://img.shields.io/badge/Autor-David%20Navarro-1F4B99?style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-David--Navarro--Oliver-181717?style=for-the-badge&logo=github&logoColor=white)

**David Navarro**
