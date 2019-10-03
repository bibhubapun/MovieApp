package com.stackroute.MovieApp.controller;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id)
    {
        return new ResponseEntity<Boolean>(movieService.deleteMovie(id),HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PATCH,value = "user")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie)
    {
        return new ResponseEntity<Movie>(movieService.updateMovie(movie),HttpStatus.OK);
    }
}