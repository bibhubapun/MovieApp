package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exception.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exception.MovieNotFoundException;
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
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
           if(movieRepository.existsById(movie.getId())){
               throw new MovieAlreadyExistsException("Movie Already Exists");
           }
            Movie savedMovie = movieRepository.save(movie);
            return savedMovie;

    }

    @Override
    public List<Movie> getAllMovies() throws MovieNotFoundException {
        if(movieRepository.count()==0){
            throw new MovieNotFoundException("Movies not found");
        }
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException{
        if(movieRepository.existsById(id)){
            throw new MovieNotFoundException("Movie to be deleted not found");
        }
        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException{
        if(movieRepository.existsById(movie.getId())){
            throw new MovieNotFoundException("Movie to be updated not found");
        }
        Movie updatedMovie=movieRepository.getOne(movie.getId());
        updatedMovie.setMovieName(movie.getMovieName());
        updatedMovie.setPlot(movie.getPlot());
        updatedMovie.setReleaseYear(movie.getReleaseYear());
        return movieRepository.save(updatedMovie);
    }

    @Override
    public List<Movie> getMovieByName(String name) {
      return movieRepository.getMovieByName(name);
    }
}
