package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public boolean deleteMovie(int id);
    public Movie updateMovie(Movie movie);
    public List<Movie> getMovieByName(String name);

}
