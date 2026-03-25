package org.example.service;

import org.example.model.Movie;
import org.example.repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getAllByOrder() {
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }
}