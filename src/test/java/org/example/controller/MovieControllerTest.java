package org.example.controller;

import org.example.model.Movie;
import org.example.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private MovieService movieService;

    @Test
    void getMoviesShouldReturnAllMovies() throws Exception {
        List<Movie> movies = List.of(
                buildMovie(1, "Akira", 1988, 124, "Sci-Fi", "Tokyo Movie Shinsha", 8.2, "akira.jpg", "Neo-Tokyo on the edge."),
                buildMovie(2, "Spirited Away", 2001, 125, "Fantasy", "Studio Ghibli", 8.6, "spirited-away.jpg", "A girl enters a spirit world.")
        );

        when(movieService.getAll()).thenReturn(movies);

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Akira"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Spirited Away"));

        verify(movieService).getAll();
    }

    @Test
    void getMovieByIdShouldReturnMovie() throws Exception {
        Movie movie = buildMovie(3, "Perfect Blue", 1997, 81, "Thriller", "Madhouse", 8.0, "perfect-blue.jpg", "A singer faces a dark spiral.");

        when(movieService.getMovieById(3)).thenReturn(movie);

        mockMvc.perform(get("/movies/{id}", 3))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.title").value("Perfect Blue"))
                .andExpect(jsonPath("$.genre").value("Thriller"));

        verify(movieService).getMovieById(3);
    }

    @Test
    void postMovieShouldCreateMovie() throws Exception {
        Movie requestMovie = new Movie("Your Name", 2016, 106, "Romance", "CoMix Wave Films", 8.4, "your-name.jpg", "A story of connection.");
        Movie createdMovie = buildMovie(4, "Your Name", 2016, 106, "Romance", "CoMix Wave Films", 8.4, "your-name.jpg", "A story of connection.");

        when(movieService.addMovie(org.mockito.ArgumentMatchers.any(Movie.class))).thenReturn(createdMovie);

        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestMovie)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.title").value("Your Name"))
                .andExpect(jsonPath("$.studio").value("CoMix Wave Films"));

        verify(movieService).addMovie(org.mockito.ArgumentMatchers.any(Movie.class));
    }

    @Test
    void putMovieShouldUpdateMovie() throws Exception {
        Movie requestMovie = new Movie("Princess Mononoke", 1997, 134, "Fantasy", "Studio Ghibli", 8.4, "mononoke.jpg", "A conflict between nature and industry.");
        Movie updatedMovie = buildMovie(5, "Princess Mononoke", 1997, 134, "Fantasy", "Studio Ghibli", 8.4, "mononoke.jpg", "A conflict between nature and industry.");

        when(movieService.updateMovie(org.mockito.ArgumentMatchers.eq(5), org.mockito.ArgumentMatchers.any(Movie.class)))
                .thenReturn(updatedMovie);

        mockMvc.perform(put("/movies/{id}", 5)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestMovie)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.title").value("Princess Mononoke"))
                .andExpect(jsonPath("$.year").value(1997));

        verify(movieService).updateMovie(org.mockito.ArgumentMatchers.eq(5), org.mockito.ArgumentMatchers.any(Movie.class));
    }

    @Test
    void deleteMovieShouldDeleteMovie() throws Exception {
        doNothing().when(movieService).deleteMovie(6);

        mockMvc.perform(delete("/movies/{id}", 6))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(movieService).deleteMovie(6);
    }

    @Test
    void getMoviesAscShouldReturnMoviesOrderedByTitle() throws Exception {
        List<Movie> movies = List.of(
                buildMovie(1, "Akira", 1988, 124, "Sci-Fi", "Tokyo Movie Shinsha", 8.2, "akira.jpg", "Neo-Tokyo on the edge."),
                buildMovie(2, "Howl's Moving Castle", 2004, 119, "Fantasy", "Studio Ghibli", 8.2, "howl.jpg", "A wizard, a curse, and a war.")
        );

        when(movieService.getAllByOrder()).thenReturn(movies);

        mockMvc.perform(get("/movies/asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Akira"))
                .andExpect(jsonPath("$[1].title").value("Howl's Moving Castle"));

        verify(movieService).getAllByOrder();
    }

    private Movie buildMovie(int id, String title, int year, int duration, String genre, String studio, double rating, String poster, String synopsis) {
        Movie movie = new Movie();
        ReflectionTestUtils.setField(movie, "id", id);
        movie.setTitle(title);
        movie.setYear(year);
        movie.setDuration(duration);
        movie.setGenre(genre);
        movie.setStudio(studio);
        movie.setRating(rating);
        movie.setPoster(poster);
        movie.setSynopsis(synopsis);
        return movie;
    }
}
