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

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie addMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Movie updateMovie(int id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);

        if (existingMovie == null) {
            return null;
        }

        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setYear(updatedMovie.getYear());
        existingMovie.setDuration(updatedMovie.getDuration());
        existingMovie.setGenre(updatedMovie.getGenre());
        existingMovie.setStudio(updatedMovie.getStudio());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setPoster(updatedMovie.getPoster());
        existingMovie.setSynopsis(updatedMovie.getSynopsis());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getAllByOrder() {
        return movieRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }
}