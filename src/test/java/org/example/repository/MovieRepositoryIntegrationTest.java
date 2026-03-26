package org.example.repository;

import org.example.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MovieRepositoryIntegrationTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void saveShouldPersistAndRetrieveMovieFromH2() {
        Movie movie = new Movie(
                "Suzume",
                2022,
                122,
                "Adventure",
                "CoMix Wave Films",
                7.6,
                "suzume.jpg",
                "A journey through mysterious doors."
        );

        Movie savedMovie = movieRepository.save(movie);
        Optional<Movie> result = movieRepository.findById(savedMovie.getId());

        assertTrue(savedMovie.getId() > 0);
        assertTrue(result.isPresent());
        assertEquals("Suzume", result.get().getTitle());
        assertEquals(2022, result.get().getYear());
        assertEquals(122, result.get().getDuration());
        assertEquals("Adventure", result.get().getGenre());
        assertEquals("CoMix Wave Films", result.get().getStudio());
        assertEquals(7.6, result.get().getRating());
        assertEquals("suzume.jpg", result.get().getPoster());
        assertEquals("A journey through mysterious doors.", result.get().getSynopsis());
    }

    @Test
    void deleteShouldRemoveMovieFromDatabase() {
        Movie savedMovie = movieRepository.save(
                new Movie(
                        "Belle",
                        2021,
                        121,
                        "Drama",
                        "Studio Chizu",
                        7.1,
                        "belle.jpg",
                        "A virtual world and a hidden identity."
                )
        );

        movieRepository.deleteById(savedMovie.getId());

        assertFalse(movieRepository.findById(savedMovie.getId()).isPresent());
    }
}
