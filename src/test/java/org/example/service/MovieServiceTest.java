package org.example.service;

import org.example.model.Movie;
import org.example.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void getAllShouldReturnAllMovies() {
        List<Movie> movies = List.of(
                buildMovie(1, "Akira", 1988, 124, "Sci-Fi", "Tokyo Movie Shinsha", 8.2, "akira.jpg", "Neo-Tokyo on the edge."),
                buildMovie(2, "Your Name", 2016, 106, "Romance", "CoMix Wave Films", 8.4, "your-name.jpg", "A story of connection.")
        );

        when(movieRepository.findAll()).thenReturn(movies);

        List<Movie> result = movieService.getAll();

        assertEquals(2, result.size());
        assertSame(movies, result);
        verify(movieRepository).findAll();
    }

    @Test
    void getMovieByIdShouldReturnMovieWhenItExists() {
        Movie movie = buildMovie(1, "Princess Mononoke", 1997, 134, "Fantasy", "Studio Ghibli", 8.4, "mononoke.jpg", "A conflict between nature and industry.");

        when(movieRepository.findById(1)).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovieById(1);

        assertSame(movie, result);
        assertEquals(1, result.getId());
        verify(movieRepository).findById(1);
    }

    @Test
    void getMovieByIdShouldReturnNullWhenItDoesNotExist() {
        when(movieRepository.findById(99)).thenReturn(Optional.empty());

        Movie result = movieService.getMovieById(99);

        assertNull(result);
        verify(movieRepository).findById(99);
    }

    @Test
    void addMovieShouldPersistMovie() {
        Movie newMovie = new Movie(
                "Ghost in the Shell",
                1995,
                83,
                "Cyberpunk",
                "Production I.G",
                8.0,
                "ghost-in-the-shell.jpg",
                "A cyborg agent tracks a hacker."
        );
        Movie savedMovie = buildMovie(3, "Ghost in the Shell", 1995, 83, "Cyberpunk", "Production I.G", 8.0, "ghost-in-the-shell.jpg", "A cyborg agent tracks a hacker.");

        when(movieRepository.save(newMovie)).thenReturn(savedMovie);

        Movie result = movieService.addMovie(newMovie);

        assertSame(savedMovie, result);
        assertEquals(3, result.getId());
        verify(movieRepository).save(newMovie);
    }

    @Test
    void updateMovieShouldUpdateAndSaveMovieWhenItExists() {
        Movie existingMovie = buildMovie(5, "Old Title", 1990, 90, "Drama", "Old Studio", 6.5, "old.jpg", "Old synopsis.");
        Movie updatedMovie = buildMovie(0, "Perfect Blue", 1997, 81, "Thriller", "Madhouse", 8.0, "perfect-blue.jpg", "A singer faces a dark spiral.");

        when(movieRepository.findById(5)).thenReturn(Optional.of(existingMovie));
        when(movieRepository.save(existingMovie)).thenReturn(existingMovie);

        Movie result = movieService.updateMovie(5, updatedMovie);

        assertSame(existingMovie, result);
        assertEquals("Perfect Blue", result.getTitle());
        assertEquals(1997, result.getYear());
        assertEquals(81, result.getDuration());
        assertEquals("Thriller", result.getGenre());
        assertEquals("Madhouse", result.getStudio());
        assertEquals(8.0, result.getRating());
        assertEquals("perfect-blue.jpg", result.getPoster());
        assertEquals("A singer faces a dark spiral.", result.getSynopsis());

        verify(movieRepository).findById(5);
        verify(movieRepository).save(existingMovie);
    }

    @Test
    void updateMovieShouldReturnNullWhenMovieDoesNotExist() {
        Movie updatedMovie = buildMovie(0, "Paprika", 2006, 90, "Sci-Fi", "Madhouse", 7.7, "paprika.jpg", "Dreams start to merge with reality.");

        when(movieRepository.findById(7)).thenReturn(Optional.empty());

        Movie result = movieService.updateMovie(7, updatedMovie);

        assertNull(result);
        verify(movieRepository).findById(7);
        verify(movieRepository, never()).save(updatedMovie);
    }

    @Test
    void deleteMovieShouldDelegateDeletionToRepository() {
        movieService.deleteMovie(4);

        verify(movieRepository).deleteById(4);
    }

    @Test
    void getAllByOrderShouldRequestAscendingSortByTitle() {
        Sort expectedSort = Sort.by(Sort.Direction.ASC, "title");
        List<Movie> sortedMovies = List.of(
                buildMovie(1, "Akira", 1988, 124, "Sci-Fi", "Tokyo Movie Shinsha", 8.2, "akira.jpg", "Neo-Tokyo on the edge."),
                buildMovie(2, "Spirited Away", 2001, 125, "Fantasy", "Studio Ghibli", 8.6, "spirited-away.jpg", "A girl enters a spirit world.")
        );

        when(movieRepository.findAll(expectedSort)).thenReturn(sortedMovies);

        List<Movie> result = movieService.getAllByOrder();

        assertEquals(2, result.size());
        assertSame(sortedMovies, result);
        assertTrue(result.get(0).getTitle().compareTo(result.get(1).getTitle()) < 0);
        verify(movieRepository).findAll(expectedSort);
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
