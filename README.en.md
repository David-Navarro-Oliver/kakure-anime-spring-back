# 🎬 Kakure Anime Spring Back
![Java 25](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-Persistence-59666C?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![REST API](https://img.shields.io/badge/REST%20API-JSON-0A66C2?style=for-the-badge)
![CRUD](https://img.shields.io/badge/CRUD-Functional-2E8B57?style=for-the-badge)
![React Integrated](https://img.shields.io/badge/React-Integrated-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Postman Tested](https://img.shields.io/badge/Postman-Tested-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

**Spanish version:** [README.md](README.md)

## 📌 Description
![REST Backend](https://img.shields.io/badge/Backend-REST%20API-0A66C2?style=for-the-badge)
![Anime Movies](https://img.shields.io/badge/Domain-Anime%20Movies-E53935?style=for-the-badge)
![MySQL Persistence](https://img.shields.io/badge/Persistence-MySQL-4479A1?style=for-the-badge)
![Validated](https://img.shields.io/badge/Validation-Postman%20%2B%20React-2E8B57?style=for-the-badge)

Kakure Anime Spring Back is the REST backend for the Kakure Anime project. It focuses on anime movie management through CRUD operations over the `Movie` entity. The application is built with Spring Boot, persists data in MySQL, and follows a clear layered architecture that keeps the codebase maintainable.

The project is designed to work directly with an already integrated React frontend, and its behavior has been validated both in the browser and through Postman API testing.

## 🧱 Architecture
![Layered Architecture](https://img.shields.io/badge/Architecture-Layered-6A5ACD?style=for-the-badge)
![Controller Service Repository](https://img.shields.io/badge/Flow-Controller%20%E2%86%92%20Service%20%E2%86%92%20Repository-37474F?style=for-the-badge)
![Spring Boot Config](https://img.shields.io/badge/Config-Spring%20Boot-6DB33F?style=for-the-badge)

The backend follows a classic layered structure:

- `controller`: exposes the REST endpoints and handles HTTP requests.
- `service`: contains CRUD behavior and result ordering logic.
- `repository`: manages data access through `JpaRepository`.
- `model`: defines the `Movie` entity and its JPA mapping to the `movies` table.
- Spring Boot configuration: `KakureAnimeSpringBackApplication.java` boots the application and `application.properties` centralizes datasource and JPA settings.

Main backend flow:

`Controller -> Service -> Repository -> Database`

## 🗂️ Project Structure
![Project Structure](https://img.shields.io/badge/Structure-Organized-455A64?style=for-the-badge)
![Package](https://img.shields.io/badge/Package-org.example-5C6BC0?style=for-the-badge)
![Spring Layout](https://img.shields.io/badge/Layout-Spring%20Boot-6DB33F?style=for-the-badge)

```text
docs
└── screenshots
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
    └── java
        └── org
            └── example
                └── KakureAnimeSpringBackApplicationTests.java
```

## ⚙️ Technologies
![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-Testing-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![React](https://img.shields.io/badge/React-Frontend%20Integration-61DAFB?style=for-the-badge&logo=react&logoColor=black)

- `Java 25`: base language and version configured in Maven.
- `Spring Boot 4.0.4`: application bootstrap, auto-configuration, and web layer.
- `Spring Data JPA`: persistence support for the `Movie` entity and repository access.
- `MySQL`: relational database used to store the movie catalog.
- `Maven`: dependency management and project build tool.
- `Postman`: manual endpoint validation and CRUD testing.
- `React frontend integration`: real client consumption of the backend API.

## 🧠 Data Model
![Movie Entity](https://img.shields.io/badge/Entity-Movie-E53935?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-Table%20movies-59666C?style=for-the-badge)
![CRUD Fields](https://img.shields.io/badge/Fields-9%20Properties-2E8B57?style=for-the-badge)

The core entity of the backend is `Movie`, mapped with JPA to the `movies` table. It represents every movie that the system can list, create, retrieve, update, and delete.

| Field | Type | Meaning |
| --- | --- | --- |
| `id` | `int` | Auto-generated unique identifier for each movie. |
| `title` | `String` | Movie title. |
| `year` | `int` | Release year. |
| `duration` | `int` | Total runtime in minutes. |
| `genre` | `String` | Main movie genre. |
| `studio` | `String` | Production studio. |
| `rating` | `double` | Numeric rating assigned to the movie. |
| `poster` | `String` | Poster path or URL. |
| `synopsis` | `String` | Short plot summary. |

## 🔌 Endpoints
![REST Endpoints](https://img.shields.io/badge/Endpoints-REST-0A66C2?style=for-the-badge)
![JSON API](https://img.shields.io/badge/Format-JSON-455A64?style=for-the-badge)
![CRUD Routes](https://img.shields.io/badge/Routes-CRUD-2E8B57?style=for-the-badge)

- `GET /movies`: returns the full movie list.
- `GET /movies/{id}`: retrieves a single movie by identifier.
- `POST /movies`: creates a new movie entry in the database.
- `PUT /movies/{id}`: updates an existing movie.
- `DELETE /movies/{id}`: removes a movie by identifier.
- `GET /movies/asc`: returns the movies sorted ascending by `title`.

## 🔄 CRUD Flow
![Create Read Update Delete](https://img.shields.io/badge/Flow-CRUD-2E8B57?style=for-the-badge)
![Business Layer](https://img.shields.io/badge/Logic-MovieService-6A5ACD?style=for-the-badge)
![Sorted Results](https://img.shields.io/badge/Sort-Title%20ASC-455A64?style=for-the-badge)

- Create -> `POST /movies`
- Read all -> `GET /movies`
- Read by id -> `GET /movies/{id}`
- Update -> `PUT /movies/{id}`
- Delete -> `DELETE /movies/{id}`
- Sort ascending -> `GET /movies/asc`

## 🖥️ Frontend Integration
![React](https://img.shields.io/badge/Frontend-React-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![CORS](https://img.shields.io/badge/CORS-http%3A%2F%2Flocalhost%3A5173-0A66C2?style=for-the-badge)
![Browser Validation](https://img.shields.io/badge/Validation-Browser%20Tested-2E8B57?style=for-the-badge)

The backend is already integrated with the Kakure Anime React frontend and has been validated in the browser. The API supports catalog operations from the UI and is configured to accept requests from `http://localhost:5173`.

Operations validated from the frontend:

- movie listing
- single item detail
- record creation
- record editing
- movie deletion

Frontend repository: https://github.com/David-Navarro-Oliver/kakureAnime

## 🧪 Validation and Testing
![Postman](https://img.shields.io/badge/Postman-Validated-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Startup%20OK-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Connected-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![CRUD Verified](https://img.shields.io/badge/CRUD-Verified-2E8B57?style=for-the-badge)

The backend has been validated through real usage scenarios and technical checks:

- manual Postman testing across all exposed endpoints
- real integration with the project React frontend
- fully working CRUD operations on the `Movie` entity
- successful Spring Boot startup with active MySQL connectivity
- context loading test included in `KakureAnimeSpringBackApplicationTests`

## 🧪 Tests and Coverage
![JUnit Jupiter](https://img.shields.io/badge/JUnit%20Jupiter-Automated%20Tests-25A162?style=for-the-badge)
![Mockito](https://img.shields.io/badge/Mockito-Unit%20Testing-6A1B9A?style=for-the-badge)
![MockMvc](https://img.shields.io/badge/MockMvc-Web%20Layer-0A66C2?style=for-the-badge)
![H2](https://img.shields.io/badge/H2-In%20Memory%20DB-1E88E5?style=for-the-badge)
![JaCoCo](https://img.shields.io/badge/JaCoCo-Coverage-C62828?style=for-the-badge)
![Coverage](docs/badges/jacoco-coverage.svg)

The project includes an automated testing strategy designed to validate the real backend behavior without changing its business logic. The suite combines context, unit, web layer, and in-memory database integration tests to cover the full CRUD flow.

Implemented test types:

- `KakureAnimeSpringBackApplicationTests`: verifies Spring Boot context loading with the `test` profile.
- `KakureAnimeSpringBackApplicationMainTest`: checks that the application entry point delegates correctly to `SpringApplication.run`.
- `MovieServiceTest`: unit tests for the service layer using Mockito and a mocked repository.
- `MovieControllerTest`: web layer tests with `@WebMvcTest`, `MockMvc`, and `@MockitoBean`.
- `MovieRepositoryIntegrationTest`: real persistence test using JPA and in-memory H2.

Tools used:

- `JUnit Jupiter`
- `Mockito`
- `MockMvc`
- `H2`
- `JaCoCo`
- `Maven`

Main commands:

```bash
mvn test
mvn verify
```

Where to review coverage:

- HTML report: `target/site/jacoco/index.html`
- XML report: `target/site/jacoco/jacoco.xml`
- CSV report: `target/site/jacoco/jacoco.csv`
- reusable visual asset: `docs/badges/jacoco-coverage.svg`

Coverage from the latest local report:

- `100%` instruction coverage
- `100%` branch coverage
- `100%` line coverage

## 📸 Screenshots
![Frontend Screenshot](https://img.shields.io/badge/Capture-React%20Frontend-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Postman Screenshot](https://img.shields.io/badge/Capture-Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Real Assets](https://img.shields.io/badge/Assets-Project%20Images-455A64?style=for-the-badge)

### React frontend consuming the movie CRUD
Catalog view in the React interface, showing several movie records and the available actions to edit or delete them.

![React frontend consuming the movie CRUD](docs/screenshots/CRUDreactKAF.png)

### Full CRUD validation in Postman
Verification of the backend REST methods with successful responses and `200 OK` status.

![Full CRUD validation in Postman](docs/screenshots/CRUDpostmanKABS.png)

## 🚀 How to Run
![Setup](https://img.shields.io/badge/Setup-Local%20Run-455A64?style=for-the-badge)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Ready-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![MySQL](https://img.shields.io/badge/Database-kakure__anime__db-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

1. Clone the backend repository:

   ```bash
   git clone https://github.com/David-Navarro-Oliver/kakure-anime-spring-back.git
   cd kakure-anime-spring-back
   ```

2. Open the project in IntelliJ IDEA.
3. Create a local MySQL database named `kakure_anime_db`.
4. Review `src/main/resources/application.properties` and configure the MySQL connection for your local environment.
5. Make sure the application points to a database named `kakure_anime_db` and that `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` are set with your local credentials.
6. Start the application by running `KakureAnimeSpringBackApplication`.
7. Test the endpoints with Postman to validate the backend CRUD.
8. If you want to use the client UI, clone and run the React frontend from:

   `https://github.com/David-Navarro-Oliver/kakureAnime`

## ✅ Current Status
![Status](https://img.shields.io/badge/Status-Functional-2E8B57?style=for-the-badge)
![CRUD Complete](https://img.shields.io/badge/CRUD-Complete-0A66C2?style=for-the-badge)
![MySQL Persistence](https://img.shields.io/badge/Persistence-Active-4479A1?style=for-the-badge)
![React Integration](https://img.shields.io/badge/React-Integrated-61DAFB?style=for-the-badge&logo=react&logoColor=black)

The project is functional and currently supports a complete movie CRUD, MySQL persistence, React frontend integration, and Postman-based validation.

## 👨‍💻 Author
![Author](https://img.shields.io/badge/Author-David%20Navarro-1F4B99?style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-David--Navarro--Oliver-181717?style=for-the-badge&logo=github&logoColor=white)

**David Navarro**
