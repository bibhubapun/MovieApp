package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

     private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id) {
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie updatedMovie=movieRepository.getOne(movie.getId());
        updatedMovie.setMovieName(movie.getMovieName());
        updatedMovie.setPlot(movie.getPlot());
        updatedMovie.setReleaseYear(movie.getReleaseYear());
        return movieRepository.save(updatedMovie);
    }
}
