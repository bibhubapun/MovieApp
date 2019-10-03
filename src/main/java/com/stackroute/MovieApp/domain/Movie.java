package com.stackroute.MovieApp.domain;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {
    @Id
    int id;
    String movieName;
    String plot;
    int releaseYear;

    public Movie() {
    }

    public Movie(int id, String movieName, String plot, int releaseYear) {
        this.id = id;
        this.movieName = movieName;
        this.plot = plot;
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", plot='" + plot + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
