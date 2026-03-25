package org.example.controller;

import org.example.model.Movie;
import org.example.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie newMovie) {
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovieById(@PathVariable int id, @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(id, updatedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovieById(@PathVariable int id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/movies/asc")
    public List<Movie> getAllMoviesByOrder() {
        return movieService.getAllByOrder();
    }
}